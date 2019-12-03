package com.example.codeblue.board.vo;

import com.example.codeblue.user.vo.User;

import lombok.Data;

@Data
public class Answer {
	private int answerId;
	private QuestionBoard questionBoard;
	private User user;
	private String answerContent;
	private String answerDatetime;
}