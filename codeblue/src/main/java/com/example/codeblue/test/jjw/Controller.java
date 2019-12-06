package com.example.codeblue.test.jjw;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping("/adminQuestionBoardTest")
	public String getQuestionBoardList() {
		System.out.println("::: get - getQuestionBoardList :::");
		return "/codeBlue/admin/adminQuestionBoardTest";
	}
}
