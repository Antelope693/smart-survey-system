package com.example.smartsurveysystem.controller;

import com.example.smartsurveysystem.entity.Questionnaire;
import com.example.smartsurveysystem.service.QuestionnaireService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/questionnaires")
public class QuestionnaireController {

    private final QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    /**
     * 对应职责：问卷发布接口
     * 作用：前端调用此接口展示问卷内容供用户填写
     */
    @GetMapping("/{id}/render")
    public ResponseEntity<Questionnaire> renderQuestionnaire(@PathVariable Long id) {
        return ResponseEntity.ok(questionnaireService.getFullQuestionnaire(id));
    }

    /**
     * 对应职责：数据收集接口
     * 作用：接收用户填写的 JSON 并存入数据库
     */
    @PostMapping("/{id}/submit")
    public ResponseEntity<String> submitResponse(
            @PathVariable Long id,
            @RequestBody Map<String, Object> answers,
            HttpServletRequest request) {

        String ip = request.getRemoteAddr(); // 获取答题人IP
        questionnaireService.saveResponse(id, answers, ip);
        return ResponseEntity.ok("提交成功！感谢参与。");
    }
}