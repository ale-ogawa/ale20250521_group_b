package com.example.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.webapp.form.CodeForm;

@Controller
public class CodeController {

    // 招待コード入力画面を表示（初回アクセス時）
    @GetMapping("/code")
    public String showCodeForm(Model model) {
        model.addAttribute("codeForm", new CodeForm());
        return "code";
    }

    // 招待コード送信処理
    @PostMapping("/verifyCode")
    public String verifyCode(@ModelAttribute("codeForm") CodeForm codeForm, Model model) {

        String inputCode = codeForm.getCode();
        String correctCode = "qn98ynp40"; // ✅ 仮の正解コード（DB照合にしてもOK）

        // 入力されたコードが違う場合
        if (!correctCode.equals(inputCode)) {
            model.addAttribute("error", "招待コードが違います");
            return "code"; // ❌ redirectしない → 無限ループ防止
        }

        // ✅ 正しいコードなら次の画面へ
        return "redirect:/home";
    }
}
