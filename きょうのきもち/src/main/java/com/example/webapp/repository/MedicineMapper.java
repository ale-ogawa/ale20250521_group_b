package com.example.webapp.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.webapp.entity.Medicine;

@Mapper
public interface MedicineMapper {
	
	List<Medicine> select();

	void insert(Medicine medicine);

	List<Medicine> findToday(LocalDate localDate, Integer accountId);

	List<Medicine> findById(List<Integer> takingIds);

}
