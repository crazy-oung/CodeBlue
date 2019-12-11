package com.example.codeblue.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.codeblue.service.AdminService;
import com.example.codeblue.vo.Manager;

@Controller
public class AdminController {
	@Autowired AdminService adminService;
	
	//질문댓글 리스트 페이지
	@GetMapping("/adminQuestionComment")
	public String getQuestionComment() {
		System.out.println("::: get - adminQuestionComment :::");
		return "/codeblue/admin/adminQuestionComment";
	}

	//답변댓글 리스트 페이지
	@GetMapping("/adminAnswerComment")
	public String getAnswerComment() {
		System.out.println("::: get - adminAnswerComment :::");
		return "/codeblue/admin/adminAnswerComment";
	}
	
	//답변 리스트 페이지
	@GetMapping("/adminAnswer")
	public String getAnswer() {
		System.out.println("::: get - getAnswer :::");
		return "/codeblue/admin/adminAnswer";
	}
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
		return "/codeBlue/admin/adminReportBoard";
	}
	//문의내역 리스트 페이지로 이동
	@GetMapping("adminInquiryBoard")
	public String getInquiry(HttpSession session) {
		System.out.println("::: get - adminInquiry :::");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		return "/codeBlue/admin/adminInquiryBoard";
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
	
	// 유저 조회
	@GetMapping("/adminUserList")
	public String adminUserList(HttpSession session) {
		System.out.println("::: get - adminUserList :::");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		return "/codeBlue/admin/adminUserList";
	}
	// 탈퇴 유저 조회
	@GetMapping("/adminWithdrawUserList")
	public String adminWithdrawUserList() {
		System.out.println("::: get - adminWithdrawUserList :::");
		return "/codeBlue/admin/adminWithdrawUserList";
	}
	
	// 전문가 유저 조회
	@GetMapping("/adminExpertUserList")
	public String adminExpertUserList() {
		System.out.println("::: get - adminExpertUserList :::");
		return "/codeBlue/admin/adminExpertUserList";
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
	//관리자 계정 추가
	@GetMapping("/manageAdmin")
	public String addAdministrator(Manager manager) {
			System.out.println("::get - addAdministrator:::");
		return "/codeBlue/admin/adminAddAdministrator";
	}
	//관리자 전체 리스트 가져오기
	@GetMapping("/adminManagerList")
	public String getAdminManagerList() {
		System.out.println("::: get - getAdminManagerList :::");
		return "/codeBlue/admin/adminManagerList";
	}
	//관리자 상세정보 페이지
	@GetMapping("/adminManagerOne")
	public String getAdminManagerOne() {
		System.out.println("::: get - getAdminManagerOne :::");
		return"/codeBlue/admin/adminManagerOne";
	}
	
}
