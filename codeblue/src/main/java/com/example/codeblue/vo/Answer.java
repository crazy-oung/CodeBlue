package com.example.codeblue.vo;

import lombok.Data;

@Data
public class Answer {
	private int answerId;
	private QuestionBoard questionBoard;
	private User user;
	private String answerContent;
	private String answerDatetime;
	private int answerTotal;
}