package com.example.webapp.service.impl;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webapp.entity.Diary;
import com.example.webapp.entity.Group;
import com.example.webapp.entity.Scope;
import com.example.webapp.repository.DiaryMapper;
import com.example.webapp.service.DiaryService;
import com.example.webapp.utility.LoginAccount;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService {
	
	private final DiaryMapper diaryMapper;

	@Override
	public List<Diary> findFeelings(LocalDate localDate) {
		YearMonth yearMonth = YearMonth.from(localDate);
        LocalDate firstDay = yearMonth.atDay(1);
        LocalDate lastDay = yearMonth.atEndOfMonth();
		return diaryMapper.findFeelings(firstDay, lastDay);
	}

	@Override
	public List<Group> findGroups() {
		return diaryMapper.findGroups(LoginAccount.id);
	}

	@Override
	public List<Scope> findScopes(Integer diaryId) {
		return diaryMapper.findScopes(diaryId);
	}

	@Override
	public List<Integer> makeList(List<Scope> scopes) {
		List<Integer> groupIds = new ArrayList<>();
		for(Scope scope: scopes) {
			if(scope.isSetting()) {
				groupIds.add(scope.getGroupId());
			}
		}
		return groupIds;
	}

	@Override
	public Diary findToday(LocalDate localDate) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
