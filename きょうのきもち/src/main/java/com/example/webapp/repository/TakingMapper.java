package com.example.webapp.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.webapp.entity.Taking;
import com.example.webapp.form.TakingForm;

@Mapper
public interface TakingMapper {
	
	void insert(Taking taking);
	void insertTaking(Taking taking);
	
	List<Taking> selectTaken(Integer takingId);
	List<TakingForm> findToday(LocalDate localDate, Integer accountId);

}
