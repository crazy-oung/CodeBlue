package com.example.codeblue.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.codeblue.service.BoardService;

@Controller
public class BoardController {
	@Autowired BoardService boardService;
	
	@GetMapping({"adminInquiry","adminReport"})
	public String getInquiry() {
		System.out.println("::: get - adminInquiry :::");
		return "/codeBlue/admin/inquiry";
	}
	@GetMapping("adminInquiryOne")
	public String getInquiryOne() {
		System.out.println("::: get - getInquiryOne :::");
		return "/codeBlue/admin/inquiryOne";
	}
	@GetMapping("adminReportOne")
	public String getReportOne() {
		System.out.println("::: get - getReportOne :::");
		return "/codeBlue/admin/reportOne";
	}
	
	@GetMapping("/admin/userList")
	public String adminUserList() {
		System.out.println("::: get - adminUserList :::");
		return "/codeBlue/admin/userList";
	}
	
	@GetMapping("/adminNotice")
	public String getNotice() {
		System.out.println(":::get - getNotice:::");
	return "/codeBlue/admin/adminNoticeBoard";
	}
	
	@GetMapping("/adminNoticeOne")
	public String getNoticeOne() {
		System.out.println(":::get - getNoticeOne");
		return "/codeBlue/admin/adminNoticeOne";
	}
	
	@GetMapping("/adminNoticeAdd")
	public String getNoticeAdd() {
		System.out.println(":::get - getNoticeAdd");
		return"/codeBlue/admin/adminNoticeInsert";
	}
	
	@GetMapping("/adminBoard")
	public String getAdminBoard() {
		System.out.println("::: get - getAdminBoard :::");
		return "/codeBlue/admin/board";
	}
	
	@GetMapping("/questionBoardOne")
	public String QuestionBoardOne(@RequestParam(value="questionId")String questionId) {
		System.out.println("::: get - QuestionBoardOne :::");
		System.out.println("questionId : "+questionId);
		
		return "questionBoardOne";
	}
	
	@GetMapping("/QnA")
	public String getQnA() {
		return "/QnA";
	}
	
	@GetMapping("/notice")
	public String notice() {
		System.out.println("::: get - notice :::"); 
		return "notice";
	}
	
	@GetMapping("/noticeOne")
	public String noticeOne() {
		System.out.println("::: get - noticeOne :::"); 
		return "noticeOne";
	}
	
	@GetMapping("/")
	public String getHome(HttpSession session) {
		System.out.println("::: get - codeBlue home :::");
		if(session.getAttribute("user") == null) {
			return "/home";
		}
		
		return "/codeBlue/today";
	}
}
