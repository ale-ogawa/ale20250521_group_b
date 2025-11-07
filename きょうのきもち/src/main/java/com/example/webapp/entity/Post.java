package com.example.webapp.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	private Integer id;
	private Integer accountId;
	private Integer feeling;
	private String text;
	private LocalDate date;

}
