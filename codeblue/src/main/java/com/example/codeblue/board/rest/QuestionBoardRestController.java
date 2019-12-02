package com.example.codeblue.board.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionBoardRestController {

	@PostMapping("/rest/getBoardList")
	public String getBoardList() {
		System.out.println("::: post - getBoardList :::");
		
		return "success";
	}
}
