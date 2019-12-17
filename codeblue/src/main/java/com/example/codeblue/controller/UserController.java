package com.example.codeblue.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.codeblue.service.UserService;
import com.example.codeblue.vo.QuestionBoard;

@Controller
public class UserController {
	@Autowired UserService userService;
	
	//유저 활동 페이지
	@GetMapping("/userOneActive")
	public String getUserOneProfile() {
		System.out.println(":::get - getUserOneProfile:::");
		return "userOneActive";
	}
	
	//질문 수정 페이지
	@GetMapping("/modifyQuestion")
	public String getModifyQuestion() {
		System.out.println(":::get - getModifyQuestion:::");
		return "modifyQuestion";
	}
	
	//답변 신고창
	@GetMapping("/answerReport")
	public String answerReport() {
		return "/answerReport";
	}
	//질문 신고창
	@GetMapping("/questionReport")
	public String questionReport() {
		return "/questionReport";
	}
	
	// 태그 출력 페이지
	@GetMapping("/tags")
	public String getTags() {
		System.out.println("::: bget - getTags :::");
		return "/tags";
	}
	
	//검색되는 리스트
	@GetMapping("/search") 
	public String getsearch() {
		return "/search";
	}
	//답변이 많은 수
	@GetMapping("/hot")
	public String gethot() {
		System.out.println("::: get - gethot :::"); 
		return "/hot";
	}
	//답변이 제일적으면서, 제일먼저올린질문
	@GetMapping("/help")
	public String gethelp() {
		System.out.println("::: get - gethelp :::"); 
		return "/help";
	}
	//답변이 최근에 적힌 질문순서
	@GetMapping("/ongoing")
	public String getongoing() {
		System.out.println("::: get - getongoing :::"); 
		return "/ongoing";
	}
	@GetMapping("/questionBoardOne")
	public String QuestionBoardOne(@RequestParam(value="questionId")String questionId) {
		System.out.println("::: get - QuestionBoardOne :::");
		System.out.println("questionId : "+questionId);
		return "/questionBoardOne";
	}
	
	@GetMapping("/QnA")
	public String getQnA() {
		System.out.println("::: get - getQnA :::"); 
		return "/QnA";
	}
	@GetMapping("/today")
	public String getToday() {
		System.out.println("::: get - getToday :::"); 
		return "/home";
	}
	
	@GetMapping("/notice")
	public String notice() {
		System.out.println("::: get - notice :::"); 
		return "/notice";
	}
	
	@GetMapping("/noticeOne")
	public String getnoticeOne() {
		System.out.println("::: get - getnoticeOne :::"); 
		return "/noticeOne";
	}
	
	@GetMapping("/userOne")
	public String getUserOne() {
		System.out.println("::: get - getUserOne :::");
		return "/userOne";
	}
	
	 @GetMapping("/oops!")
     public String errorpage(){
//         throw new IllegalStateException("Error");
		 return "/404";
     }
	 
	 @GetMapping("/ask")
	public String getAsk(HttpSession session) {
		System.out.println("::: AskController-getAsk:::");
		if(session.getAttribute("loginUser") == null) {
			return "/login";
		}
		return "/codeblue/ask";
	}
	
	@PostMapping("/addQuestion")
	public String postAsk(QuestionBoard questionBoard) {
		System.out.println("::: AskController-postAsk:::");
		System.out.println(questionBoard);
		// 질문 등록
		userService.addQuestion(questionBoard);
		// 태그 등록 시작
		int questionId = userService.getLastQuestionId();
		System.out.println(questionId);
		userService.addTag(questionBoard.getQuestionTags(),questionId);
		
		return "/QnA";
	}
	
	//제휴병원 게시판
	@GetMapping("/hospital")
	public String getHospital() {
		System.out.println(":::get - getHospital:::");
		return "hospital";
	}
	
	//제휴병원 상세보기
	@GetMapping("/hospitalOne")
	public String getHospitalOne() {
		System.out.println(":::get - getHospitalOne:::");
		return "/hospitalOne";
	}
	// 유저 보기
	@GetMapping("/users")
	public String getUserList() {
		System.out.println("::: get - getUserListTest :::");
		return "/users";
	}
	// faq 조회
	@GetMapping("/faq")
	public String getFaqList() {
		System.out.println("::: get - getFaqList :::");
		return "/faq";
	}
	// faqOne 조회
	@GetMapping("/faqOne")
	public String getFaqOne() {
		System.out.println("::: get - getFaqOne :::");
		return "/faqOne";
	}
	//문의 상세페이지
	@GetMapping("/getInquiryOne")
	public String getInquiryOne() {
		System.out.println("::: get - getInquiryOne :::");
		return "/inquiryOne";
	}
	// 문의하기
	@GetMapping("/addInquiryHistory")
	public String addInquiryHistory() {
		System.out.println("::: get - addInquiryHistory :::");
		return "/addInquiry";
	}
	// 문의내역 조회
	@GetMapping("/inquiryBoard")
	public String getInquiryBoard(HttpSession session) {
		System.out.println("::: get - inquiryBoard :::");
		return "/inquiryBoard";
	}
	//유저 비번, 이름 변경
	@GetMapping("/modifyProfile")
	public String modifyUserProfile(HttpSession session) {
		System.out.println("Get modifyUserProfile:::");
		if(session.getAttribute("loginUser") != null) {
			return "/modifyProfile";
		}
		return "/login";
	}
	//
		
}	
