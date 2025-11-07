package com.example.webapp.service;

import java.time.LocalDate;
import java.util.List;

import com.example.webapp.entity.Medicine;

public interface MedicineService {

	List<Medicine> select();

	void insert(Medicine medicine);
	
	List<Medicine> findToday(LocalDate localDate);

	List<Medicine> findById(List<Integer> takingIds);
}
