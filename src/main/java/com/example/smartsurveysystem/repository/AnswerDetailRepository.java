package com.example.smartsurveysystem.repository;

import com.example.smartsurveysystem.entity.AnswerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AnswerDetailRepository extends JpaRepository<AnswerDetail, Long> {
    // 查找某个问题的回答详情 (用于统计该问题的答案)
    List<AnswerDetail> findAllByQuestionId(Long questionId);
}