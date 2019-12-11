package com.example.codeblue.test.Lee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LeeController {

	//사용하지않음 
	@GetMapping("/kakao")
	public String getProfile() {
		System.out.println(":::get - getProfile:::");
		return "/codeBlue/kakaoLogin";
	}
	
	@GetMapping("/userOneActive")
	public String getUserOneProfile() {
		System.out.println(":::get - getUserOneProfile:::");
		return "userOneActive";
	}
	
}
