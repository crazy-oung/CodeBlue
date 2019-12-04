package com.example.codeblue.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminNoticeController {

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
}
