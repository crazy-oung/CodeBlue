package com.example.codeblue.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AdminInquiryController {
	
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
}