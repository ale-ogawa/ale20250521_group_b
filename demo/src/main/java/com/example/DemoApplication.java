package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Questions;
import com.example.demo.service.QuestionService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args).getBean(DemoApplication.class).exe();
	}
	
	private final QuestionService service;
	
	
	public void exe() {
		for(Questions row : service.findAllQuestion()) {
			System.out.println(row);
		}
		
	}
}
