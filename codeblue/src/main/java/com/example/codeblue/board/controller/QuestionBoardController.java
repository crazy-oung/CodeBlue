package com.example.codeblue.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.codeblue.board.vo.QuestionBoard;

@Controller
public class QuestionBoardController {
	
	
	@GetMapping("/questionBoardOne")
	public String QuestionBoardOne(@RequestParam(value="questionId")String questionId) {
		System.out.println("::: get - QuestionBoardOne :::");
		System.out.println("questionId : "+questionId);
		
		return "questionBoardOne";
	}
	
}
