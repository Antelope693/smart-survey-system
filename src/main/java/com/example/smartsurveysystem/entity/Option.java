package com.example.smartsurveysystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 选项实体类：映射到数据库中的 option_item 表
 */
@Entity
@Table(name = "option_item")
@Data
@NoArgsConstructor
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question; // 所属问题外键

    @Column(nullable = false)
    private String optionText; // 选项内容

    private Integer optionOrder; // 选项顺序
}