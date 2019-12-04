package com.example.codeblue.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.service.AdminService;
import com.example.codeblue.vo.FaqBoard;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.Notice;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionCount;
import com.example.codeblue.vo.ReportHistory;


@RestController
public class AdminRestController {
	@Autowired private AdminService adminService;
	
	@PostMapping("/rest/adminuserList")
	public Map<String,Object> adminUserList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
			 @RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage,
			 @RequestParam(value="searchWord", required = false)String searchWord) {
		System.out.println("::: post - /rest/adminuserList :::");
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : "+rowPerPage);
		System.out.println("searchWord : "+searchWord);
		return adminService.getAdminUserList(currentPage, rowPerPage,searchWord);
	}
	
	@PostMapping("/rest/adminNoticeBoard")
	public Map<String, Object> postNotice(@RequestParam(value="currentPage",defaultValue = "1")int currentPage,
							@RequestParam(value="rowPerPage",defaultValue = "10")int rowPerPage,
							@RequestParam(value="searchWord", required = false)String searchWord) {
		
		System.out.println(":::post - postNotice:::");
		System.out.println("currentPage"+currentPage);
		System.out.println("rowPerPage"+rowPerPage);
		System.out.println("searchWord"+searchWord);

		return adminService.getNoticeBoard(currentPage, rowPerPage, searchWord);
	}
	
	@PostMapping("/rest/adminNoticeBoardOne")
	public Notice postNoticeOne(@RequestParam(value="noticeId") int noticeId) {
		System.out.println(":::post - postNoticeOne:::");
		System.out.println("noticeId"+noticeId);
		return adminService.getNoticeOne(noticeId);
	}
	
	@PostMapping("/rest/adminNoticeAdd")
	public int postNoticeAdd(Notice notice) {
		System.out.println(":::post - postNoticeAdd");
		System.out.println("Notice"+notice);
		return adminService.addNotice(notice);
	}

	//신고내역 상세페이지 가져오기
	@PostMapping("/rest/admin/getReportHistoryOne")
	public ReportHistory getReportHistoryOne(int reportHistoryId) {
		System.out.println("::: post - getReportHistoryOne :::");
		return adminService.getReportHistoryOne(reportHistoryId);
	}
	//문의내역 상세페이지 가져오기
	@PostMapping("/rest/admin/getInquiryHistoryOne")
	public InquiryHistory getInquiryHistoryOne(int inquiryHistoryId) {
		System.out.println("::: post - getInquiryHistoryOne :::");
		return adminService.getInquiryHistoryOne(inquiryHistoryId);
	}
	//문의 내역 바로 가져오기
	@GetMapping("/rest/admin/getInquiryHistoryList")
	public Map<String,Object> getInquiryHistoryList() {
		System.out.println("::: get - getInquiryHistoryList :::"); 

		return adminService.getInquiryHistoryList(1, 15);
		
	}
	// 문의 내역 버튼 이전, 다음 가져오기
	@PostMapping("/rest/admin/getInquiryHistoryList")
	public Map<String,Object> getInquiryHistoryList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
									 @RequestParam(value="rowPerPage", defaultValue = "15")int rowPerPage) {
		System.out.println("::: post - getInquiryHistoryList :::"); 
		System.out.println("currentPage : " + currentPage);
		System.out.println("rowPerPage : " + rowPerPage);
		
		return adminService.getInquiryHistoryList(currentPage, rowPerPage);
	}
	// 신고 내역 바로 가져오기
	@GetMapping("/rest/admin/getReportHistoryList")
	public Map<String,Object> getReportHistoryList() {
		System.out.println("::: get - getReportHistoryList :::"); 

		
		return adminService.getReportHistoryList(1, 15);
		
	}
	// 신고 내역 버튼 이전, 다음 가져오기
	@PostMapping("/rest/admin/getReportHistoryList")
	public Map<String,Object> getReportHistoryList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
									 @RequestParam(value="rowPerPage", defaultValue = "15")int rowPerPage) {
		System.out.println("::: post - getReportHistoryList :::"); 
		System.out.println("currentPage : " + currentPage);
		System.out.println("rowPerPage : " + rowPerPage);
		
		return adminService.getReportHistoryList(currentPage, rowPerPage);
	}
	
	@GetMapping("/getCurrentQuestionCountFor6Month")
	public List<QuestionCount> getCurrentQuestionCountFor6Month(){
		System.out.println("::: get - getCurrentQuestionCountFor6Month :::");
		return adminService.getCurrentQuestionCountFor6Month();
	}
	
	@GetMapping("/getCurrentQuestionCountFromFeild")
	public List<QuestionCount> getCurrentQuestionCountFromFeild(){
		System.out.println("::: get - getCurrentQuestionCountFromFeild :::");
		return adminService.getCurrentQuestionCountFromFeild();
	}
	
	@PostMapping("/rest/admin/addFaqBoard")
	public int addFaqBoard(FaqBoard faqBoard) {
		System.out.println("::: post - addFaqBoard :::");
		
		
		return adminService.addFaqBoard(faqBoard);
	}
	
	@PostMapping("/rest/adminFeildList")
	public List<String> adminFeildList() {
		System.out.println("::: post - adminFeildList :::");
		return adminService.getAdminFeildList();
	}
	
	//검색 조건 vo 가져오기
	@PostMapping("/rest/adminBoardList")
	public Map<String,Object> adminBoardList(Page page,@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
												@RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage) {
		System.out.println("::: post - adminBoardList :::");
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : " +rowPerPage);
		page.setRowPerPage(rowPerPage);
		System.out.println(page.toString());
		return adminService.getAdminBoardList(page,currentPage);
	}
}
