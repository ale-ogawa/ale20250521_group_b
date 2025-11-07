package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Questions {

	private Integer id;
	private Integer category_id;
	private String question_text;
	private String explanation;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
}
