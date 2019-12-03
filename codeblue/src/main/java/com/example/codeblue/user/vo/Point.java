package com.example.codeblue.user.vo;

import lombok.Data;

@Data
public class Point {
	private int pointId;
	private int pointNumber;
	private String pointDatetime;
	private User user;
}