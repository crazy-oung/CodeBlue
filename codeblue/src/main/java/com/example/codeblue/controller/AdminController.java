package com.example.codeblue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	@GetMapping({"adminInquiryBoard","adminReportBoard"})
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
	
	@GetMapping("/adminUserList")
	public String adminUserList() {
		System.out.println("::: get - adminUserList :::");
		return "/codeBlue/admin/userList";
	}
	
	@GetMapping("/adminNoticeBoard")
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
	
	@GetMapping("/adminQuestionBoard")
	public String getAdminBoard() {
		System.out.println("::: get - getAdminBoard :::");
		return "/codeBlue/admin/adminQuestionBoard";
	}
	
	@GetMapping("admin")
	public String getAdmin() {
		return "/codeBlue/admin/home";
	}
}
