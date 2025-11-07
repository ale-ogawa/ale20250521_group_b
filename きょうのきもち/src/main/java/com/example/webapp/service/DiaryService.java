package com.example.webapp.service;

import java.time.LocalDate;
import java.util.List;

import com.example.webapp.entity.Diary;
import com.example.webapp.entity.Group;
import com.example.webapp.entity.Scope;

public interface DiaryService {

	List<Diary> findFeelings(LocalDate localDate);
	List<Group> findGroups();
	Diary findToday(LocalDate localDate);
	List<Scope> findScopes(Integer diaryId);
	List<Integer> makeList(List<Scope> scopes);

}
