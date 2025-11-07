package com.example.webapp.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.webapp.entity.Create;

@Mapper
public interface CreateMapper {
	
	void insert(Create create);

}
