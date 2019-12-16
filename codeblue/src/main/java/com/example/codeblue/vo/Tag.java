package com.example.codeblue.vo;

import lombok.Data;

@Data
public class Tag {
	private int tagId;
	private String tagName;
	private QuestionBoard questionBoard;
}