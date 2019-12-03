package com.example.codeblue.board.vo;

import com.example.codeblue.user.vo.User;

import lombok.Data;

@Data
public class InquiryHistory {
	private int inquiryHistoryId;
	private String inquiryTitle;
	private String inquiryContent;
	private Inquiry inquiry;
	private User user;
	private String inquiryDatetime;
}
