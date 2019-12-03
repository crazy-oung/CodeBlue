package com.example.codeblue.user.vo;

import lombok.Data;

@Data
public class Expert {
	private int expertId;
	private Feild feild;
	private int expertLicenseNo;
	private String expertLicenseIssueDate;
	private User user;
}