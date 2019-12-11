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
	@GetMapping("/questionBoardOne")
	public String QuestionBoardOne(@RequestParam(value="questionId")String questionId) {
		System.out.println("::: get - QuestionBoardOne :::");
		System.out.println("questionId : "+questionId);
		return "questionBoardOne";
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
		return "notice";
	}
	
	@GetMapping("/noticeOne")
	public String getnoticeOne() {
		System.out.println("::: get - getnoticeOne :::"); 
		return "noticeOne";
	}
	
	@GetMapping("/userOne")
	public String getUserOne() {
		System.out.println("::: get - getUserOne :::");
		return "userOne";
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
		return "codeblue/ask";
	}
	
	@PostMapping("/addQuestion")
	public String postAsk(QuestionBoard questionBoard) {
		System.out.println("::: AskController-postAsk:::");
		System.out.println(questionBoard);
		userService.addQuestion(questionBoard);
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
		return "hospitalOne";
	}
	// 유저 보기
	@GetMapping("/users")
	public String getUserList() {
		System.out.println("::: get - getUserListTest :::");
		return "/users";
	}
	
}	
