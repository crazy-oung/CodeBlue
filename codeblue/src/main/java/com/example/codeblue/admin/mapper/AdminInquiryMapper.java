package com.example.codeblue.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.board.vo.InquiryHistory;
import com.example.codeblue.board.vo.Page;
import com.example.codeblue.board.vo.ReportHistory;

@Mapper
public interface AdminInquiryMapper {
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
}

