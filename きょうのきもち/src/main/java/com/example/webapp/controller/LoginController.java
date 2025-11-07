/**package com.example.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.webapp.form.UserForm;

@Controller
public class LoginController {

    /** 
     * 選択画面（トップページ）
    
    @GetMapping("/select")
    public String selectPage() {
        return "select";  // templates/select.html を表示
    }

    /**
     * 患者さん（ユーザー情報登録画面）
     
    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute("userForm") UserForm form, BindingResult result) {
        if (form.getNickname() == null || form.getNickname().length() > 10) {
            result.rejectValue("nickname", "error.nickname", "ニックネームは10字以内で入力してください");
        }

        if (result.hasErrors()) {
            return "register";
        }

        // 正常処理（DB登録など）
        return "redirect:/code";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    /**
     * 招待された方（招待コード入力画面）
    
    @GetMapping("/code")
    public String codePage() {
        return "code";  // templates/code.html を表示
    }
}--------------------------------大神修正以降が修正分**/

package com.example.webapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/select")
    public String selectPage() {
        return "select";
    }

    // ✅ /code は削除
}
