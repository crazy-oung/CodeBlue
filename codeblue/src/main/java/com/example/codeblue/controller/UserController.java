package com.example.codeblue.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.codeblue.service.UserService;
import com.example.codeblue.vo.QuestionBoard;

@Controller
public class UserController {
	@Autowired UserService userService;
	
	@GetMapping("/userOne")
	public String getUserOne() {
		System.out.println("::: get - getUserOne :::");
		return "userOne";
	}
	
	 @GetMapping("/oops!")
     public String errorpage(){
         throw new IllegalStateException("Error");
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
}	
