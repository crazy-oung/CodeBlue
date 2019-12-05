package com.example.codeblue.service;

import java.util.List;
import java.util.Map;

import com.example.codeblue.vo.FaqBoard;
import com.example.codeblue.vo.Feild;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.NoticeBoard;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionCount;
import com.example.codeblue.vo.ReportHistory;

public interface AdminService {
	
	public Map<String,Object> getAdminUserList(int currentPage, int rowPerPage, String searchWord);
	public Map<String,Object> getNoticeBoard(int currentPage,int rowPerPage, String searchWord);
	public NoticeBoard getNoticeOne(int noticeId);
	public int addNotice(NoticeBoard noticeBoard);
	//문의 내역 리스트 출력
	public Map<String, Object> getInquiryHistoryList(int currentPage, int rowPerPage);
	//문의 내역 상세 페이지 출력
	public InquiryHistory getInquiryHistoryOne(int inquiryHistoryId);
	//신고 내역 리스트 출력
	public Map<String, Object> getReportHistoryList(int currentPage, int rowPerPage);
	//신고 내역 상세 페이지 출력
	public ReportHistory getReportHistoryOne(int reportHistoryId);
	public List<QuestionCount> getYearlyQuestionCount();
	public List<QuestionCount> getCurrentQuestionCountFromFeild();
	public int addFaqBoard(FaqBoard faqBoard);
	public List<Feild> getAdminFeildList();
	public Map<String,Object> getAdminBoardList(Page page,int currentPage);
	
}
