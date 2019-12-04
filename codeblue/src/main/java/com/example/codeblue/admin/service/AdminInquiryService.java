package com.example.codeblue.admin.service;

import java.util.Map;

import com.example.codeblue.board.vo.InquiryHistory;
import com.example.codeblue.board.vo.ReportHistory;

public interface AdminInquiryService {
	//문의 내역 리스트 출력
	public Map<String, Object> getInquiryHistoryList(int currentPage, int rowPerPage);
	//문의 내역 상세 페이지 출력
	public InquiryHistory getInquiryHistoryOne(int inquiryHistoryId);
	//신고 내역 리스트 출력
	public Map<String, Object> getReportHistoryList(int currentPage, int rowPerPage);
	//신고 내역 상세 페이지 출력
	public ReportHistory getReportHistoryOne(int reportHistoryId);
	
	
}