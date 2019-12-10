package com.example.codeblue.vo;

import lombok.Data;

@Data
public class InquiryHistory {
	private int inquiryHistoryId;
	private String inquiryTitle;
	private String inquiryContent;
	private Inquiry inquiry;
	private User user;
	private String inquiryDatetime;
	private String inquiryAnswer;
}
