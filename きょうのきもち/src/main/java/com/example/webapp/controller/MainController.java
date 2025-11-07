package com.example.webapp.controller;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webapp.entity.Diary;
import com.example.webapp.entity.Group;
import com.example.webapp.entity.Scope;
import com.example.webapp.form.PostForm;
import com.example.webapp.form.TakingForm;
import com.example.webapp.helper.PostHelper;
import com.example.webapp.service.DiaryService;
import com.example.webapp.service.MedicineService;
import com.example.webapp.service.PostService;
import com.example.webapp.service.TakingService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
	
	private final DiaryService diaryService;
	private final PostService postService;
	private final TakingService takingService;
	private final MedicineService medicineService;
	private LocalDate localDate;
	boolean isTodaysNew;
	List<Group> groups;
	
	@GetMapping
	public String home(Model model) {
		Diary diary = new Diary();
		PostForm postForm = new PostForm();
		List<Integer> groupIds = new ArrayList<>();
		
		//その日の初投稿なら日付だけセット
		if(localDate == null || !localDate.equals(LocalDate.now())) {
			localDate = LocalDate.now();
			diary.setDate(localDate);
			isTodaysNew = true;
		}
		//その日投稿済みなら、投稿内容をセットしておく
		else {
			isTodaysNew = false;
			//その日の投稿内容を取得
			diary = diaryService.findToday(localDate);
			//scopesテーブルから、日記IDが一致するレコードを取得
			List<Scope> scopes = diaryService.findScopes(diary.getId());
			//scopesオブジェクトから、settingがtrueであるgroup_idを抽出
			groupIds = diaryService.makeList(scopes);
		}
		
		//groupsテーブルから、作成者IDが一致するレコードを取得
		groups = diaryService.findGroups();
		//フォームに変換
		postForm = PostHelper.convertDiaryToPostForm(diary, groups);
		
		//その日の服薬情報を取得
		List<TakingForm> takingForms = new ArrayList<>();
		takingForms = takingService.findToday(localDate);
		
		model.addAttribute("postForm", postForm);
		model.addAttribute("groupIds", groupIds);
		model.addAttribute("takingForms", takingForms);
		
		return "home";
	}
	
//	@PostMapping
//	public String post(Model model, PostForm form) {
//		form.setDate(localDate);
//		Post posto = PostHelper.convert(form);
//		if(isTodaysNew) {
//			postService.insert(posto);
//			System.out.println(posto.getId());
//			List<Scope> scopes = PostHelper.convertToScope(form, groups, posto.getId());
//			postService.insertScope(scopes);
//		}else {
//			postService.update(posto);
//			System.out.println(posto.getId());
//			List<Scope> scopes = PostHelper.convertToScope(form, groups, posto.getId());
//			postService.updateScope(scopes);
//		}
//		Post post = postService.find(localDate);
//		model.addAttribute("post", post);
//		model.addAttribute("today", localDate);
//		return "post";
//	}
//	
	
	@GetMapping("calender")
    public String calender(Model model) throws Exception {
        List<Diary> feelings = diaryService.findFeelings(localDate);

        // JSON に変換
        ObjectMapper mapper = new ObjectMapper();
        String feelingsJson = mapper.writeValueAsString(feelings);

        model.addAttribute("feelingsJson", feelingsJson);
        model.addAttribute("year", YearMonth.from(localDate).getYear());
        model.addAttribute("month", YearMonth.from(localDate).getMonthValue());

        return "calender";
    }


}
