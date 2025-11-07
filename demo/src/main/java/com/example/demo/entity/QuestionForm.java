package com.example.demo.entity;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class QuestionForm {

	private String questionText;
	private String text;
	private Long id;
//	private List<String> choices;
	private List<Choice> choices;


	
    @NotBlank(message = "タイトルは必須です")
    private String title;

    @NotBlank(message = "問題文は必須です")
    private String content;

    @NotBlank(message = "正解は必須です")
    private String correctAnswer;
    
    @NotBlank(message = "解説は必須です") // 必須なら
    private String explanation;


    @NotBlank(message = "選択肢Aは必須です")
    private String choiceA;

    @NotBlank(message = "選択肢Bは必須です")
    private String choiceB;

    @NotBlank(message = "選択肢Cは必須です")
    private String choiceC;

    @NotBlank(message = "選択肢Dは必須です")
    private String choiceD;

    @NotBlank(message = "カテゴリIDは必須です")
    private String categoryId;

    @NotBlank(message = "カテゴリは必須です")
    private String category;
}