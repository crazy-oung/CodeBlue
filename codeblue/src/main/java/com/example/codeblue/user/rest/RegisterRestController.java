package com.example.codeblue.user.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.user.service.UserService;
import com.example.codeblue.user.vo.Expert;
import com.example.codeblue.user.vo.Feild;
import com.example.codeblue.user.vo.Region;
import com.example.codeblue.user.vo.User;

@RestController
public class RegisterRestController {
	@Autowired UserService userService;
	

	@PostMapping("/rest/resetPassword")
	public int postAccountRecovery(User user) {
		System.out.println("::: post - resetPassword :::");
		System.out.println("User"+ user);
		
		return userService.modifyUserPw(user);
	}
	
	
	@PostMapping("/rest/verifyUserForReset")
	public String verifyUserForReset(HttpSession session,User user) { 
		System.out.println("::: post - verifyUserForReset :::");
		System.out.println(user.toString());
		
		String result = userService.getUserIdForCheck(user); 
		if(result == null) {
			System.out.println("noSuchUser!! ");
			return "noSuchUser";
		}
		
		session.setAttribute("verifyCode", result);
		return "success";
	}
	
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
	public boolean verifyCode(User user, HttpSession session, String code) {
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
	// verify code & add User
	@PostMapping("/rest/verifyCodeForRest")
	public boolean verifyCodeForRest(HttpSession session, String code) {
		System.out.println("::: post - verifyCodeForRest :::");
		
		if(session.getAttribute("verifyCode").equals(code) != true) {
			System.out.println("!password not correct");
			System.out.println("code : "+code+", verifyCode: "+session.getAttribute("verifyCode"));
			return false;
		}
		
		System.out.println("code correct!");	
		return true;
	}
	
	@PostMapping("/rest/addExpert")
	public boolean addExpert(Expert expert) {
		System.out.println("::: post - addExpert :::");    
		System.out.println("영향을 받은행: "+userService.addExpert(expert)); 
		return true;
	}
	
	@GetMapping("/rest/getRegionList")
	public List<Region> getRegionList(){
		System.out.println("::: get - getRegionList :::");
		
		return userService.getRegionList();
	}
	
	@GetMapping("/rest/getFeildList")
	public List<Feild> getFeildList(){
		System.out.println("::: get - getRegionList :::");
		
		return userService.getFeildList();
	}
}
