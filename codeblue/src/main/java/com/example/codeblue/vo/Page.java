package com.example.codeblue.vo;

import lombok.Data;

@Data
public class Page {
	public int beginRow;
	public int rowPerPage;
	// 각 페이지에서의 검색 조건
	public String searchWord;
	public String searchCategory;
	// userTopBar에서 검색 조건
	public String searchQuestionBoard;
	public String toDate;
	public String fromDate;
	public int feildId;
}