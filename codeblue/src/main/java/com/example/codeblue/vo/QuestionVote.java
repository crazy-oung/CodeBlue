package com.example.codeblue.vo;

import lombok.Data;

@Data
public class QuestionVote {
	private User user;
	private QuestionBoard questionBoard;
	private String questionVoteDateTime;
}
