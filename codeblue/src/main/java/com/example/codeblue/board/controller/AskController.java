package com.example.codeblue.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.codeblue.board.service.AskService;
import com.example.codeblue.board.vo.QuestionBoard;

@Controller
public class AskController {
	@Autowired AskService askSerivce;
	@GetMapping("/ask")
	public String getAsk() {
		System.out.println("::: AskController-getAsk:::");
		return "codeblue/ask";
	}
	
	@PostMapping("/addQuestion")
	public String postAsk(QuestionBoard questionBoard) {
		System.out.println("::: AskController-postAsk:::");
		System.out.println(questionBoard);
		askSerivce.addQuestion(questionBoard);
		return "/QnA";
	}
	
	
}
