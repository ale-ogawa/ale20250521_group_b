package com.example.webapp.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.webapp.entity.Post;
import com.example.webapp.entity.Scope;

@Mapper
public interface PostMapper {
	
	void insert(Post post);
	void update(Post post);
	void insertScope(List<Scope> scopes);
	void updateScope(List<Scope> scopes);
	Post select(LocalDate date);

}
