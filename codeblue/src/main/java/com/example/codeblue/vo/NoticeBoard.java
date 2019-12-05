package com.example.codeblue.vo;




import lombok.Data;

@Data
public class NoticeBoard {
	private int noticeId;
	private String noticeTitle;
	private String noticeContent;
	private String noticeDatetime;
}