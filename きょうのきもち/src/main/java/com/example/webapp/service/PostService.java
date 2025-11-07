package com.example.webapp.service;

import java.time.LocalDate;
import java.util.List;

import com.example.webapp.entity.Post;
import com.example.webapp.entity.Scope;

public interface PostService {

	void insert(Post post);
	void update(Post post);
	void insertScope(List<Scope> scopes);
	void updateScope(List<Scope> scopes);
	Post find(LocalDate localDate);

}
