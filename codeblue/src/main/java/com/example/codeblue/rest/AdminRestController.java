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
import com.example.codeblue.vo.Feild;
import com.example.codeblue.vo.Hospital;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.InquiryHistoryAnswer;
import com.example.codeblue.vo.NoticeBoard;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionCount;
import com.example.codeblue.vo.ReportHistory;
import com.example.codeblue.vo.ServiceCategory;


@RestController
public class AdminRestController {
	@Autowired private AdminService adminService;
	//문의사항 답변 추가하기
	@PostMapping("/rest/admin/addInquiryHistoryAnswer")
	public void addInquiryHistoryAnswer(InquiryHistoryAnswer inqruiyHistoryAnswer) {
		System.out.println("::: post - addInquiryHistoryAnswer :::"); 
		adminService.addInquiryHistoryAnswer(inqruiyHistoryAnswer);
	}
	//FAQ 리스트 바로 가져오기
	@PostMapping("/rest/admin/getFaqBoardList")
	public Map<String,Object> getFaqBoardList(@RequestParam(value="currentPage",defaultValue = "1")int currentPage,
			@RequestParam(value="rowPerPage",defaultValue = "10")int rowPerPage,
			@RequestParam(value="searchWord", required = false)String searchWord) {
		System.out.println("::: post - getFaqBoardList :::"); 
		return adminService.getFaqBoardList(currentPage, rowPerPage, searchWord);
	}
	//FAQ 추가하기 
	@PostMapping("/rest/admin/addFaqBoard")
	public int addFaqBoard(FaqBoard faqBoard) {
		System.out.println(":::post - addFaqBoard:::");
		return adminService.addFaqBoard(faqBoard);
	}
	
	//서비스 카데고리 리스트 가져오기
	@GetMapping("/rest/admin/getServiceCategoryList")
	public List<ServiceCategory> getServiceCategoryList() {
		System.out.println("::: get - getServiceCategoryList :::"); 
		return adminService.getServiceCategoryList();
	}
	
	@PostMapping("/rest/modifyHospital")
	public int postModifyHospital(Hospital hospital) {
		System.out.println(":::post - postModifyHospital:::");
		System.out.println("hospital"+hospital);
		return adminService.modifyHospital(hospital);
	
	}
	//병원 리스트
	@PostMapping("/rest/adminHospital")
	public Map<String, Object>postHospital(@RequestParam(value="currentPage", defaultValue="1")int currentPage,
										@RequestParam(value="rowPerPage", defaultValue="10")int rowPerPage,
										   @RequestParam(value="searchWord", required = false)String searchWord) {
	System.out.println(":::post - postHospital:::");
	System.out.println("currentPage"+currentPage);
	System.out.println("rowPerPage"+rowPerPage);
	System.out.println("searchWord"+searchWord);
	
	return adminService.getHospitalList(currentPage, rowPerPage, searchWord);
	}
	
	//병원 입력
	@PostMapping("/rest/adminHospitalAdd")
	public int addHospital(Hospital hospital) {
		System.out.println(":::post - addHospital");
		System.out.println("hospital"+hospital);
		
		return adminService.addHospital(hospital);
	}
		
	//병원 상세페이지
	@PostMapping("/rest/adminHospitalOne")
	public List<Hospital> getHospitalOne(@RequestParam(value="hospitalId")int hospitalId){
		System.out.println(":::post - getHospitalOne");
		System.out.println("hospitalId"+hospitalId);
		
		return adminService.getHospitalOne(hospitalId);
	}
	
	// 회원 조회 리스트
	@PostMapping("/rest/adminUserList")
	public Map<String,Object> adminUserList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
			 @RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage,
			 @RequestParam(value="searchWord", required = false)String searchWord,
			 @RequestParam(value="toDate", required = false)String toDate,
			 @RequestParam(value="fromDate", required = false)String fromDate) {
		System.out.println("::: post - /rest/adminuserList :::");
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : "+rowPerPage);
		System.out.println("searchWord : "+searchWord);
		System.out.println("toDate : "+toDate);
		System.out.println("fromDate : "+fromDate);
		return adminService.getAdminUserList(currentPage, rowPerPage,searchWord, toDate, fromDate);
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
	public NoticeBoard postNoticeOne(@RequestParam(value="noticeId") int noticeId) {
		System.out.println(":::post - postNoticeOne:::");
		System.out.println("noticeId"+noticeId);
		return adminService.getNoticeOne(noticeId);
	}
	
	@PostMapping("/rest/adminNoticeAdd")
	public int postNoticeAdd(NoticeBoard noticeBoard) {
		System.out.println(":::post - postNoticeAdd");
		System.out.println("NoticeBoard"+noticeBoard);
		return adminService.addNotice(noticeBoard);
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
	
	@GetMapping("/getYearlyQuestionCount")
	public List<QuestionCount> getYearlyQuestionCount(){
		System.out.println("::: get - getYearlyQuestionCount :::");
		return adminService.getYearlyQuestionCount();
	}
	
	@GetMapping("/getCurrentQuestionCountFromFeild")
	public List<QuestionCount> getCurrentQuestionCountFromFeild(){
		System.out.println("::: get - getCurrentQuestionCountFromFeild :::");
		return adminService.getCurrentQuestionCountFromFeild();
	}
	
	@PostMapping("/rest/getFeildList")
	public List<Feild> getFeildList() {
		System.out.println("::: post - FeildList :::");
		return adminService.getFeildList();
	}
	//검색 조건에 따른 리스트 가져오기
	@PostMapping("/rest/getQuestionBoardList")
	public Map<String,Object> questionBoardList(Page page,@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
												@RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage) {
		System.out.println("::: post - questionBoardList :::");
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : " +rowPerPage);
		page.setRowPerPage(rowPerPage);
		System.out.println(page.toString());
		return adminService.getQuestionBoardList(page,currentPage);
	}
}
