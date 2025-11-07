package com.example.webapp.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.webapp.entity.Diary;
import com.example.webapp.entity.Group;
import com.example.webapp.entity.Scope;

@Mapper
public interface DiaryMapper {
	
	List<Diary> findFeelings(LocalDate firstDay, LocalDate lastDay);
	List<Group> findGroups(Integer accountId);
	Diary findToday(LocalDate localDate, Integer accountId);
	List<Scope> findScopes(Integer diaryId);

}
