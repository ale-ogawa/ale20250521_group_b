package com.example.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.webapp.entity.Account;
import com.example.webapp.form.UserForm;
import com.example.webapp.repository.AccountMapper;

@Controller
public class RegisterController {

    @Autowired
    private AccountMapper accountMapper;

    // ==============================
    // ✅ 登録画面の表示
    // ==============================
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    // ==============================
    // ✅ フォーム送信処理
    // ==============================
    @PostMapping("/register")
    public String submitRegisterForm(@ModelAttribute("userForm") UserForm userForm, Model model) {

        boolean hasError = false;

        // --- ニックネームのバリデーション ---
        String nicknameError = userForm.validateNickname();
        if (nicknameError != null) {
            model.addAttribute("errorNickname", nicknameError);
            hasError = true;
        }

        // --- 「その他」入力欄のバリデーション ---
        String otherError = userForm.validateOther();
        if (otherError != null) {
            model.addAttribute("errorOther", otherError);
            hasError = true;
        }

        // ✅ エラーがある場合：同じ画面に戻す
        if (hasError) {
            // 入力済みデータを保持したまま再表示
            model.addAttribute("userForm", userForm);
            return "register";
        }

        // ==============================
        // ✅ エラーなし → DB登録処理
        // ==============================
        Account account = new Account();
        account.setNickname(userForm.getNickname());
        account.setAttribute(true); // 固定値（必要に応じて変更）
        account.setAddress(null);
        account.setPassword(null);
        account.setGroupId(null);
        account.setFollowId(null);

        accountMapper.insert(account);

        // ==============================
        // ✅ 登録成功時：完了ページへ
        // ==============================
        return "test";
    }
}
