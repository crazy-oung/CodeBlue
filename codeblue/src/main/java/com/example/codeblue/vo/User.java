package com.example.codeblue.vo;

import lombok.Data;

@Data
public class User {
	private String userId;
	private String userName;
	private String userPw;
	private Region region;
	private String userBirthdate;
	private String userCreatetime;
	private Rank rank;
	private String userActivity;
}
