package com.example.codeblue.user.rest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.user.service.UserService;
import com.example.codeblue.user.vo.User;

@RestController
public class RegisterRestController {
	@Autowired UserService userService;
	
	@PostMapping("/rest/sendEmailToConfirm")
	public String sendEmailToConfirm(HttpSession session, User user) {
		System.out.println("::: post - checkCode :::");
		
		System.out.println(user.toString());		
		String code = userService.sendCodeToMail(user);
		session.setAttribute("verifyCode", code);
		
		return "success";
	}
	
	// verify code & add User
	@PostMapping("/rest/verifyCode")
	public boolean verifyCode(User user, HttpSession session, @RequestParam(value="code")String code) {
		System.out.println("::: post - verifyCode :::");
		System.out.println(user.toString() + "입력받은 코드:" +code);
		
		if(session.getAttribute("verifyCode").equals(code) != true) {
			System.out.println("!password not correct");
			return false;
		}
		
		System.out.println("code correct!");
		userService.addUser(user); 
		
		return true;
	}
}
