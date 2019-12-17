package com.example.codeblue.vo;

import lombok.Data;

@Data
public class AnswerVote {
	private String answerVoteDatetime;
	private User user;
	private Answer answer;
}
