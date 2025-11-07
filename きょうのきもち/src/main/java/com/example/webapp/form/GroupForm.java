package com.example.webapp.form;

import java.util.List;

import lombok.Data;

@Data
public class GroupForm {
	private Integer id;
	private String name;
	private Integer accountId;
	private List<Integer> accountIds;
}
