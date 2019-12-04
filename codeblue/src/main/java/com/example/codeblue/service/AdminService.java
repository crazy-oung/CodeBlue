package com.example.codeblue.service;

import java.util.List;
import java.util.Map;

import com.example.codeblue.vo.FaqBoard;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.Notice;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionCount;
import com.example.codeblue.vo.ReportHistory;

public interface AdminService {
	
	public Map<String,Object> getAdminUserList(int currentPage, int rowPerPage, String searchWord);
	public Map<String,Object> getNoticeBoard(int currentPage,int rowPerPage, String searchWord);
	public Notice getNoticeOne(int noticeId);
	public int addNotice(Notice notice);
	//문의 내역 리스트 출력
	public Map<String, Object> getInquiryHistoryList(int currentPage, int rowPerPage);
	//문의 내역 상세 페이지 출력
	public InquiryHistory getInquiryHistoryOne(int inquiryHistoryId);
	//신고 내역 리스트 출력
	public Map<String, Object> getReportHistoryList(int currentPage, int rowPerPage);
	//신고 내역 상세 페이지 출력
	public ReportHistory getReportHistoryOne(int reportHistoryId);
	public List<QuestionCount> getCurrentQuestionCountFor6Month();
	public List<QuestionCount> getCurrentQuestionCountFromFeild();
	public int addFaqBoard(FaqBoard faqBoard);
	public List<String> getAdminFeildList();
	public Map<String,Object> getAdminBoardList(Page page,int currentPage);
	
}
