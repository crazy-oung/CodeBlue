package com.example.codeblue.test.jjw;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.Feild;
import com.example.codeblue.vo.Inquiry;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.InquiryHistoryAnswer;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.Report;
import com.example.codeblue.vo.ReportHistory;
import com.example.codeblue.vo.User;


@org.springframework.web.bind.annotation.RestController
public class JJWRestController {
	
	@Autowired
	private JJWService service;
	
//	//문의 답변 가져오기
//	@PostMapping("/rest/getInquiryHistoryAnswerOne")
//	public InquiryHistoryAnswer getInquiryHistoryAnswerOne(int inquiryHistoryId) {
//		System.out.println("::: post - getInquiryHistoryAnswerOne :::");
//		System.out.println("inquiryHistoryId : "+inquiryHistoryId);
//		return service.getInquiryHistoryAnswerOne(inquiryHistoryId);
//	}
//	
//	//문의 상세내용 가져오기
//	@PostMapping("/rest/getInquiryHistoryOne")
//	public InquiryHistory getInquiryHistoryOne(int inquiryHistoryId) {
//		System.out.println("::: post - getInquiryHistoryOne :::");
//		System.out.println("inquiryHistoryId : "+inquiryHistoryId);
//		return service.getInquiryHistoryOne(inquiryHistoryId);
//	}
//	//문의 사항 저장
//	@PostMapping("/rest/addInquiryHistory")
//	public String addInquiryHistory(HttpSession session,InquiryHistory inquiryHistory) {
//		System.out.println("::: post - addInquiryHistory :::");
//		System.out.println(inquiryHistory.toString());
//		System.out.println(session.getAttribute("loginUser"));
//		if(session.getAttribute("loginUser") == null) {
//			System.out.println("already loged in Back to user Home");
//			return "false";
//		}
//		inquiryHistory.setUser((User) session.getAttribute("loginUser"));
//		service.addInquiryHistory(inquiryHistory);
//		return "success";
//	}
	
	//문의 카테고리
	@PostMapping("/rest/getInquiryList")
	public List<Inquiry> getInquiryList() {
		System.out.println("::: post - getReportList :::");
		return service.getInquiryList();
	}
	
//	//답변 상세정보
//	@PostMapping("/rest/getAnswerOne")
//	public Answer getAnswerOne(String answerId) {
//		System.out.println("::: post - getAnswerOne :::");
//		System.out.println("answerId " + answerId);
//		return service.getAnswerOne(answerId);
//	}
//	// 신고내역 저장하기
//	@PostMapping("/rest/addReport")
//	public String addReport(HttpSession session,ReportHistory reportHistory) {
//		System.out.println("::: post - addReport :::");
//		System.out.println(reportHistory.toString());
//		System.out.println(session.getAttribute("loginUser"));
//		if(session.getAttribute("loginUser") == null) {
//			System.out.println("already loged in Back to user Home");
//			return "false";
//		}
//		reportHistory.setUser((User) session.getAttribute("loginUser"));
//		service.addReportHistory(reportHistory);
//		return "success";
//	}
//	//신고카테고리리스트
//	@PostMapping("/rest/getReportList")
//	public List<Report> getReportList(){
//		System.out.println("::: post - getReportList :::");
//		return service.getReportList();
//	}
//	//답변 댓글 지우기
//	@PostMapping("/rest/admin/removeAnswerCommentList")
//	public String removeAnswerCommentList(@RequestParam(value="checkBoxArr")List<String> answerCommentIdList) {
//		System.out.println("::: post - removeAnswerCommentList :::");
//		System.out.println(answerCommentIdList.toString());
//		service.removeAnswerCommentList(answerCommentIdList);
//		return "답변 댓글 삭제 성공";
//	}
//	//답변 댓글 리스트 가져오기
//	@PostMapping("/rest/admin/getAnswerCommentList")
//	public Map<String,Object> getAnswerCommentList(Page page,@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
//													@RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage){
//		System.out.println("::: post - getAnswerCommentList :::");
//		System.out.println(page.toString());
//		System.out.println("currentPage : "+currentPage);
//		System.out.println("rowPerPage : "+rowPerPage);
//		page.setRowPerPage(rowPerPage);
//		return service.getAnswerCommentList(page, currentPage);
//	}
//	//질문 댓글 지우기
//	@PostMapping("/rest/admin/removeQuestionCommentList")
//	public String removeQuestionCommentList(@RequestParam(value="checkBoxArr")List<String> questionCommentIdList) {
//		System.out.println("::: post - removeQuestionCommentList :::");
//		System.out.println(questionCommentIdList.toString());
//		service.removeQuestionCommentList(questionCommentIdList);
//		return "질문 댓글 삭제 성공";
//	}
//	//질문 댓글 리스트 가져오기
//	@PostMapping("/rest/admin/getQuestionCommentList")
//	public Map<String,Object> getQuestionCommentList(Page page,@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
//														@RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage){
//		System.out.println("::: post - getQuestionCommentList :::");
//		System.out.println(page.toString());
//		System.out.println("currentPage : "+currentPage);
//		System.out.println("rowPerPage : "+rowPerPage);
//		page.setRowPerPage(rowPerPage);
//		return service.getQuestionCommentList(page, currentPage);
//	}
//	//답변 상세정보
//	@PostMapping("/rest/getAnswerOne")
//	public Answer getAnswerOne(@RequestParam(value="answerId")String answerId) {
//		System.out.println("::: post - getAnswerOne :::");
//		System.out.println("answerId : "+answerId);
//		return service.getAnswerOne(answerId);
//	}
//	//답변 삭제 하기
//	@PostMapping("/rest/removeAnswerList")
//	public String removeAnswerList(@RequestParam(value="checkBoxArr")List<String> answerIdList) {
//		System.out.println("::: post - removeAnswerList :::");
//		System.out.println(answerIdList.toString());
//		service.removeAnswerList(answerIdList);
//		return "답변 삭제 성공";
//	}
//	//답변 리스트 가져오기
//	@PostMapping("/rest/getAnswerList")
//	public Map<String,Object> getAnswerList(Page page,@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
//												@RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage) {
//		System.out.println("::: post - getAnswerList :::");
//		System.out.println(page.toString());
//		System.out.println("currentPage : "+currentPage);
//		System.out.println("rowPerPage : "+rowPerPage);
//		page.setRowPerPage(rowPerPage);
//		return service.getAnswerList(page, currentPage);
//	}
//	
//	@PostMapping("/rest/getWithdrawQuestionBoardOne")
//	public QuestionBoard getWithdrawQuestionBoardOne(@RequestParam(value="questionId")String questionId) {
//		System.out.println("::: post - getWithdrawQuestionBoardOne :::");
//		System.out.println("questionId "+questionId);
//		return service.getWithdrawQuestionBoardOne(questionId);
//	}
//	
//	@PostMapping("/rest/getQuestionBoardOne")
//	public QuestionBoard getQuestionBoardOne(@RequestParam(value="questionId")String questionId) {
//		System.out.println("::: post - getQuestionBoardOne :::");
//		System.out.println("questionId "+questionId);
//		return service.getQuestionBoardOne(questionId);
//	}
//	//검색 조건에 따른 삭제된 게시글 가져오기
//	@PostMapping("/rest/getWithdrawQuestionBoardList")
//	public Map<String,Object> getWithdrawQuestionBoardList(Page page,@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
//												@RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage) {
//		System.out.println("::: post - questionBoardList :::");
//		System.out.println("currentPage : "+currentPage);
//		System.out.println("rowPerPage : " +rowPerPage);
//		page.setRowPerPage(rowPerPage);
//		System.out.println(page.toString());
//		return service.getWithdrawQuestionBoardList(page,currentPage);
//	}
//	
//	//체크박스로 선택한 questionId 배열 가져오기
//	@PostMapping("/rest/removeQuestionBoardList")
//	public String removeQuestionBoardList(@RequestParam(value="checkBoxArr")List<String> questionBoardIdList) {
//		System.out.println("::: post - removeQuestionBoardList :::");
//		System.out.println(questionBoardIdList.toString());
//		service.removeQeustionBoardList(questionBoardIdList);
//		return "삭제성공";
//	}
//	
//	@PostMapping("/rest/getFeildListTest")
//	public List<Feild> getFeildList() {
//		System.out.println("::: post - FeildList :::");
//		return service.getFeildList();
//	}
	//검색 조건에 따른 리스트 가져오기
//	@PostMapping("/rest/getQuestionBoardListTest")
//	public Map<String,Object> questionBoardList(Page page,@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
//												@RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage) {
//		System.out.println("::: post - questionBoardList :::");
//		System.out.println("currentPage : "+currentPage);
//		System.out.println("rowPerPage : " +rowPerPage);
//		page.setRowPerPage(rowPerPage);
//		System.out.println(page.toString());
//		return service.getQuestionBoardList(page,currentPage);
//	}
}
