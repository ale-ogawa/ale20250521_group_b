package com.example.webapp.helper;

import java.util.List;

import com.example.webapp.entity.Diary;
import com.example.webapp.entity.Group;
import com.example.webapp.entity.Post;
import com.example.webapp.form.PostForm;
import com.example.webapp.utility.LoginAccount;

public class PostHelper {
	
	public static PostForm convertDiaryToPostForm(Diary diary, List<Group> groups) {
		PostForm form = new PostForm();
		form.setFeeling(diary.getFeeling());
		form.setText(diary.getText());
		form.setDate(diary.getDate());
		form.setGroups(groups);
		return form;
	}
	
	public static Post convert(PostForm form) {
		Post post = new Post();
		post.setFeeling(form.getFeeling());
		post.setText(form.getText());
		post.setDate(form.getDate());
		post.setAccountId(LoginAccount.id);
		return post;
	}
	
//	public static List<Scope> convertToScope(PostForm form, List<Group> groups, Integer diaryId){
//		List<Scope> scopes = new ArrayList<>();
//		for(Group group: groups) {
//			Scope scope = new Scope();
//			scope.setDiaryId(diaryId);
//			scope.setGroupId(group.getId());
//			boolean isOpen = form.getScope().contains(String.valueOf(group.getId()));
//			scope.setSetting(isOpen);
//			scopes.add(scope);
//		}
//		return scopes;
//	}

}
