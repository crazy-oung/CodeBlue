package com.example.codeblue.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.codeblue.user.service.UserService;
import com.example.codeblue.user.vo.User;


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
	
	@PostMapping("/login")
	public String postLogin(HttpSession session, User user) {
		System.out.println("::: post - login :::");
		System.out.println(user);
		System.out.println(session.getAttribute("loginUser"));
		
		// 세션 검사
		User loginUser = userService.loginUser(user);
		
		if(loginUser != null) {
			session.setAttribute("loginUser", loginUser); 
			return "/codeBlue/today";
		}  
		return "redirect:/";
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
