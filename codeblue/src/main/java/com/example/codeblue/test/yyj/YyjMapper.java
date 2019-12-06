package com.example.codeblue.test.yyj;

import java.util.List;
import com.example.codeblue.vo.NoticeBoard;
import com.example.codeblue.vo.Page;

@org.apache.ibatis.annotations.Mapper
public interface YyjMapper {
	public int deleteNoticeBoardTest(int noticeId);
	public List<NoticeBoard> selectNoticeBoardTest(Page page);
	//공지사항 수
	public int noticeBoardCountTest(Page page);
	//공지사항 상세보기
	public NoticeBoard noticeBoardOneTest(int noticeId);
	//공지사항 입력
	public int insertNoticeBoardTest(NoticeBoard noticeBoard);
}
