package com.example.webapp.helper;

import com.example.webapp.entity.Create;
import com.example.webapp.form.CreateForm;

public class CreateHelper {
	
	//Form>>>Entityに変換
	public static Create convert(CreateForm form) {
		Create create = new Create();
		create.setAddress(form.getAddress());
		create.setPassword(form.getPassword());
		return create;
	}

}
