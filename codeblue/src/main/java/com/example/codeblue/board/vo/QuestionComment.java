package com.example.codeblue.board.vo;

import lombok.Data;

@Data
public class QuestionComment {
	private int questionCommentId;
	private String userId;
	private String questionCommentContent;
	private int questionId;
	private String questionCommentDatetime;

}
