package com.example.codeblue.test.hyol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HyolController {
	
	// 유저 조회
	@GetMapping("/adminUserListTest")
	public String adminUserListTest() {
		System.out.println("::: get - adminUserListTest :::");
		return "/codeBlue/admin/adminUserListTest";
	}
	
	// 탈퇴 유저 조회
	@GetMapping("/adminWithdrawUserListTest")
	public String adminWithdrawUserListTest() {
		System.out.println("::: get - adminWithdrawUserListTest :::");
		return "/codeBlue/admin/adminWithdrawUserListTest";
	}
	
	// 전문가 유저 조회
	@GetMapping("/adminExpertUserListTest")
	public String adminExpertUserListTest() {
		System.out.println("::: get - adminExpertUserListTest :::");
		return "/codeBlue/admin/adminExpertUserListTest";
	}
	// 사용자 유저조회
	@GetMapping("/getUserListTest")
	public String getUserList() {
		System.out.println("::: get - getUserListTest :::");
		return "/UserListTest";
	}
	// faq 조회
	@GetMapping("/getFaqListTest")
	public String getFaqList() {
		System.out.println("::: get - getFaqListTest :::");
		return "/faqTest";
	}
	// faqOne 조회
	@GetMapping("/getFaqOneTest")
	public String getFaqOne() {
		System.out.println("::: get - getFaqOneTest :::");
		return "/faqOneTest";
	}
}