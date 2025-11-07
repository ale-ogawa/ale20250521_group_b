package com.example.webapp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webapp.entity.Create;
import com.example.webapp.repository.CreateMapper;
import com.example.webapp.service.CreateService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateServiceImpl implements CreateService {
	
	private final CreateMapper createMapper;

	@Override
	public void insert(Create create) {
		createMapper.insert(create);
	}

}
