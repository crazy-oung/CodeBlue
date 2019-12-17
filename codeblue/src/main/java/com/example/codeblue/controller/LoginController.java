package com.example.codeblue.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.codeblue.service.AdminService;
import com.example.codeblue.service.UserService;
import com.example.codeblue.vo.Manager;
import com.example.codeblue.vo.User;


@Controller
public class LoginController {
	@Autowired UserService userService;
	@Autowired AdminService adminService;
	
	@GetMapping("/accountRecovery")
	public String getResetPasswrod() { 
		System.out.println("::: get - accountRecovery :::"); 
		return "/accountRecovery";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("::: get - logout :::"); 
		session.invalidate();
		return "/home";
	} 
	
	@GetMapping("/login")
	public String getLogin(HttpSession session) {
		System.out.println("::: get - login :::");
		if(session.getAttribute("user") != null) {
			return "/home";
		} 
		return "login";
	} 
	// 세션 추가
	@PostMapping("/login")
	public String postLogin(HttpSession session, User user) {
		System.out.println("::: post - login :::"); 
		System.out.println(user); 
		
		// 세션 검사
		if(session.getAttribute("loginUser") != null) {
			System.out.println("already loged in Back to user Home");
			return "/home";
		}  
		
		// 매니저 검사
		Manager loginManager = adminService.verifyManager(user);
		if(loginManager != null) {
			System.out.println("manager Login-->"); 
			session.setAttribute("loginManager", loginManager);
			session.setAttribute("authority", "manager");
			return "/codeblue/admin/home";
		}
		
		// 유저 검사
		User loginUser = userService.verifyUser(user);
		if(loginUser != null) {
			System.out.println("user Login"); 
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("authority", "user");
			
			return "/home";
		}
		System.out.println("계정 정보 불일치");
		return "/login";
	}
	
	@GetMapping("/register")
	public String getRegister(HttpSession session) {
		System.out.println("::: get - register :::");
		if(session.getAttribute("user") != null) {
			return "/codeblue/today";
		} 
		return "register";
	}
	
	@GetMapping("/registerExpert")
	public String getRegisterExpert(HttpSession session) {
		System.out.println("::: get - register :::");
		if(session.getAttribute("user") != null) {
			return "/codeblue/today";
		} 
		return "registerExpert";
	}

}
