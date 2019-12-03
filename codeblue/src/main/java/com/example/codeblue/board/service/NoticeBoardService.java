package com.example.codeblue.board.service;

import java.util.Map;

import com.example.codeblue.board.vo.NoticeBoard;

public interface NoticeBoardService {
	public Map<String, Object> getNoticeBoardList(int currentPage, int rowPerPage);
	public NoticeBoard getNoticeBoardOne(int noticeId);
}