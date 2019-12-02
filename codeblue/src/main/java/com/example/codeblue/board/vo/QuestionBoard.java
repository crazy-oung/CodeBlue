package com.example.codeblue.board.vo;

import lombok.Data;

@Data
public class QuestionBoard {

	private int questionId;
	private String questionTitle;
	private String questionContent;
	private String questionDatetime;
	private int feildId;
	private String userId;
	private int tagId;
	private String questionFL;
	private int answerCount;
	private int voteCount;
	
}
