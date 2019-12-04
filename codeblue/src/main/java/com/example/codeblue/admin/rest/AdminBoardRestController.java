package com.example.codeblue.admin.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.admin.service.AdminBoardService;
import com.example.codeblue.board.vo.Page;


@RestController
public class AdminBoardRestController {

	@Autowired
	private AdminBoardService adminBoardService;
	
	@PostMapping("/rest/adminFeildList")
	public List<String> adminFeildList() {
		System.out.println("::: post - adminFeildList :::");
		return adminBoardService.getAdminFeildList();
	}
	
	//검색 조건 vo 가져오기
	@PostMapping("/rest/adminBoardList")
	public Map<String,Object> adminBoardList(Page page,@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
												@RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage) {
		System.out.println("::: post - adminBoardList :::");
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : " +rowPerPage);
		page.setRowPerPage(rowPerPage);
		System.out.println(page.toString());
		return adminBoardService.getAdminBoardList(page,currentPage);
	}
}
