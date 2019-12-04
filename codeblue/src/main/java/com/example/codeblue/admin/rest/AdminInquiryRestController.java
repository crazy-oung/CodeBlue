package com.example.codeblue.admin.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.admin.service.AdminInquiryService;
import com.example.codeblue.board.vo.InquiryHistory;
import com.example.codeblue.board.vo.ReportHistory;

@RestController
public class AdminInquiryRestController {
	@Autowired AdminInquiryService adminInquiryService;
	
	//신고내역 상세페이지 가져오기
	@PostMapping("/rest/admin/getReportHistoryOne")
	public ReportHistory getReportHistoryOne(int reportHistoryId) {
		System.out.println("::: post - getReportHistoryOne :::");
		return adminInquiryService.getReportHistoryOne(reportHistoryId);
	}
	//문의내역 상세페이지 가져오기
	@PostMapping("/rest/admin/getInquiryHistoryOne")
	public InquiryHistory getInquiryHistoryOne(int inquiryHistoryId) {
		System.out.println("::: post - getInquiryHistoryOne :::");
		return adminInquiryService.getInquiryHistoryOne(inquiryHistoryId);
	}
	//문의 내역 바로 가져오기
	@GetMapping("/rest/admin/getInquiryHistoryList")
	public Map<String,Object> getInquiryHistoryList() {
		System.out.println("::: get - getInquiryHistoryList :::"); 

		return adminInquiryService.getInquiryHistoryList(1, 15);
		
	}
	// 문의 내역 버튼 이전, 다음 가져오기
	@PostMapping("/rest/admin/getInquiryHistoryList")
	public Map<String,Object> getInquiryHistoryList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
									 @RequestParam(value="rowPerPage", defaultValue = "15")int rowPerPage) {
		System.out.println("::: post - getInquiryHistoryList :::"); 
		System.out.println("currentPage : " + currentPage);
		System.out.println("rowPerPage : " + rowPerPage);
		
		return adminInquiryService.getInquiryHistoryList(currentPage, rowPerPage);
	}
	// 신고 내역 바로 가져오기
	@GetMapping("/rest/admin/getReportHistoryList")
	public Map<String,Object> getReportHistoryList() {
		System.out.println("::: get - getReportHistoryList :::"); 

		
		return adminInquiryService.getReportHistoryList(1, 15);
		
	}
	// 신고 내역 버튼 이전, 다음 가져오기
	@PostMapping("/rest/admin/getReportHistoryList")
	public Map<String,Object> getReportHistoryList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
									 @RequestParam(value="rowPerPage", defaultValue = "15")int rowPerPage) {
		System.out.println("::: post - getReportHistoryList :::"); 
		System.out.println("currentPage : " + currentPage);
		System.out.println("rowPerPage : " + rowPerPage);
		
		return adminInquiryService.getReportHistoryList(currentPage, rowPerPage);
	}
}
