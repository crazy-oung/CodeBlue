package com.example.codeblue.test.ljh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LjhController {
	//파일업로드 테스트
	@GetMapping("/adminAddHospitalTest")
	public String getadminAddHospitalTest() {
		System.out.println(":::get - getadminAddHospitalTest:::");
		return "/codeBlue/admin/adminAddHospitalTest";
	}
	@GetMapping("/adminInquiryTest")
	public String getadminInquiryTest() {
		System.out.println(":::get - adminInquiryTest:::");
		return "/codeBlue/admin/inquiryTest";
	}
	@GetMapping("/adminInquiryOneTest")
	public String getInquiryOneTest() {
		System.out.println(":::get - getInquiryOneTest:::");
		return "/codeBlue/admin/inquiryOneTest";
	}
	@GetMapping("/questionBoardOneTest")
	public String getquestionBoardOneTest() {
		System.out.println(":::get - getquestionBoardOneTest:::");
		return "questionBoardOneTest";
	}
}