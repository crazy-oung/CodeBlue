package com.example.codeblue.user.restcontroller;

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
		System.out.println("User.toString"+user.toString());
		
		String checkCode = userService.sendmail(user);
		session.setAttribute("checkCode", checkCode);
		return "success";
	}
	
	@PostMapping("/rest/checkCode")
	public String checkCode(User user, HttpSession session, @RequestParam(value="code")String code) {
		System.out.println(user.toString() + code);
		if(session.getAttribute("checkCode").equals(code)!= true) {
			System.out.println("ASdasdasdasdasdasas");
			return "redirect:/";
		}else {
			System.out.println("success CheckCode!");
			userService.addUser(user);
		}
		return "";
	}
}
