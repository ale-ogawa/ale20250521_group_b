package com.example.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webapp.entity.Create;
import com.example.webapp.form.CreateForm;
import com.example.webapp.helper.CreateHelper;
import com.example.webapp.service.CreateService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/create")
@RequiredArgsConstructor
public class CreateController {
	
	private final CreateService createService;
	
	@GetMapping
	public String create(CreateForm form) {
		return "create";
	}
	
	@PostMapping("/confirm")
	public String confirm(CreateForm form) {
		return "confirm";
	}
	
	@PostMapping("/complete")
	public String complete(CreateForm form) {
		//Entityへの変換
		Create create = CreateHelper.convert(form);
		createService.insert(create);
		return "complete";
	}
	

}
