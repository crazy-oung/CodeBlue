package com.example.codeblue.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String getHome(HttpSession session) {
		System.out.println("::: get - codeBlue home :::");
		if(session.getAttribute("user") == null) {
			return "/codeBlue/home";
		}
		
		return "/home";
	}
	
	@GetMapping("/login")
	public String getLogin(HttpSession session) {
		System.out.println("::: get - login :::");
		if(session.getAttribute("user") != null) {
			return "/codeBlue/home";
		}
		
		return "login";
	}
	@GetMapping("/register")
	public String getRegister(HttpSession session) {
		System.out.println("::: get - register :::");
		if(session.getAttribute("user") != null) {
			return "/codeBlue/home";
		}
		
		return "register";
	}
	
}
