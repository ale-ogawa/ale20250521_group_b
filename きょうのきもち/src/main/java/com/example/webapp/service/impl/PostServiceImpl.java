package com.example.webapp.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webapp.entity.Post;
import com.example.webapp.entity.Scope;
import com.example.webapp.repository.PostMapper;
import com.example.webapp.service.PostService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
	
	private final PostMapper postMapper;

	@Override
	public void insert(Post post) {
		postMapper.insert(post);
	}
	
	@Override
	public void update(Post post) {
		postMapper.update(post);
	}
	
	@Override
	public void insertScope(List<Scope> scopes) {
		postMapper.insertScope(scopes);
	}
	
	@Override
	public void updateScope(List<Scope> scopes) {
		postMapper.updateScope(scopes);
	}

	@Override
	public Post find(LocalDate date) {
		return postMapper.select(date);
	}

}
