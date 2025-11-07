package com.example.webapp.helper;

import com.example.webapp.entity.Group;
import com.example.webapp.form.GroupForm;
import com.example.webapp.utility.LoginAccount;

public class GroupHelper {
	
	public static Group convert(GroupForm form) {
		Group group = new Group();
		group.setAccountId(LoginAccount.id);
		group.setName(form.getName());
		group.setCode((int)(Math.random()*10000));
		return group;
	}

}
