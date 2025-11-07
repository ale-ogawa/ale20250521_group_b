package com.example.webapp.form;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class TakingForm {
	private Integer id;
	private List<String> medicineIds;
	private LocalDateTime time;
	
	private Integer takingId;
	private String name;
}
