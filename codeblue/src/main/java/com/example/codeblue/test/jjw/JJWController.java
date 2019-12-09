package com.example.codeblue.test.jjw;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class JJWController {

	//답변 리스트 페이지
	@GetMapping("/adminAnswer")
	public String getAnswer() {
		System.out.println("::: get - getAnswer :::");
		return "/codeblue/admin/adminAnswer";
	}
//	//삭제된 게시물 리스트 페이지
//	@GetMapping("/adminWithdrawQuestionBoard")
//	public String getWithdramQuestionBoard() {
//		System.out.println("::: get - getWithdramQuestionBoard :::");
//		return "/codeBlue/admin/adminWithdrawQuestionBoard";
//	}
	
//	@GetMapping("/adminQuestionBoardTest")
//	public String getQuestionBoardList() {
//		System.out.println("::: get - getQuestionBoardList :::");
//		return "/codeBlue/admin/adminQuestionBoardTest";
//	}
}
