package com.example.webapp.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webapp.entity.Taking;
import com.example.webapp.form.TakingForm;
import com.example.webapp.repository.TakingMapper;
import com.example.webapp.service.TakingService;
import com.example.webapp.utility.LoginAccount;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TakingServiceImpl implements TakingService {
	
	private final TakingMapper takingMapper;

	@Override
	public void insert(Taking taking) {
		takingMapper.insert(taking);
	}

	@Override
	public void insertTaking(Taking taking) {
		takingMapper.insertTaking(taking);
	}

	@Override
	public List<Taking> selectTaken(Integer takingId) {
		return takingMapper.selectTaken(takingId);
	}

	@Override
	public List<TakingForm> findToday(LocalDate localDate) {
		return takingMapper.findToday(localDate, LoginAccount.id);
	}

}
