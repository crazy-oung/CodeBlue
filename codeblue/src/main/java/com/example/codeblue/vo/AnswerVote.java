package com.example.codeblue.vo;

import lombok.Data;

@Data
public class AnswerVote {
	private String answerVoteDatetime;
	// 아래 두개 기본키로 잡힘 중복 추천 ㄴㄴ를 위해
	private User user;
	private Answer answer;
}
