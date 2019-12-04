package com.example.codeblue.admin.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.admin.service.AdminFaqBoardService;
import com.example.codeblue.admin.vo.FaqBoard;

@RestController
public class AdminFaqBoardRestController {
	@Autowired AdminFaqBoardService adminFaqBoardService;
	
	@PostMapping("/rest/admin/addFaqBoard")
	public int addFaqBoard(FaqBoard faqBoard) {
		System.out.println("::: post - addFaqBoard :::");
		
		
		return adminFaqBoardService.addFaqBoard(faqBoard);
	}
}