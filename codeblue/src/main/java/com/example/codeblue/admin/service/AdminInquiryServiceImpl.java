package com.example.codeblue.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.admin.mapper.AdminInquiryMapper;
import com.example.codeblue.board.vo.InquiryHistory;
import com.example.codeblue.board.vo.Page;
import com.example.codeblue.board.vo.ReportHistory;

@Service
@Transactional
public class AdminInquiryServiceImpl implements AdminInquiryService {
	@Autowired AdminInquiryMapper adminInquiryMapper;
	//신고내역 상세 페이지 가져오기
	@Override
	public ReportHistory getReportHistoryOne(int reportHistoryId) {
		System.out.println("::: AdminInquiryServiceImpl - getReportHistoryOne :::");
		return adminInquiryMapper.selectReportHistoryOne(reportHistoryId);
	}

	
	//문의내역 상세페이지 가져오기
	@Override
	public InquiryHistory getInquiryHistoryOne(int inquiryHistoryId) {
		System.out.println("::: AdminInquiryServiceImpl - getInquiryHistoryOne :::");
		return adminInquiryMapper.selectInquiryHistoryOne(inquiryHistoryId);
	}
	//신고내역 가져오기
	@Override
	public Map<String, Object> getReportHistoryList(int currentPage, int rowPerPage) {
		System.out.println("::: AdminInquiryServiceImpl - getReportHistoryList :::");
		
		Page page = new Page();
		page.setRowPerPage(rowPerPage);
		page.setBeginRow((currentPage-1)*rowPerPage);
		
		int totalRow = adminInquiryMapper.ReportHistoryTotalRow();
		int lastPage = totalRow/rowPerPage;
		
		if(totalRow % rowPerPage != 0) {
			lastPage ++;
		}
		List<ReportHistory> list = adminInquiryMapper.selectReportHistoryList(page);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalRow", totalRow);
		map.put("list", list);
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("lastPage", lastPage);
		System.out.println(map.toString());
		return map;
	}
	
	//문의 내역 리스트 가져오기
	@Override
	public Map<String, Object> getInquiryHistoryList(int currentPage, int rowPerPage) {
		System.out.println("::: AdminInquiryServiceImpl - getInquiryHistoryList :::");
		
		Page page = new Page();
		page.setRowPerPage(rowPerPage);
		page.setBeginRow((currentPage-1)*rowPerPage);
		
		int totalRow = adminInquiryMapper.InquiryHistoryTotalRow();
		int lastPage = totalRow/rowPerPage;
		
		if(totalRow % rowPerPage != 0) {
			lastPage ++;
		}
		List<InquiryHistory> list = adminInquiryMapper.selectInquiryHistoryList(page);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalRow", totalRow);
		map.put("list", list);
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("lastPage", lastPage);
		System.out.println(map.toString());
		return map;
	}

}
