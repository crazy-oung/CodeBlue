package com.example.codeblue.vo;

import lombok.Data;

@Data
public class QuestionBoard {

	private int questionId;
	private String questionTitle;
	private String questionContent;
	private String questionTags;
	private String questionDatetime;
	private int answerCount;
	private int voteCount;
	private int commentCount;
	
	//외래키 3개
	private Feild feild;
	private User user;
}