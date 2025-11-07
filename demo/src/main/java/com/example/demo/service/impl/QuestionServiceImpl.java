package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Questions;
import com.example.demo.repository.QuestionMapper;
import com.example.demo.service.QuestionService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

	private final QuestionMapper qMapper;
	
	@Override
	public List<Questions> findAllQuestion() {
		// TODO 自動生成されたメソッド・スタブ
		return qMapper.selectAllQuestion();
	}

}
