package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Choice;
import com.example.demo.entity.QuestionForm;
import com.example.demo.entity.TestSession;

@Service
public class RegistService {

    public void save(QuestionForm form) {
        // 実際の保存処理（DB登録など）を書く
        System.out.println("問題を保存しました: " + form.getTitle());
    }
    
    public QuestionForm getNextQuestion(TestSession session) {
        // セッションの currentNo に基づいて問題を取得
        if (session.getCurrentNo() > session.getTotalNo()) {
            return null; // 終了
        }

        QuestionForm question = new QuestionForm();
        question.setText("Javaでint型の最大値は？");
        question.setExplanation("int型の最大値は 2,147,483,647 です。");

        // ✅ ここに選択肢を追加
        question.setChoices(List.of(
            new Choice(1L, "int"),
            new Choice(2L, "String"),
            new Choice(3L, "boolean"),
            new Choice(4L, "ArrayList")
        ));

        // セッションの進捗を更新（必要なら）
        session.incrementCurrentNo();

        return question;
    }


    
}