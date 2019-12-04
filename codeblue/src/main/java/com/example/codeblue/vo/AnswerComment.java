package com.example.codeblue.vo;

import lombok.Data;

@Data
public class AnswerComment {
	private int answerCommentId;
	private User user;
	private Answer answer;
	private String answerCommentContent;
	private String answerCommentDatetime;
}