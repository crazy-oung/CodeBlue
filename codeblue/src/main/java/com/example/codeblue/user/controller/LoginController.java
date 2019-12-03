package com.example.codeblue.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.codeblue.user.service.UserService;
import com.example.codeblue.user.vo.Manager;
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
			return "/codeBlue/today";
		} 
		return "login";
	} 
	@PostMapping("/login")
	public String postLogin(HttpSession session, User user) {
		System.out.println("::: post - login :::"); 
		System.out.println(user); 
		
		// 세션 검사
		if(session.getAttribute("loginUser") != null) {
			System.out.println("already loged in Back to user Home"); 
			return "/codeBlue/today";
		}  
		
		// 매니저 검사
		Manager loginManager = userService.verifyManager(user);
		if(loginManager != null) {
			System.out.println("manager Login"); 
			session.setAttribute("loginManager", loginManager);
			return "/codeblue/admin/home";
		}
		// 유저 검사
		User loginUser = userService.verifyUser(user);
		if(loginUser != null) {
			System.out.println("user Login"); 
			session.setAttribute("loginUser", loginUser);
			return "/codeBlue/today";
		}
		
		return "/login";
	}
	
	@GetMapping("/register")
	public String getRegister(HttpSession session) {
		System.out.println("::: get - register :::");
		if(session.getAttribute("user") != null) {
			return "/codeBlue/today";
		} 
		return "register";
	}
	
	@GetMapping("/registerExpert")
	public String getRegisterExpert(HttpSession session) {
		System.out.println("::: get - register :::");
		if(session.getAttribute("user") != null) {
			return "/codeBlue/today";
		} 
		return "registerExpert";
	}
}
