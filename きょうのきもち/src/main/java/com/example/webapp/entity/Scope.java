package com.example.webapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Scope {
	private Integer diaryId;
	private Integer groupId;
	private boolean setting;
	
}
