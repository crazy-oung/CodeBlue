package com.example.codeblue.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
	@Autowired ProfileService profileService;
	
	@GetMapping("/userOne")
	public String getUserOne() {
		System.out.println("::: get - getUserOne :::");
		return "userOne";
	}
}
