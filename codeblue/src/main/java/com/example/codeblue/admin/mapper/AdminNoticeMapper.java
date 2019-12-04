package com.example.codeblue.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.admin.vo.Notice;
import com.example.codeblue.board.vo.Page;

@Mapper
public interface AdminNoticeMapper {
	public List<Notice> selectNoticeBoard(Page page);
	public int noticeBoardCount(Page page);
	public Notice noticeBoardOne(int noticeId);
	public int insertNoticeBoard(Notice notice);
}
