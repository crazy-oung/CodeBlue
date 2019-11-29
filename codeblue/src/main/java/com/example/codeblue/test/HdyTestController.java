package com.example.codeblue.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HdyTestController {
	
	@GetMapping("admin")
	public String getAdmin() {
		return "/codeBlue/admin/home";
	}
}
