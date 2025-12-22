package com.example.smartsurveysystem.repository;

import com.example.smartsurveysystem.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    // 添加一个自定义查询方法：根据问卷ID查找所有问题
    List<Question> findAllByQuestionnaireId(Long questionnaireId);
}