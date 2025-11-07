package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class AuthController {

    @GetMapping
    public String showLoginPage(Model model) {
        // セッション初期化など必要ならここで処理
        return "login";
    }
    
    @GetMapping("/accountmake")
    public String showAccountMakePage(Model model) {
        // ユーザー登録画面表示
        return "accountmake";
    }

    @PostMapping("/login")
    public String handleLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        // 仮の認証ロジック（本番ではDB照合や暗号化が必要）
        if ("admin".equals(username) && "0000".equals(password)) {
        	//認証成功時は  にリダイレクト → AdminController に処理が移る
            return "redirect:/admin";
        } else if ("user".equals(username) && "1111".equals(password)) {
            return "redirect:/main"; 
        } else {
            model.addAttribute("errorMessage", "ユーザー名またはパスワードが正しくありません");
            return "login"; // 認証失敗時に再表示
        }
    }


    @PostMapping("/main")
    public String showMainPage(Model model) {
        // ログイン済みユーザー向けメイン画面
        return "main.html";
    }
}