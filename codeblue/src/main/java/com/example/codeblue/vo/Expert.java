package com.example.codeblue.vo;

import lombok.Data;

@Data
public class Expert {
	private int expertId;
	private int feildId;
	private Feild feild;
	private int expertLicenseNo;
	private String expertLicenseIssueDate;
	private String userId;
	private User user;
} 