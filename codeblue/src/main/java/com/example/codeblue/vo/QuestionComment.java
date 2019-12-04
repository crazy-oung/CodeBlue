package com.example.codeblue.vo;

import lombok.Data;

@Data
public class QuestionComment {
	private int questionCommentId;
	private User user;
	private String questionCommentContent;
	private QuestionBoard questionBoard;
	private String questionCommentDatetime;
}