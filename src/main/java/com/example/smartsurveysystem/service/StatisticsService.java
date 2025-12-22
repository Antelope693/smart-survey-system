package com.example.smartsurveysystem.service;

import java.util.List;
import java.util.Map;

public interface StatisticsService {
    // 获取问卷基础概况（如总提交人数）
    Map<String, Object> getQuestionnaireStatistics(Long questionnaireId);

    // 获取单题统计
    Map<String, Object> getQuestionStatistics(Long questionId);

    // 获取整份问卷所有题目的全量分析列表
    List<Map<String, Object>> getFullQuestionnaireAnalysis(Long questionnaireId);
}