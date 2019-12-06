package com.example.codeblue.test.hyol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HyolController {
	
	@GetMapping("/adminUserListTest")
	public String adminUserListTest() {
		System.out.println("::: get - adminUserListTest :::");
		return "/codeBlue/admin/adminUserListTest";
	}
	
}
