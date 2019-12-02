package com.example.codeblue.board.vo;

import lombok.Data;

@Data
public class NoticeBoard {
	private int noticeId;
	private String noticeTitle;
	private String noticeContent;
	private String fileId;
	private String noticeDatetime;
}
