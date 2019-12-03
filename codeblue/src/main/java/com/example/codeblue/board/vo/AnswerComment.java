package com.example.codeblue.board.vo;

import com.example.codeblue.user.vo.User;

import lombok.Data;

@Data
public class AnswerComment {
	private int answerCommentId;
	private User user;
	private Answer answer;
	private String answerCommentContent;
	private String answerCommentDatetime;
}