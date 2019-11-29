package com.example.codeblue.user.vo;

import lombok.Data;

@Data
public class User {
	private String userId;
	private String userName;
	private String userPw;
	private int regionId;
	private String userActivity;
	private String userBirthdate;
	private String userCreatetime;
	private int rankId;
	private String userAuthority;
	private int expertId;
}
