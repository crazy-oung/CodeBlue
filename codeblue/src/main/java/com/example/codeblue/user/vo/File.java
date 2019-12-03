package com.example.codeblue.user.vo;

import com.example.codeblue.board.vo.QuestionBoard;

import lombok.Data;

@Data
public class File {
	private int fileId;
	private QuestionBoard questionBoard;
	private String fileExtention;
	private int fileSize;
	private String fileOriginName;
	private String fileDatetime;
}