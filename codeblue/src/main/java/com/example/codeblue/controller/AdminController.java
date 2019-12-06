package com.example.codeblue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.codeblue.service.AdminService;



@Controller
public class AdminController {
	@Autowired AdminService adminService;
	
	//병원정보 수정
	@GetMapping("/modifyHospital")
	public String getModifyHospital(@RequestParam(value="hospitalId")int hospitalId) {
		System.out.println(":::get - getModifyHospital:::");
		System.out.println("hospital"+hospitalId);
		return "/codeBlue/admin/adminModifyHospital";
	}
	
	//제휴병원 게시판
	@GetMapping("/adminHospital")
	public String getHospital() {
		System.out.println(":::get - getHospital:::");
		return"/codeBlue/admin/adminHospital";
	}
	
	//제휴병원 입력
	@GetMapping("/addHospital")
	public String getAddHospital() {
		System.out.println(":::get - AddHospital:::");
		return"/codeBlue/admin/adminAddHospital";
	}
	
	//제휴병원 삭제
	@GetMapping("/removeHospital")
	public String postRemoveHospital(@RequestParam(value="hospitalId")int hospitalId) {
		System.out.println(":::post - postRemoveHospital:::");
		System.out.println("hospitalId"+hospitalId);
		adminService.removeHospital(hospitalId);
		return "/codeBlue/admin/adminHospitalOne";
	}
	
	//제휴병원 상세보기
	@GetMapping("/getHospitalOne")
	public String getHospitalOne(@RequestParam(value="hospitalId")int hospitalId) {
		System.out.println(":::get - getHospitalOne:::");
		System.out.println("hospitalId"+hospitalId);
		
		return"/codeBlue/admin/adminHospitalOne";
	}
	//신고내역 리스트 페이지로 이동
	@GetMapping("adminReportBoard")
	public String getReport() {
		System.out.println("::: get - getReport :::");
		return "/codeBlue/admin/report";
	}
	//문의내역 리스트 페이지로 이동
	@GetMapping("adminInquiryBoard")
	public String getInquiry() {
		System.out.println("::: get - adminInquiry :::");
		return "/codeBlue/admin/inquiry";
	}
	//문의내역 상세 페이지로 이동
	@GetMapping("adminInquiryOne")
	public String getInquiryOne() {
		System.out.println("::: get - getInquiryOne :::");
		return "/codeBlue/admin/inquiryOne";
	}
	//신고내역 상세 페이지로 이동
	@GetMapping("adminReportOne")
	public String getReportOne() {
		System.out.println("::: get - getReportOne :::");
		return "/codeBlue/admin/reportOne";
	}
	
	@GetMapping("/adminUserList")
	public String adminUserList() {
		System.out.println("::: get - adminUserList :::");
		return "/codeBlue/admin/adminUserList";
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
