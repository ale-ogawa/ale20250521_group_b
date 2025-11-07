//package com.example.demo.controller;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import lombok.RequiredArgsConstructor;
//
////import com.example.webapp.entity.TestSession;
////import com.example.webapp.repository.Test_SessionMapper;
//@RequiredArgsConstructor
//@Controller
//public class UserController {
//
//	
//    //private Test_SessionMapper testSessionMapper;
//
//    @GetMapping({"/plearning/main", "/main"})
//    public String showUserPage(Model model) {
//
//        // カテゴリーリスト
//        List<String> categories = Arrays.asList("Java", "DB", "JavaScript", "SpringFramework");
//        List<Integer> questionCounts = Arrays.asList(10, 30, 50);
//
//        model.addAttribute("categories", categories);
//        model.addAttribute("questionCounts", questionCounts);
//
//        // 直近3件取得
////        List<Questions> recentHistories;
////		try {
////			recentHistories = QuestionMapper.selectAllQuestion();
////		} catch (Exception e) {
////			// TODO 自動生成された catch ブロック
////			e.printStackTrace();
////		}
////        model.addAttribute("histories", recentHistories);
////
//     return "main"; // templates/main.html
//    }
//}

package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Questions;
import com.example.demo.service.QuestionService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final QuestionService questionService; // サービスを注入

    @GetMapping({"/plearning/main", "/main"})
    public String showUserPage(Model model) {

        // カテゴリーリスト
        List<String> categories = Arrays.asList("Java", "DB", "JavaScript", "SpringFramework");
        List<Integer> questionCounts = Arrays.asList(10, 30, 50);
        model.addAttribute("categories", categories);
        model.addAttribute("questionCounts", questionCounts);

        // データベースから直近の問題を取得
        List<Questions> recentHistories = questionService.findAllQuestion();
        
        model.addAttribute("histories", recentHistories); // HTMLで使う変数名に合わせる

        return "main"; // templates/main.html
    }
    
    @PostMapping("/plearning/questions")
    public String showQuestion() {
    	
    	return "plearning/questions";
    }
}


