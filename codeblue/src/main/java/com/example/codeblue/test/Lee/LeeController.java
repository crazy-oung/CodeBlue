package com.example.codeblue.test.Lee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LeeController {

	@GetMapping("/profile")
	public String getProfile(@RequestParam(value="userId") int userId) {
		System.out.println(":::get - getProfile:::");
		System.out.println("userId"+userId);
		return "/UserOne";
	}
	
}
