package com.example.codeblue.vo;

import java.io.File;

import lombok.Data;

@Data
public class NoticeBoard {
	private int noticeId;
	private String noticeTitle;
	private String noticeContent;
	private File file;
	private String noticeDatetime;
}