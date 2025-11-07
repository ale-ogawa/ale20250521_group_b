package com.example.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webapp.entity.User;
import com.example.webapp.service.SettingService;
//import com.example.webapp.repository.AccountRepository;

@Controller
@RequestMapping("/user")
public class SettingController {

	@Autowired
	private SettingService settingService;
//	@Autowired
//	private AccountRepository accountRepository;
//
//	@GetMapping("/nickname")
//	public String getNickname(Model model) {
//		String nickname = accountRepository.findById(1L)
//				.map(account -> account.getNickname())
//				.orElse("未登録");
//		model.addAttribute("nickname", nickname);
//		return "user_nickname"; // nickname専用のテンプレート
//	}

	@GetMapping
	public String showUserSetting(Model model) {
		Integer userId = 1;
		List<User> userInfo = settingService.getUserSet(userId);
		model.addAttribute("userInfo", userInfo);
		return "user";
	}

	//    @GetMapping("/edit")
	//    public String editUserSetting(Model model) {
	//        Setting userInfo = settingService.getUserSet(1);
	//        List<Disease> diseaseList = settingService.getAllDiseases();
	//        model.addAttribute("userInfo", userInfo);
	//        model.addAttribute("diseaseList", diseaseList);
	//        return "user_edit"; 
	//    }
}