package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.QuestionForm;
import com.example.demo.service.CategoryService;
import com.example.demo.service.RegistService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class AdminController {

	private final CategoryService categoryService;
    private final RegistService questionService;

	
	@GetMapping("/admin")
    public String showAdminPage(Model model) {
        return "admin"; // templates/admin.html を表示
    }

	
    @GetMapping("/csv")
    public String showCsvUploadPage() {
        return "csvImport";
    }
    
    @GetMapping("/mondaishinki")
    public String showCreateQuestionPage(Model model) {
        model.addAttribute("questionForm", new QuestionForm());
        // カテゴリ一覧など必要ならここで取得して model に追加
        return "mondaishinki"; // templates/mondaishinki.html を表示
    }
    
    @PostMapping("/admin/question/")
    public String createQuestion(
        @ModelAttribute @Valid QuestionForm form,
        BindingResult result,
        Model model
    ) {
        if (result.hasErrors()) {
            // バリデーションエラー時はそのままフォーム再表示
            model.addAttribute("categories", categoryService.getAll()); // ←カテゴリ再設定
            return "mondaishinki";
        }

        // 登録処理（DB保存など）
        questionService.save(form);

        // 登録後は空のフォームで再表示（リダイレクト）
        return "redirect:/admin/question/";
    }

    @GetMapping("/admin/question/")
    public String showCreateQuestionForm(Model model) {
        model.addAttribute("questionForm", new QuestionForm());
        model.addAttribute("categories", categoryService.getAll()); // ←カテゴリ一覧を渡す
        return "mondaishinki";
    }
    


    @GetMapping("/confirm")
    public String showConfirmPage(HttpSession session, Model model) {
        QuestionForm form = (QuestionForm) session.getAttribute("questionForm");
        model.addAttribute("questionForm", form);
        return "confirm.html";
    }

    @GetMapping("/complete")
    public String showCompletePage() {
        return "complete.html";
    }

    @GetMapping("/mondaishousai")
    public String showQuestionDetail(@RequestParam Long questionId, Model model) {
        // 問題詳細取得処理
        return "mondaishosai.html";
    }

    @GetMapping("/mondaiedit")
    public String showEditPage(@RequestParam Long questionId, Model model) {
        // 編集対象の問題をModelに設定
        return "mondaiedit.html";
    }

    @PostMapping("/editconfirm")
    public String confirmEdit(@ModelAttribute @Valid QuestionForm form, HttpSession session) {
        session.setAttribute("editForm", form);
        return "editconfirm.html";
    }

    @GetMapping("/editcomplete")
    public String showEditCompletePage() {
        return "editcomplete.html";
    }

    @GetMapping("/deleteconfirm")
    public String showDeleteConfirmPage(@RequestParam Long questionId, Model model) {
        // 削除確認処理
        return "deleteconfirm.html";
    }

    @GetMapping("/deletecomplete")
    public String showDeleteCompletePage() {
        return "deletecomplete.html";
    }
}