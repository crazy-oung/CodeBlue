package com.example.codeblue.test.hyol;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.service.AdminService;
import com.example.codeblue.vo.FaqBoard;
import com.example.codeblue.vo.Inquiry;
import com.example.codeblue.vo.ServiceCategory;
import com.example.codeblue.vo.User;
import com.sun.mail.iap.Response;
@RestController
public class HyolRestController {

	@Autowired private HyolService hyolService;
		// 회원 조회 리스트
		@PostMapping("/rest/adminUserListTest")
		public Map<String,Object> adminUserList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
				 @RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage,
				 @RequestParam(value="searchWord", required = false)String searchWord,
				 @RequestParam(value="toDate", required = false)String toDate,
				 @RequestParam(value="fromDate", required = false)String fromDate) {
			System.out.println("::: post - /rest/adminuserListTest :::");
			System.out.println("currentPage : "+currentPage);
			System.out.println("rowPerPage : "+rowPerPage);
			System.out.println("searchWord : "+searchWord);
			System.out.println("toDate : "+toDate);
			System.out.println("fromDate : "+fromDate);
			return hyolService.getAdminUserList(currentPage, rowPerPage,searchWord, toDate, fromDate);
		}
		// 회원 삭제(y->n)
		@PostMapping("/rest/adminUserRemoveTest")
		public String adminUserRemove(@RequestParam(value="checkBoxArr") List<String> checkBoxArr) {
			System.out.println("::: post - /rest/adminUserRemoveTest :::");
			System.out.println(checkBoxArr);
			int checking = hyolService.removeAdminUser(checkBoxArr);
			System.out.println("1이면 성공 : "+checking);
			return "adminUserListTest";
		}
		// 탈퇴회원 조회 리스트
		@PostMapping("/rest/adminWithdrawUserListTest")
		public Map<String,Object> adminWithdrawUserList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
				 @RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage,
				 @RequestParam(value="searchWord", required = false)String searchWord,
				 @RequestParam(value="toDate", required = false)String toDate,
				 @RequestParam(value="fromDate", required = false)String fromDate) {
			System.out.println("::: post - /rest/adminWithdrawUserListTest :::");
			System.out.println("currentPage : "+currentPage);
			System.out.println("rowPerPage : "+rowPerPage);
			System.out.println("searchWord : "+searchWord);
			System.out.println("toDate : "+toDate);
			System.out.println("fromDate : "+fromDate);
			return hyolService.getAdminWithdrawUserList(currentPage, rowPerPage,searchWord, toDate, fromDate);
		}
	// 회원 복구(n->Y)
		@PostMapping("/rest/adminWithdrawUserRestoreTest")
		public String adminWithdrawUserModify(@RequestParam(value="checkBoxArr") List<String> checkBoxArr) {
			System.out.println("::: post - /rest/adminWithdrawUserRestoreTest :::");
			System.out.println(checkBoxArr);
			int checking = hyolService.modifyAdminWithdrawUser(checkBoxArr);
			System.out.println("1이면 성공 : "+checking);
			return "adminUserListTest";
		}
		// 전문가 유저 조회
		@PostMapping("/rest/adminExpertUserListTest")
		public Map<String,Object> adminExpertUserList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
				 @RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage,
				 @RequestParam(value="searchWord", required = false)String searchWord,
				 @RequestParam(value="toDate", required = false)String toDate,
				 @RequestParam(value="fromDate", required = false)String fromDate) {
			System.out.println("::: post - /rest/adminExpertUserListTest :::");
			System.out.println("currentPage : "+currentPage);
			System.out.println("rowPerPage : "+rowPerPage);
			System.out.println("searchWord : "+searchWord);
			System.out.println("toDate : "+toDate);
			System.out.println("fromDate : "+fromDate);
			return hyolService.getAdminExpertUserList(currentPage, rowPerPage,searchWord, toDate, fromDate);
		}
		// -------------------------------------------------------유저-----------------------------------------------
		// 유저 유저 조회
		@PostMapping("/rest/getUserListTest")
		public Map<String,Object> getUserList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
				@RequestParam(value="rowPerPage", defaultValue = "36")int rowPerPage,
				@RequestParam(value="searchWord", required = false)String searchWord) {
			System.out.println("::: post - /getUserListTest :::");
			System.out.println("currentPage : "+currentPage);
			System.out.println("rowPerPage : "+rowPerPage);
			System.out.println("searchWord : "+searchWord);
			return hyolService.getUserList(currentPage, rowPerPage,searchWord);
		}
		// serviceCategory 리스트 조회 및 강조
		@GetMapping("/rest/getServiceCategoryListTest")
		public List<ServiceCategory> getServiceCategoryList() {
			return hyolService.getServiceCategoryList();
		}
		// faq 리스트 조회
		@PostMapping("/rest/getFaqListTest")
		public Map<String,Object> getFaqList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
				@RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage,
				// mapper에서 page에 담기위해서 변수명을 변경한다
				@RequestParam(value="serviceCategoryId", required = false)String searchCategory){
			System.out.println("::: post - /getFaqListTest :::");
			System.out.println("currentPage : "+currentPage);
			System.out.println("rowPerPage : "+rowPerPage);
			System.out.println("searchCategory : "+searchCategory);
			return hyolService.getFaqList(currentPage, rowPerPage, searchCategory);
		}
		// faqone 출력 (이전글,다음글까지 출력)
		@PostMapping("/rsst/getFaqOneTest")
		public List<FaqBoard> getFaqOne(int faqId){
			System.out.println("::: post - /getFaqOneTest :::");
			System.out.println("faqId : "+faqId);
			return hyolService.getFaqOne(faqId);
		}
		// 문의내역 카테고리
		@GetMapping("/rest/getInquiryTest")
		public List<Inquiry> getInquiry(){
			return hyolService.getInquiryList();
		}
		// 문의내역 출력(자신이 올린 글만)
		@PostMapping("/rest/getInquiryBoardTest")
		public Map<String,Object> getInquiryBoard(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
				@RequestParam(value="rowPerPage", defaultValue = "5")int rowPerPage,
				// mapper에서 page에 담기위해서 변수명을 변경한다
				@RequestParam(value="inquiryId", required = false)String searchCategory,
				HttpSession session){
			System.out.println("::: post - /getInquiryBoardTest :::");
			System.out.println("currentPage : "+currentPage);
			System.out.println("rowPerPage : "+rowPerPage);
			System.out.println("searchCategory : "+searchCategory);
			System.out.println(session.getAttribute("loginUser"));
			
				// 세션에서 유저의 정보를 받아 온 후 유저아이디값을 넘겨준다
				User loginUser = new User();
				loginUser = (User) session.getAttribute("loginUser");
				String loginUserId = loginUser.getUserId();
				return hyolService.getInquiryHistoryBoard(currentPage, rowPerPage, loginUserId, searchCategory);
		}
}