package com.example.codeblue.test.jjw;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class JJWController {
	
	@GetMapping("/test")
	public String gettest() {
		return "/test";
	}
	
	@GetMapping("/test1")
	public String gettest1() {
		return "/test1";
	}
//	@GetMapping("/search") 
//	public String getsearch() {
//		return "/search";
//	}
//	//답변이 많은 수
//	@GetMapping("/hot")
//	public String gethot() {
//		System.out.println("::: get - gethot :::"); 
//		return "/hot";
//	}
//	//답변이 제일적으면서, 제일먼저올린질문
//	@GetMapping("/help")
//	public String gethelp() {
//		System.out.println("::: get - gethelp :::"); 
//		return "/help";
//	}
//	@GetMapping("/ongoing")
//	public String getongoing() {
//		System.out.println("::: get - getongoing :::"); 
//		return "/ongoing";
//	}
	
//	//질문댓글 리스트 페이지
//	@GetMapping("/adminQuestionComment")
//	public String getQuestionComment() {
//		System.out.println("::: get - adminQuestionComment :::");
//		return "/codeblue/admin/adminQuestionComment";
//	}
//
//	//답변댓글 리스트 페이지
//	@GetMapping("/adminAnswerComment")
//	public String getAnswerComment() {
//		System.out.println("::: get - adminAnswerComment :::");
//		return "/codeblue/admin/adminAnswerComment";
//	}
//	//답변 리스트 페이지
//	@GetMapping("/adminAnswer")
//	public String getAnswer() {
//		System.out.println("::: get - getAnswer :::");
//		return "/codeblue/admin/adminAnswer";
//	}
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
