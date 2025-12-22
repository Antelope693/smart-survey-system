package com.example.smartsurveysystem.repository;

import com.example.smartsurveysystem.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Long> {
    // 添加一个自定义查询方法：根据问题ID查找所有选项
    List<Option> findAllByQuestionId(Long questionId);
}