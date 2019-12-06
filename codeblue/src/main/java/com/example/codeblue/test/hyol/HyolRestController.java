package com.example.codeblue.test.hyol;

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
}
