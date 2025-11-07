DROP TABLE IF EXISTS user_weak_questions, category, questions, choices, test_answers, test_sessions, users; 

CREATE TABLE user_weak_questions (
  id serial NOT NULL
  , user_id integer NOT NULL
  , question_id integer
  , delete_flag boolean
  , created_at timestamp DEFAULT CURRENT_TIMESTAMP
  , updated_at timestamp DEFAULT CURRENT_TIMESTAMP
  , CONSTRAINT user_weak_questions_PKC PRIMARY KEY (id)
) ;

-- カテゴリー
-- * RestoreFromTempTable
CREATE TABLE category (
  id serial NOT NULL
  , category_name varchar(20)
  , created_at timestamp DEFAULT CURRENT_TIMESTAMP
  , updated_at timestamp DEFAULT CURRENT_TIMESTAMP
  , CONSTRAINT category_PKC PRIMARY KEY (id)
) ;

ALTER TABLE category ADD CONSTRAINT category_name
  UNIQUE (category_name,id) ;

ALTER TABLE category ADD CONSTRAINT id
  UNIQUE (id) ;

-- 問題文テーブル
-- * RestoreFromTempTable
CREATE TABLE questions (
  id serial NOT NULL
  , category_id integer
  , question_text text
  , explanation text
  , updated_at timestamp DEFAULT CURRENT_TIMESTAMP
  , created_at timestamp DEFAULT CURRENT_TIMESTAMP
  , CONSTRAINT questions_PKC PRIMARY KEY (id)
) ;

ALTER TABLE questions ADD CONSTRAINT question_text
  UNIQUE (question_text) ;

-- 選択肢
-- * RestoreFromTempTable
CREATE TABLE choices (
  id serial NOT NULL
  , question_id integer NOT NULL
  , choice_text text
  , is_correct boolean
  , created_at timestamp DEFAULT CURRENT_TIMESTAMP
  , updated_at timestamp DEFAULT CURRENT_TIMESTAMP
  , CONSTRAINT choices_PKC PRIMARY KEY (id)
) ;

-- テストごとの回答詳細
-- * RestoreFromTempTable
CREATE TABLE test_answers (
  id serial NOT NULL
  , test_session_id integer NOT NULL
  , question_id integer NOT NULL
  , choice_id integer
  , is_correct boolean
  , answered_at timestamp DEFAULT CURRENT_TIMESTAMP
  , created_at timestamp DEFAULT CURRENT_TIMESTAMP
  , updated_at timestamp DEFAULT CURRENT_TIMESTAMP
  , CONSTRAINT test_answers_PKC PRIMARY KEY (id)
) ;

-- テストセッション
-- * RestoreFromTempTable
CREATE TABLE test_sessions (
  id serial NOT NULL
  , user_id integer NOT NULL
  , category_id integer
  , question_count integer
  , started_at timestamp DEFAULT CURRENT_TIMESTAMP
  , finished_at timestamp DEFAULT CURRENT_TIMESTAMP
  , score integer
  , created_at timestamp DEFAULT CURRENT_TIMESTAMP
  , updated_at timestamp DEFAULT CURRENT_TIMESTAMP
  , CONSTRAINT test_sessions_PKC PRIMARY KEY (id)
) ;

-- ユーザーテーブル
-- * RestoreFromTempTable
CREATE TABLE users (
  id serial NOT NULL
  , username varchar(20)
  , password varchar(255)
  , role integer
  , created_at timestamp DEFAULT CURRENT_TIMESTAMP
  , updated_at timestamp DEFAULT CURRENT_TIMESTAMP
  , is_deleted boolean
  , CONSTRAINT users_PKC PRIMARY KEY (id)
) ;

COMMENT ON TABLE user_weak_questions IS '苦手リスト';
COMMENT ON COLUMN user_weak_questions.id IS '苦手リストID';
COMMENT ON COLUMN user_weak_questions.user_id IS 'ユーザーID';
COMMENT ON COLUMN user_weak_questions.question_id IS '問題ID';
COMMENT ON COLUMN user_weak_questions.delete_flag IS '論理削除:0=苦手リスト入り、1=削除済';
COMMENT ON COLUMN user_weak_questions.created_at IS '作成日時';
COMMENT ON COLUMN user_weak_questions.updated_at IS '更新日時';

COMMENT ON TABLE category IS 'カテゴリー';
COMMENT ON COLUMN category.id IS 'カテゴリーID';
COMMENT ON COLUMN category.category_name IS 'カテゴリー名';
COMMENT ON COLUMN category.created_at IS '作成日時';
COMMENT ON COLUMN category.updated_at IS '更新日時';

COMMENT ON TABLE questions IS '問題文テーブル';
COMMENT ON COLUMN questions.id IS '問題文ID';
COMMENT ON COLUMN questions.category_id IS 'カテゴリーID';
COMMENT ON COLUMN questions.question_text IS '問題文';
COMMENT ON COLUMN questions.explanation IS '解説';
COMMENT ON COLUMN questions.updated_at IS '更新日時';
COMMENT ON COLUMN questions.created_at IS '作成日時';

COMMENT ON TABLE choices IS '選択肢';
COMMENT ON COLUMN choices.id IS '選択肢ID';
COMMENT ON COLUMN choices.question_id IS '問題ID';
COMMENT ON COLUMN choices.choice_text IS '選択肢テキスト';
COMMENT ON COLUMN choices.is_correct IS '正解かどうか';
COMMENT ON COLUMN choices.created_at IS '作成日時';
COMMENT ON COLUMN choices.updated_at IS '更新日時';

COMMENT ON TABLE test_answers IS 'テストごとの回答詳細';
COMMENT ON COLUMN test_answers.id IS '回答ID';
COMMENT ON COLUMN test_answers.test_session_id IS 'どのテストセッションの回答か';
COMMENT ON COLUMN test_answers.question_id IS '問題ID';
COMMENT ON COLUMN test_answers.choice_id IS 'ユーザーが選択した選択肢ID';
COMMENT ON COLUMN test_answers.is_correct IS '正解かどうか:true=正解';
COMMENT ON COLUMN test_answers.answered_at IS '回答日時';
COMMENT ON COLUMN test_answers.created_at IS '作成日時';
COMMENT ON COLUMN test_answers.updated_at IS '更新日時';

COMMENT ON TABLE test_sessions IS 'テストセッション';
COMMENT ON COLUMN test_sessions.id IS 'テストセッションID';
COMMENT ON COLUMN test_sessions.user_id IS 'テストを受けたユーザーID';
COMMENT ON COLUMN test_sessions.category_id IS '選択したカテゴリーID';
COMMENT ON COLUMN test_sessions.question_count IS '選択した問題数';
COMMENT ON COLUMN test_sessions.started_at IS 'テスト開始日時';
COMMENT ON COLUMN test_sessions.finished_at IS 'テスト終了日時';
COMMENT ON COLUMN test_sessions.score IS '正当数';
COMMENT ON COLUMN test_sessions.created_at IS '作成日時';
COMMENT ON COLUMN test_sessions.updated_at IS '更新日時';

COMMENT ON TABLE users IS 'ユーザーテーブル';
COMMENT ON COLUMN users.id IS 'ユーザーID';
COMMENT ON COLUMN users.username IS 'ユーザー名';
COMMENT ON COLUMN users.password IS 'パスワード';
COMMENT ON COLUMN users.role IS '役割:0=ユーザー,1=管理者';
COMMENT ON COLUMN users.created_at IS '作成日時';
COMMENT ON COLUMN users.updated_at IS '更新日時';
COMMENT ON COLUMN users.is_deleted IS '退会機能:true=退会済';