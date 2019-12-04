package com.example.codeblue.admin.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.admin.service.AdminUserService;
import com.example.codeblue.user.vo.User;

@RestController
public class AdminUserRestController {
	@Autowired private AdminUserService adminUserService;
	
	@PostMapping("/rest/adminuserList")
	public Map<String,Object> adminUserList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
			 @RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage,
			 @RequestParam(value="searchWord", required = false)String searchWord) {
		System.out.println("::: post - /rest/adminuserList :::");
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : "+rowPerPage);
		System.out.println("searchWord : "+searchWord);
		return adminUserService.getAdminUserList(currentPage, rowPerPage,searchWord);
	}
}
