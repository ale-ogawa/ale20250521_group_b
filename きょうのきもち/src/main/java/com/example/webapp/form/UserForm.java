package com.example.webapp.form;


import java.util.List;

import lombok.Data;

@Data
public class UserForm {

    private String nickname;        // ニックネーム
    private List<String> disorders; // チェックボックスの値（複数）
    private String other;           // 「その他」の入力欄

    /**
     * disorders → choice番号へ変換
     * （最初に選択された疾患をDB登録用IDに変換）
     */
    public Integer getSelectedChoiceId() {
        if (disorders == null || disorders.isEmpty()) {
            return null;
        }

        String first = disorders.get(0);
        switch (first) {
            case "うつ": return 1;
            case "そううつ": return 2;
            case "パニック障害": return 3;
            case "その他": return 4;
            default: return null;
        }
    }

    // ==============================
    // ✅ 入力チェック（Controllerで利用）
    // ==============================

    /** ニックネームのバリデーション */
    public String validateNickname() {
        if (nickname == null || nickname.isEmpty()) {
            return "ニックネームを入力してください。";
        }
        if (nickname.length() > 10) {
            return "ニックネームは10文字以内で入力してください。";
        }
        return null; // エラーなし
    }

    /** 「その他」欄のバリデーション */
    public String validateOther() {
        if (other != null && other.length() > 30) {
            return "その他は30文字以内で入力してください。";
        }
        return null; // エラーなし
    }
}
