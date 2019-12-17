package com.example.codeblue.rest;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.service.AdminService;
import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.FaqBoard;
import com.example.codeblue.vo.Feild;
import com.example.codeblue.vo.Hospital;
import com.example.codeblue.vo.Inquiry;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.InquiryHistoryAnswer;
import com.example.codeblue.vo.Manager;
import com.example.codeblue.vo.NoticeBoard;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionCount;
import com.example.codeblue.vo.Report;
import com.example.codeblue.vo.ReportHistory;
import com.example.codeblue.vo.ServiceCategory;

@RestController
public class AdminRestController {
	@Autowired private AdminService adminService;
	
	// 문의 처리율
	@GetMapping("/rest/getInqueryAnswerPercentage")
	public double getInqueryAnswerPercentage() {
		System.out.println("::: get - getInqueryAnswerPercentage :::");
		return adminService.getInqueryAnswerPercentage();
	}
	// 유저 활동지 통계
	@GetMapping("/getUserRegionCount")
	public	Map<String, Object> getUserRegionCount(){
		System.out.println("::: get - getUserRegionCount :::");
		Map<String, Object> map = adminService.getUserRegionCount();
		System.out.println(map);
		return map;
	}
	
	//문의사항 답변 상세출력
	@PostMapping("/rest/admin/getInquiryHistoryAnswerOne")
	public InquiryHistoryAnswer getInquiryHistoryAnswerOne(int inquiryHistoryId) {
		System.out.println("::: post - getInquiryHistoryAnswerOne :::");
		return adminService.getInquiryHistoryAnswerOne(inquiryHistoryId);
	}
	
	//신고 대상(질문)상세 정보 가져오기
	@PostMapping("/rest/admin/getReportQuestionBoardOne")
	public QuestionBoard getReportQuestionBoardOne(int questionId) {
		System.out.println("::: post - getReportQuestionBoardOne :::");
		return adminService.getReportQuestionBoardOne(questionId);
	}
	//신고 대상(답변)상세 정보 가져오기
	@PostMapping("/rest/admin/getReportAnswerOne")
	public Answer getReportAnswerOne(int answerId) {
		System.out.println("::: post - getReportAnswerOne :::");
		return adminService.getReportAnswerOne(answerId);
	}
	//Report 카테고리 가져오기
	@GetMapping("/rest/admin/getReportList")
	public List<Report> getReportList(){
		System.out.println("::: get - getReportList :::"); 
		return adminService.getReportList();
	}
	
	//체크박스로 선택한 report배열 가져오고 삭제하기
	@PostMapping("/rest/admin/removeReportHistoryList")
	public String removeReportHistoryList(@RequestParam(value="checkBoxArr")List<String> reportHistoryIdList) {
		System.out.println("::: post - removeReportHistoryList :::");
		System.out.println(reportHistoryIdList.toString());
		adminService.removeReportHistoryList(reportHistoryIdList);
		return "삭제성공";
	}
	//inquiry 카테고리 가져오기
	@GetMapping("/rest/admin/getInquiryList")
	public List<Inquiry> getInquiryList(){
		System.out.println("::: get - getInquiryList :::"); 
		return adminService.getInquiryList();
	}
	//체크박스로 선택한 inquiry배열 가져오고 삭제하기
	@PostMapping("/rest/admin/removeInquiryHistoryList")
	public String removeInquiryHistoryList(@RequestParam(value="checkBoxArr")List<String> inquiryHistoryIdList) {
		System.out.println("::: post - removeInquiryHistoryList :::");
		System.out.println(inquiryHistoryIdList.toString());
		adminService.removeInquiryHistoryList(inquiryHistoryIdList);
		return "삭제성공";
	}
	//체크박스로 선택한 noticeId 배열 가져오고 삭제하기
	@PostMapping("/rest/admin/removeNoticeBoardList")
	public String removeNoticeBoardList(@RequestParam(value="checkBoxArr")List<String> noticeBoardIdList) {
		System.out.println("::: post - removeNoticeBoardList :::");
		System.out.println(noticeBoardIdList.toString());
		adminService.removeNoticeBoardList(noticeBoardIdList);
		return "삭제성공";
	}
	//답변 댓글 지우기
	@PostMapping("/rest/admin/removeAnswerCommentList")
	public String removeAnswerCommentList(@RequestParam(value="checkBoxArr")List<String> answerCommentIdList) {
		System.out.println("::: post - removeAnswerCommentList :::");
		System.out.println(answerCommentIdList.toString());
		adminService.removeAnswerCommentList(answerCommentIdList);
		return "답변 댓글 삭제 성공";
	}
	//답변 댓글 리스트 가져오기
	@PostMapping("/rest/admin/getAnswerCommentList")
	public Map<String,Object> getAnswerCommentList(Page page,@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
													@RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage){
		System.out.println("::: post - getAnswerCommentList :::");
		System.out.println(page.toString());
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : "+rowPerPage);
		page.setRowPerPage(rowPerPage);
		return adminService.getAnswerCommentList(page, currentPage);
	}
	//질문 댓글 지우기
	@PostMapping("/rest/admin/removeQuestionCommentList")
	public String removeQuestionCommentList(@RequestParam(value="checkBoxArr")List<String> questionCommentIdList) {
		System.out.println("::: post - removeQuestionCommentList :::");
		System.out.println(questionCommentIdList.toString());
		adminService.removeQuestionCommentList(questionCommentIdList);
		return "질문 댓글 삭제 성공";
	}
	//질문 댓글 리스트 가져오기
	@PostMapping("/rest/admin/getQuestionCommentList")
	public Map<String,Object> getQuestionCommentList(Page page,@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
														@RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage){
		System.out.println("::: post - getQuestionCommentList :::");
		System.out.println(page.toString());
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : "+rowPerPage);
		page.setRowPerPage(rowPerPage);
		return adminService.getQuestionCommentList(page, currentPage);
	}
	
	// 관리자 정보 가져오기
	@GetMapping("/rest/admin/getLoginManager")
	public Manager getLoginUser(HttpSession session) {
		System.out.println("::: get - getLoginManager :::"); 
		System.out.println(session.getAttribute("loginManager"));
		return (Manager) session.getAttribute("loginManager");
	}
	
	//답변 상세정보
	@PostMapping("/rest/admin/getAnswerOne")
	public Answer getAnswerOne(@RequestParam(value="answerId")String answerId) {
		System.out.println("::: post - getAnswerOne :::");
		System.out.println("answerId : "+answerId);
		return adminService.getAnswerOne(answerId);
	}
	//답변 삭제 하기
	@PostMapping("/rest/admin/removeAnswerList")
	public String removeAnswerList(@RequestParam(value="checkBoxArr")List<String> answerIdList) {
		System.out.println("::: post - removeAnswerList :::");
		System.out.println(answerIdList.toString());
		adminService.removeAnswerList(answerIdList);
		return "답변 삭제 성공";
	}
	//답변 리스트 가져오기
	@PostMapping("/rest/admin/getAnswerList")
	public Map<String,Object> getAnswerList(Page page,@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
												@RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage) {
		System.out.println("::: post - getAnswerList :::");
		System.out.println(page.toString());
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : "+rowPerPage);
		page.setRowPerPage(rowPerPage);
		return adminService.getAnswerList(page, currentPage);
	}
	//삭제된 게시글 상세정보 가져오기
	@PostMapping("/rest/admin/getWithdrawQuestionBoardOne")
	public QuestionBoard getWithdrawQuestionBoardOne(@RequestParam(value="questionId")String questionId) {
		System.out.println("::: post - getWithdrawQuestionBoardOne :::");
		System.out.println("questionId "+questionId);
		return adminService.getWithdrawQuestionBoardOne(questionId);
	}
	//게시글 상세정보 가져오기
	@PostMapping("/rest/admin/getQuestionBoardOne")
	public QuestionBoard getQuestionBoardOne(@RequestParam(value="questionId")String questionId) {
		System.out.println("::: post - getQuestionBoardOne :::");
		System.out.println("questionId "+questionId);
		return adminService.getQuestionBoardOne(questionId);
	}
	//검색 조건에 따른 삭제된 게시글 가져오기
	@PostMapping("/rest/admin/getWithdrawQuestionBoardList")
	public Map<String,Object> getWithdrawQuestionBoardList(Page page,@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
												@RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage) {
		System.out.println("::: post - questionBoardList :::");
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : " +rowPerPage);
		page.setRowPerPage(rowPerPage);
		System.out.println(page.toString());
		return adminService.getWithdrawQuestionBoardList(page,currentPage);
	}
	
	//체크박스로 선택한 questionId 배열 가져오기
	@PostMapping("/rest/admin/removeQuestionBoardList")
	public String removeQuestionBoardList(@RequestParam(value="checkBoxArr")List<String> questionBoardIdList) {
		System.out.println("::: post - removeQuestionBoardList :::");
		System.out.println(questionBoardIdList.toString());
		adminService.removeQeustionBoardList(questionBoardIdList);
		return "삭제성공";
	}
	//문의사항 답변 추가하기
	@PostMapping("/rest/admin/addInquiryHistoryAnswer")
	public void addInquiryHistoryAnswer(InquiryHistoryAnswer inqruiyHistoryAnswer) {
		System.out.println("::: post - addInquiryHistoryAnswer :::"); 
		adminService.addInquiryHistoryAnswer(inqruiyHistoryAnswer);
	}
	//FAQ 상세정보 가져오기
	@PostMapping("/rest/adminFaqOne")
	public FaqBoard getFaqOne(@RequestParam(value="faqId")int faqId) {
		System.out.println(":::post - getFaqOne:::");
		System.out.println("faqId : "+ faqId);
		return adminService.getFaqOne(faqId);
	}
	//FAQ 삭제
	@PostMapping("/rest/removeFaqBoard")
	public int removeFaqBoard(@RequestParam(value="faqId")int faqId) {
		System.out.println(":::post - removeFaqBoard:::");
		
		return adminService.removeFaq(faqId);
	}
	//체크박스로 선택한 FAQ 배열 가져오고 삭제하기
	@PostMapping("/rest/admin/removeFaqBoardList")
	public String removeFaqBoardList(@RequestParam(value="checkBoxArr")List<String> faqBoardIdList) {
		System.out.println("::: post - removeFaqBoardList :::");
		System.out.println(faqBoardIdList.toString());
		adminService.removeFaqBoardList(faqBoardIdList);
		return "삭제성공";
	}
	//FAQ 수정하기
	@PostMapping("/rest/modifyFaqBorad")
	public int modifyFaqBoard(FaqBoard faqBoard) {
		System.out.println(":::post - modifyFaqBoard:::");
		System.out.println("faqBoard : " + faqBoard.toString());
		return adminService.modifyFaq(faqBoard);
	}
	//FAQ 리스트 바로 가져오기
	@PostMapping("/rest/admin/getFaqBoardList")
	public Map<String,Object> getFaqBoardList(@RequestParam(value="currentPage",defaultValue = "1")int currentPage,
			@RequestParam(value="rowPerPage",defaultValue = "10")int rowPerPage,
			@RequestParam(value="searchWord", required = false)String searchWord,
			@RequestParam(value="toDate", required = false)String toDate,
			 @RequestParam(value="fromDate", required = false)String fromDate,
			 @RequestParam(value="serviceCategoryId", required = false)String serviceCategoryId) {
		System.out.println("::: post - getFaqBoardList :::"); 
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : "+rowPerPage);
		System.out.println("searchWord : "+searchWord);
		System.out.println("toDate : "+toDate);
		System.out.println("fromDate : "+fromDate);
		System.out.println("serviceCategory : "+serviceCategoryId);
		return adminService.getFaqBoardList(currentPage, rowPerPage, searchWord, toDate, fromDate, serviceCategoryId);
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
	// 회원 삭제(y->n)
	@PostMapping("/rest/adminUserRemove")
	public String adminUserRemove(@RequestParam(value="checkBoxArr") List<String> checkBoxArr) {
		System.out.println("::: post - /rest/adminUserRemove :::");
		System.out.println(checkBoxArr);
		int checking = adminService.removeAdminUser(checkBoxArr);
		System.out.println("1이면 성공 : "+checking);
		return "adminUserListTest";
	}
	// 탈퇴회원 조회 리스트
	@PostMapping("/rest/adminWithdrawUserList")
	public Map<String,Object> adminWithdrawUserList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
			 @RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage,
			 @RequestParam(value="searchWord", required = false)String searchWord,
			 @RequestParam(value="toDate", required = false)String toDate,
			 @RequestParam(value="fromDate", required = false)String fromDate) {
		System.out.println("::: post - /rest/adminWithdrawUserList :::");
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : "+rowPerPage);
		System.out.println("searchWord : "+searchWord);
		System.out.println("toDate : "+toDate);
		System.out.println("fromDate : "+fromDate);
		return adminService.getAdminWithdrawUserList(currentPage, rowPerPage,searchWord, toDate, fromDate);
	}
// 회원 복구(n->Y)
	@PostMapping("/rest/adminWithdrawUserRestore")
	public String adminWithdrawUserModify(@RequestParam(value="checkBoxArr") List<String> checkBoxArr) {
		System.out.println("::: post - /rest/adminWithdrawUserRestore :::");
		System.out.println(checkBoxArr);
		int checking = adminService.modifyAdminWithdrawUser(checkBoxArr);
		System.out.println("1이면 성공 : "+checking);
		return "adminUserListTest";
	}
// 전문가 유저 조회
	@PostMapping("/rest/adminExpertUserList")
	public Map<String,Object> adminExpertUserList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
			 @RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage,
			 @RequestParam(value="searchWord", required = false)String searchWord,
			 @RequestParam(value="toDate", required = false)String toDate,
			 @RequestParam(value="fromDate", required = false)String fromDate) {
		System.out.println("::: post - /rest/adminExpertUserList :::");
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : "+rowPerPage);
		System.out.println("searchWord : "+searchWord);
		System.out.println("toDate : "+toDate);
		System.out.println("fromDate : "+fromDate);
		return adminService.getAdminExpertUserList(currentPage, rowPerPage,searchWord, toDate, fromDate);
	}
	
	@PostMapping("/rest/adminNoticeBoard")
	public Map<String, Object> postNotice(@RequestParam(value="currentPage",defaultValue = "1")int currentPage,
							@RequestParam(value="rowPerPage",defaultValue = "10")int rowPerPage,
							@RequestParam(value="searchWord", required = false)String searchWord,
							 @RequestParam(value="toDate", required = false)String toDate,
							 @RequestParam(value="fromDate", required = false)String fromDate) {
		
		System.out.println(":::post - adminNoticeBoard:::");
		System.out.println("currentPage"+currentPage);
		System.out.println("rowPerPage"+rowPerPage);
		System.out.println("searchWord"+searchWord);
		System.out.println("toDate : "+ toDate);
		System.out.println("fromDate : "+ fromDate);

		return adminService.getNoticeBoard(currentPage, rowPerPage, searchWord, toDate, fromDate);
	}
	
	@PostMapping("/rest/adminNoticeBoardOne")
	public NoticeBoard postNoticeOne(@RequestParam(value="noticeId") int noticeId) {
		System.out.println(":::post - adminNoticeBoardOne:::");
		System.out.println("noticeId"+noticeId);
		return adminService.getNoticeOne(noticeId);
	}
	
	@PostMapping("/rest/adminNoticeAdd")
	public int postNoticeAdd(NoticeBoard noticeBoard) {
		System.out.println(":::post - postNoticeAdd");
		System.out.println("NoticeBoard"+noticeBoard);
		return adminService.addNotice(noticeBoard);
	}
	
	//공지사항 삭제
	@PostMapping("/rest/removeNoticeBoard")
	public int removeNoticeBoard(@RequestParam(value="noticeId")int noticeId) {
		System.out.println(":::post - removeNoticeBoard:::");
		System.out.println("noticeId Remove : " + noticeId);
		return adminService.removeNoticeBoard(noticeId);
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

	// 문의 내역 리스트 가져오기
	@PostMapping("/rest/admin/getInquiryHistoryList")
	public Map<String,Object> getInquiryHistoryList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
									 @RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage,
									 @RequestParam(value="searchWord", required = false)String searchWord,
										@RequestParam(value="toDate", required = false)String toDate,
										 @RequestParam(value="fromDate", required = false)String fromDate,
										 @RequestParam(value="inquiryId", required = false)String inquiryId,
										 @RequestParam(value="inquiryCategory", required = false)String inquiryCategory) {
		System.out.println("::: post - getInquiryHistoryList :::"); 
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : "+rowPerPage);
		System.out.println("searchWord : "+searchWord);
		System.out.println("toDate : "+toDate);
		System.out.println("fromDate : "+fromDate);
		System.out.println("inquiryId : "+inquiryId);
		System.out.println("inquiryCategory : "+inquiryCategory);
		return adminService.getInquiryHistoryList(currentPage, rowPerPage, searchWord, toDate, fromDate, inquiryId, inquiryCategory);
	}
	// 신고 리스트 가져오기
	@PostMapping("/rest/admin/getReportHistoryList")
	public Map<String,Object> getReportHistoryList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
									 @RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage,
										@RequestParam(value="searchWord", required = false)String searchWord,
										 @RequestParam(value="toDate", required = false)String toDate,
										 @RequestParam(value="fromDate", required = false)String fromDate,
										 @RequestParam(value="reportId", required = false)String reportId,
										 @RequestParam(value="reportCategory", required = false)String reportCategory) {
		System.out.println("::: post - getReportHistoryList :::"); 
		System.out.println("currentPage : " + currentPage);
		System.out.println("rowPerPage : " + rowPerPage);
		System.out.println("searchWord : " + searchWord);
		System.out.println("toDate : " + toDate);
		System.out.println("fromDate : " + fromDate);
		System.out.println("reportId : " + reportId);
		System.out.println("reportCategory : " + reportCategory);
		
		return adminService.getReportHistoryList(currentPage, rowPerPage, searchWord, toDate, fromDate, reportId, reportCategory);
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
	
	@PostMapping("/rest/admin/getFeildList")
	public List<Feild> getFeildList() {
		System.out.println("::: post - FeildList :::");
		return adminService.getFeildList();
	}
	//검색 조건에 따른 리스트 가져오기
	@PostMapping("/rest/admin/getQuestionBoardList")
	public Map<String,Object> questionBoardList(Page page,@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
												@RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage) {
		System.out.println("::: post - questionBoardList :::");
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : " +rowPerPage);
		page.setRowPerPage(rowPerPage);
		System.out.println(page.toString());
		return adminService.getQuestionBoardList(page,currentPage);
	}
	
	//인증메일 전송
	@PostMapping("/rest/adminSendEmailToConfirm")
	public String adminSendEmailToConfirm(HttpSession session, Manager manager) {
		System.out.println("::: post - adminSendEmailToConfirm :::");
		
		System.out.println(manager.toString());		
		String code = adminService.sendCodeToMail(manager);
		session.setAttribute("verifyCode", code);
		
		return "success";
	}
	
	// 인증메일 확인
	@PostMapping("/rest/adminVerifyCode")
	public boolean adminVerifyCode(Manager manager, HttpSession session, String code) {
		System.out.println("::: post - adminVerifyCode :::");
		System.out.println(manager.toString() + "입력받은 코드:" +code);
		System.out.println("verifyCode : " + session.getAttribute("veriftCode"));
		
		if(session.getAttribute("verifyCode").equals(code) != true) {
			
			System.out.println("!password not correct");
			return false;
		}
		
		System.out.println("code correct!");
		adminService.addAdministrator(manager);
		
		return true;
	}
	
	//재전송
	@PostMapping("/rest/adminVerifyCodeForRest")
	public boolean adminVerifyCodeForRest(HttpSession session, String code) {
		System.out.println("::: post - adminVerifyCodeForRest :::");
		
		if(session.getAttribute("verifyCode").equals(code) != true) {
			System.out.println("!password not correct");
			System.out.println("code : "+code+", verifyCode: "+session.getAttribute("verifyCode"));
			return false;
		}
		
		System.out.println("code correct!");	
		return true;
	}
	// 관리자 전체 리스트 가져오기
	@PostMapping("/rest/adminManagerList")
	public Map<String,Object> getAdminManagerList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
			 										@RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage){
		System.out.println("::: post - getAdminManagerList :::");
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : "+rowPerPage);
		return adminService.getManagerList(currentPage, rowPerPage);
	}
	// 관리자 삭제하기
	@PostMapping("/rest/adminRemoveManager")
	public int removeManager(@RequestParam(value="managerId")String managerId) {
		System.out.println("::: post - removeManager :::");
		System.out.println("YyjService ManagerId   :  " + managerId);
		
		return adminService.removeManager(managerId);
	}
	// 관리자 상세보기 정보 가져오기
	@PostMapping("/rest/adminManagerOne")
	public Manager postManagerOne(@RequestParam(value="managerId")String managerId) {
		System.out.println(":::post - postManagerOne:::");
		System.out.println("managerId"+managerId);
		return adminService.getManagerOne(managerId);
	}
	
}
