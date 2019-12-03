package com.example.codeblue.user.vo;

import lombok.Data;

@Data
public class SearchHistory {
	private int searchId;
	private User user;
	private String searchWord;
	private String searchDatetime;
}
