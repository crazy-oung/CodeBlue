package com.example.codeblue.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.codeblue.service.AdminService;

@Controller
public class AdminController {
	@Autowired AdminService adminService;
	
	//삭제된 게시물 리스트 페이지
	@GetMapping("/adminWithdrawQuestionBoard")
	public String getWithdramQuestionBoard(HttpSession session) {
		System.out.println("::: get - getWithdramQuestionBoard :::");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		return "/codeBlue/admin/adminWithdrawQuestionBoard";
	}
	
	//FAQ 상세 페이지
	@GetMapping("/adminFaqOne")
	public String getFaqOne(HttpSession session) {
		System.out.println(":::get - getFaqOne:::");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		return"/codeBlue/admin/adminFaqOne";
	}
	//FAQ 수정페이지
	@GetMapping("/adminFaqModify")
	public String modifyFaq(HttpSession session) {
		System.out.println(":::get - modifyFaq:::");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		return"/codeBlue/admin/adminModifyFaqBoard";
	}
	//FaQ 게시판 페이지로 이동
	@GetMapping("/adminFaqBoard")
	public String getFaqBoard(HttpSession session) {
		System.out.println(":::get - getFaqBoard:::");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		return "/codeBlue/admin/adminFaqBoard";
	}
	//FaQ 게시판 페이지로 이동
	@GetMapping("/adminFaqBoardAdd")
	public String addFaqBoard(HttpSession session) {
		System.out.println(":::get - addFaqBoard:::");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		return "/codeBlue/admin/adminAddFaqBoard";
	}
	//병원정보 수정
	@GetMapping("/modifyHospital")
	public String getModifyHospital(HttpSession session, @RequestParam(value="hospitalId")int hospitalId) {
		System.out.println(":::get - getModifyHospital:::");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		System.out.println("hospital"+hospitalId);
		return "/codeBlue/admin/adminModifyHospital";
	}
	
	//제휴병원 게시판
	@GetMapping("/adminHospital")
	public String getHospital(HttpSession session) {
		System.out.println(":::get - getHospital:::");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		return"/codeBlue/admin/adminHospital";
	}
	
	//제휴병원 입력
	@GetMapping("/addHospital")
	public String getAddHospital(HttpSession session) {
		System.out.println(":::get - AddHospital:::");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		return"/codeBlue/admin/adminAddHospital";
	}
	
	//제휴병원 삭제
	@GetMapping("/removeHospital")
	public String postRemoveHospital(HttpSession session, @RequestParam(value="hospitalId")int hospitalId) {
		System.out.println(":::post - postRemoveHospital:::");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		System.out.println("hospitalId"+hospitalId);
		adminService.removeHospital(hospitalId);
		return "/codeBlue/admin/adminHospitalOne";
	}
	
	//제휴병원 상세보기
	@GetMapping("/getHospitalOne")
	public String getHospitalOne(HttpSession session, @RequestParam(value="hospitalId")int hospitalId) {
		System.out.println(":::get - getHospitalOne:::");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		System.out.println("hospitalId"+hospitalId);
		return"/codeBlue/admin/adminHospitalOne";
	}
	
	//신고내역 리스트 페이지로 이동
	@GetMapping("adminReportBoard")
	public String getReport(HttpSession session) {
		System.out.println("::: get - getReport :::");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		return "/codeBlue/admin/report";
	}
	//문의내역 리스트 페이지로 이동
	@GetMapping("adminInquiryBoard")
	public String getInquiry(HttpSession session) {
		System.out.println("::: get - adminInquiry :::");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		return "/codeBlue/admin/inquiry";
	}
	//문의내역 상세 페이지로 이동
	@GetMapping("adminInquiryOne")
	public String getInquiryOne(HttpSession session) {
		System.out.println("::: get - getInquiryOne :::");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		return "/codeBlue/admin/inquiryOne";
	}
	//신고내역 상세 페이지로 이동
	@GetMapping("adminReportOne")
	public String getReportOne(HttpSession session) {
		System.out.println("::: get - getReportOne :::");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		return "/codeBlue/admin/reportOne";
	}
	
	@GetMapping("/adminUserList")
	public String adminUserList(HttpSession session) {
		System.out.println("::: get - adminUserList :::");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		return "/codeBlue/admin/adminUserList";
	}
	
	@GetMapping("/adminNoticeBoard")
	public String getNotice(HttpSession session) {
		System.out.println(":::get - getNotice:::");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
	return "/codeBlue/admin/adminNoticeBoard";
	}
	
	@GetMapping("/adminNoticeOne")
	public String getNoticeOne(HttpSession session) {
		System.out.println(":::get - getNoticeOne");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		return "/codeBlue/admin/adminNoticeOne";
	}
	
	@GetMapping("/adminNoticeAdd")
	public String getNoticeAdd(HttpSession session) {
		System.out.println(":::get - getNoticeAdd");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		return"/codeBlue/admin/adminAddNotice";
	}
	//질문 리스트 가져오기
	@GetMapping("/adminQuestionBoard")
	public String getQuestionBoardList(HttpSession session) {
		System.out.println("::: get - getQuestionBoardList :::");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		return "/codeBlue/admin/adminQuestionBoard";
	}
	
	@GetMapping("admin")
	public String getAdmin(HttpSession session) {
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		return "/codeBlue/admin/home";
	}
}
