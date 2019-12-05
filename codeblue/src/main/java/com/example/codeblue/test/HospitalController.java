package com.example.codeblue.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HospitalController {
	@GetMapping("/adminHospital")
	public String getHospital() {
		System.out.println(":::get - getHospital:::");
		return"/codeBlue/admin/adminHospitalBoard";
	}
}
