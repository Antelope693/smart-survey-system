-- 1. 进入数据库
USE smart_survey;

-- 2. 关闭外键检查（为了能顺利清空表）
SET FOREIGN_KEY_CHECKS = 0;

-- 3. 清空数据并重置自增 ID
TRUNCATE TABLE answer_detail;
TRUNCATE TABLE user_response;
TRUNCATE TABLE option_item;
TRUNCATE TABLE question;
TRUNCATE TABLE questionnaire;

-- 4. 开启外键检查
SET FOREIGN_KEY_CHECKS = 1;

-- 5. 插入问卷
INSERT INTO questionnaire (id, title, description, create_time, status) 
VALUES (1, '2025年程序员现状调查', '本问卷旨在了解开发者的技能栈与满意度', NOW(), 1);

-- 6. 插入题目
-- 注意这里的 id 分别是 1, 2, 3
INSERT INTO question (id, content, type, question_order, questionnaire_id) VALUES 
(1, '你最常用的编程语言是什么？', 1, 1, 1),
(2, '你感兴趣的技术领域有哪些？', 2, 2, 1),
(3, '你对目前的工作环境有什么建议？', 3, 3, 1);

-- 7. 插入选项 (对应的 question_id 必须是上面存在的 1 或 2)
INSERT INTO option_item (id, option_text, option_order, question_id) VALUES 
(101, 'Java', 1, 1),
(102, 'Python', 2, 1),
(103, 'Go', 3, 1),
(104, 'PHP', 4, 1), 
(201, '人工智能', 1, 2),
(202, '大数据分析', 2, 2),
(203, '云原生/容器化', 3, 2),
(204, '前端开发', 4, 2);

-- 8. 插入用户提交记录
INSERT INTO user_response (id, responder_ip, submit_time, questionnaire_id) VALUES 
(1, '192.168.1.5', NOW(), 1),
(2, '192.168.1.10', NOW(), 1),
(3, '192.168.1.15', NOW(), 1);

-- 9. 插入答案详情
INSERT INTO answer_detail (selected_option_ids, text_answer, question_id, response_id) VALUES 
('101', NULL, 1, 1),
('201,203', NULL, 2, 1),
(NULL, '希望增加更多带薪年假', 3, 1),
('101', NULL, 1, 2),
('202,203', NULL, 2, 2),
(NULL, '公司零食种类可以再多一点', 3, 2),
('102', NULL, 1, 3);

SELECT * FROM user_response;
SELECT * FROM answer_detail;