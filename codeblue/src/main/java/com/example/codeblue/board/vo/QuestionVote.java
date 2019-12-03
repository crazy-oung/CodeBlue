package com.example.codeblue.board.vo;

import com.example.codeblue.user.vo.User;

import lombok.Data;

@Data
public class QuestionVote {
	private int questionVoteId;
	private User user;
	private QuestionBoard questionBoard;
	private String questionVoteDateTime;
}
