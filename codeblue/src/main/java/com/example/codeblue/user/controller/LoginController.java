package com.example.codeblue.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import com.example.codeblue.user.service.UserService;


@Controller
public class LoginController {
	@Autowired UserService userService;
	
	@GetMapping("/")
	public String getHome(HttpSession session) {
		System.out.println("::: get - codeBlue home :::");
		if(session.getAttribute("user") == null) {
			return "/home";
		}
		
		return "/codeBlue/today";
	}
	
	@GetMapping("/login")
	public String getLogin(HttpSession session) {
		System.out.println("::: get - login :::");
		if(session.getAttribute("user") != null) {
			return "/codeBlue/today";
		} 
		return "login";
	}
	@GetMapping("/register")
	public String getRegister(HttpSession session) {
		System.out.println("::: get - register :::");
		if(session.getAttribute("user") != null) {
			return "/codeBlue/today";
		} 
		return "register";
	}
}
