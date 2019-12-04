package com.example.codeblue.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminUserController {

	@GetMapping("/admin/userList")
	public String adminUserList() {
		System.out.println("::: get - adminUserList :::");
		return "/codeBlue/admin/userList";
	}
}
