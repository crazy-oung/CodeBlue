package com.example.codeblue.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminBoardController {

	
	@GetMapping("/adminBoard")
	public String getAdminBoard() {
		System.out.println("::: get - getAdminBoard :::");
		return "/codeBlue/admin/board";
	}
}
