package com.example.webapp.controller;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webapp.entity.Diary;
import com.example.webapp.form.CalendarForm;
import com.example.webapp.service.DiaryService;
import com.example.webapp.utility.ImagesPath;
import com.example.webapp.utility.LoginAccount;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/calendar")
@RequiredArgsConstructor
public class CallendarController {
	
	private final DiaryService diaryService;
	
	@GetMapping
    public String calendar(Model model, CalendarForm form) {
		YearMonth yearMonth = YearMonth.from(LocalDate.now());
		
		if (form.getYear() == null || form.getMonth() == null) {
	        form.setYear(String.valueOf(yearMonth.getYear()));
	        form.setMonth(String.valueOf(yearMonth.getMonthValue()));
	    } else {
	        int year = Integer.parseInt(form.getYear());
	        int month = Integer.parseInt(form.getMonth());
	        yearMonth = YearMonth.of(year, month);
	    }
		
        LocalDate firstDay = yearMonth.atDay(1);
        LocalDate lastDay = yearMonth.atEndOfMonth();
        List<Diary> diaries = diaryService.findFeelings(LocalDate.now());

        model.addAttribute("diaries", diaries);
        model.addAttribute("nickname", LoginAccount.nickname);
        model.addAttribute("images", new ImagesPath().getImages());
        return "calendar";
    }

}
