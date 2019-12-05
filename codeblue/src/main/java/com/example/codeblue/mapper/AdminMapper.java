package com.example.codeblue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.vo.FaqBoard;
import com.example.codeblue.vo.Feild;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.NoticeBoard;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionCount;
import com.example.codeblue.vo.ReportHistory;
import com.example.codeblue.vo.User;

@Mapper
public interface AdminMapper {
	public List<Feild> selectAdminFeildList();
	public int selectAdminBoardTotalCount(Page page);
	public List<QuestionBoard> selectAdminBoardList(Page page);
	//고객센터 답변 삽입
	public int insertFaqBoard(FaqBoard faqBoard);
	// 관리자 통계
	public List<QuestionCount> selectYearlyQuestionCount();
	public List<QuestionCount> selectCurrentQuestionCountFromFeild();
	//문의내역 가져오기
	public List<InquiryHistory> selectInquiryHistoryList(Page page);
	public int InquiryHistoryTotalRow();
	//신고내역 가져오기
	public List<ReportHistory> selectReportHistoryList(Page page);
	public int ReportHistoryTotalRow();
	//문의내역 상세 내용 가져오기
	public InquiryHistory selectInquiryHistoryOne(int inquiryHistoryId);
	//신고내역 상세 내용 가져오기
	public ReportHistory selectReportHistoryOne(int reportHistoryId);
	
	public List<NoticeBoard> selectNoticeBoard(Page page);
	public int noticeBoardCount(Page page);
	public NoticeBoard noticeBoardOne(int noticeId);
	public int insertNoticeBoard(NoticeBoard noticeBoard);
	
	public List<User> adminSelectUserList(Page page);
	public int adminSelectUserCount();
	
	
}
