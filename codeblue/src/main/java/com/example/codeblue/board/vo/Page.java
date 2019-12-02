package com.example.codeblue.board.vo;

import lombok.Data;

@Data
public class Page {
	public int beginRow;
	public int rowPerPage;
	public String searchWord;
}