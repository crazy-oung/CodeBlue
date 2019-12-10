package com.example.codeblue.test.hyol;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.service.AdminService;
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
}
