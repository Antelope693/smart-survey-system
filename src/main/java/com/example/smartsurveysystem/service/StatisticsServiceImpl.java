package com.example.smartsurveysystem.service;

import com.example.smartsurveysystem.entity.*;
import com.example.smartsurveysystem.repository.*;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final UserResponseRepository userResponseRepository;
    private final QuestionRepository questionRepository;
    private final AnswerDetailRepository answerDetailRepository;
    private final OptionRepository optionRepository;

    public StatisticsServiceImpl(UserResponseRepository userResponseRepository,
                                 QuestionRepository questionRepository,
                                 AnswerDetailRepository answerDetailRepository,
                                 OptionRepository optionRepository) {
        this.userResponseRepository = userResponseRepository;
        this.questionRepository = questionRepository;
        this.answerDetailRepository = answerDetailRepository;
        this.optionRepository = optionRepository;
    }

    @Override
    public Map<String, Object> getQuestionnaireStatistics(Long questionnaireId) {
        Map<String, Object> stats = new HashMap<>();
        List<UserResponse> responses = userResponseRepository.findAllByQuestionnaireId(questionnaireId);
        stats.put("totalSubmissions", responses.size());
        stats.put("lastSubmitTime", responses.isEmpty() ? null :
                responses.get(responses.size() - 1).getSubmitTime());
        return stats;
    }

    @Override
    public Map<String, Object> getQuestionStatistics(Long questionId) {
        Question question = questionRepository.findById(questionId).orElse(null);
        if (question == null) return null;

        Map<String, Object> stats = new HashMap<>();
        stats.put("questionId", questionId);
        stats.put("questionContent", question.getContent());
        stats.put("questionType", question.getType());

        List<AnswerDetail> details = answerDetailRepository.findAllByQuestionId(questionId);
        int totalResponders = details.size();
        stats.put("totalResponses", totalResponders);

        if (question.getType() == 3) { // 文本题
            List<String> texts = details.stream()
                    .map(AnswerDetail::getTextAnswer)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            stats.put("textAnswers", texts);
        } else { // 选择题
            List<Option> allOptions = optionRepository.findAllByQuestionId(questionId);
            Map<String, Integer> countMap = new HashMap<>();
            for (AnswerDetail detail : details) {
                if (detail.getSelectedOptionIds() != null) {
                    String[] ids = detail.getSelectedOptionIds().split(",");
                    for (String id : ids) {
                        countMap.merge(id.trim(), 1, Integer::sum);
                    }
                }
            }

            List<Map<String, Object>> chartData = new ArrayList<>();
            for (Option opt : allOptions) {
                Map<String, Object> item = new HashMap<>();
                int count = countMap.getOrDefault(opt.getId().toString(), 0);
                double percentage = totalResponders > 0 ? (count * 100.0 / totalResponders) : 0;

                item.put("label", opt.getOptionText());
                item.put("value", count);
                item.put("percent", String.format("%.2f%%", percentage));
                chartData.add(item);
            }
            stats.put("chartData", chartData);
        }
        return stats;
    }

    @Override
    public List<Map<String, Object>> getFullQuestionnaireAnalysis(Long questionnaireId) {
        List<Question> questions = questionRepository.findAllByQuestionnaireId(questionnaireId);
        questions.sort(Comparator.comparing(Question::getQuestionOrder));

        List<Map<String, Object>> analysisList = new ArrayList<>();
        for (Question q : questions) {
            analysisList.add(getQuestionStatistics(q.getId()));
        }
        return analysisList;
    }
}