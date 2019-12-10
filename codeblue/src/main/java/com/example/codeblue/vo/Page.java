package com.example.codeblue.vo;

import lombok.Data;

@Data
public class Page {
	public int beginRow;
	public int rowPerPage;
	public String searchWord;
	public String searchCategory;
	public String toDate;
	public String fromDate;
	public int feildId;
}