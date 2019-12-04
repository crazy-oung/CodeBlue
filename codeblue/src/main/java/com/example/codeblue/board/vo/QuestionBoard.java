package com.example.codeblue.board.vo;

import com.example.codeblue.tag.vo.Tag;
import com.example.codeblue.user.vo.Feild;
import com.example.codeblue.user.vo.File;
import com.example.codeblue.user.vo.User;

import lombok.Data;

@Data
public class QuestionBoard {

	private int questionId;
	private String questionTitle;
	private String questionContent;
	private String questionDatetime;
	private int answerCount;
	private int voteCount;
	private int commentCount;
	//외래키 3개
	private Feild feild;
	private User user;
	private Tag tag;
}