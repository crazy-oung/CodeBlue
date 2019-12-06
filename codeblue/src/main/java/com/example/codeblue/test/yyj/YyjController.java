package com.example.codeblue.test.yyj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class YyjController {
	@Autowired YyjService service;
	
//	@GetMapping("/adminNoticeBoardTest")
//	public String getNotice() {
//		System.out.println(":::get - getNotice:::");
//	return "/codeBlue/admin/adminNoticeBoardTest";
//	}
//	
//	@GetMapping("/adminNoticeOneTest")
//	public String getNoticeOne() {
//		System.out.println(":::get - getNoticeOne");
//		return "/codeBlue/admin/adminNoticeOneTest";
//	}
//	
//	@GetMapping("/adminNoticeAddTest")
//	public String getNoticeAdd() {
//		System.out.println(":::get - getNoticeAdd");
//		return"/codeBlue/admin/adminNoticeInsertTest";
//	}
}
