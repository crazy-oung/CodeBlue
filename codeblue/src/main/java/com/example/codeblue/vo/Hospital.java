package com.example.codeblue.vo;


import lombok.Data;

@Data
public class Hospital {
	private int hospitalId;
	private String hospitalName;
	private int hospitalNumber;
	private String hospitalAddress;
	private String hospitalAddress2;
	private Region region;
}
