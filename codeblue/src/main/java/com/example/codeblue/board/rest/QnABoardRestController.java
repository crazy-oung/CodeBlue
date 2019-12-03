package com.example.codeblue.board.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QnABoardRestController {
	@GetMapping("/QnA")
	public String getQnA() {
		return "/QnA";
	}
	
}
