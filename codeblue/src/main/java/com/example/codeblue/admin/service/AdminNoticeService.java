package com.example.codeblue.admin.service;

import java.util.Map;

import com.example.codeblue.admin.vo.Notice;

public interface AdminNoticeService {
	public Map<String,Object> getNoticeBoard(int currentPage,int rowPerPage, String searchWord);
	public Notice getNoticeOne(int noticeId);
	public int addNotice(Notice notice);
}
