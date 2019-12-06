package com.example.codeblue.vo;

import lombok.Data;

@Data
public class InquiryHistoryAnswer {
	private int inquiryHistoryAnswerId;
	private InquiryHistory inquiryHistory;
	private String inquiryHistoryAnswerTitle;
	private String inquiryHistoryAnswerContent;
	private String inquiryHistoryAnswerDatetime;
}
