package com.example.codeblue.board.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.codeblue.board.vo.NoticeBoard;
import com.example.codeblue.board.vo.Page;

@Mapper
public interface NoticeBoardMapper {
	public List<NoticeBoard> selectNoticeBoardList(Page page);
	public NoticeBoard selectNoticeBoardOne(int noticeId);
	public int noticeBoardTotalRow();
}

