INSERT INTO category (category_name, created_at, updated_at) 
VALUES ('JAVA', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO questions (category_id,question_text, explanation, created_at, updated_at) 
VALUES (1, 'テストテスト', '解説', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO test_sessions (user_id,category_id, question_count, started_at, finished_at, score, created_at, updated_at) 
VALUES (1, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);