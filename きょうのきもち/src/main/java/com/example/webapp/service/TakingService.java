package com.example.webapp.service;

import java.time.LocalDate;
import java.util.List;

import com.example.webapp.entity.Taking;
import com.example.webapp.form.TakingForm;

public interface TakingService {

	void insert(Taking taking);
	
	void insertTaking(Taking taking);
	
	List<Taking> selectTaken(Integer takingId);

	List<TakingForm> findToday(LocalDate localDate);
}
