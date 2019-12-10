package com.example.codeblue.test.yyj;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.codeblue.vo.Manager;

@RestController
public class YyjRestController {
	@Autowired YyjService yyjService;	
	
//	//인증메일 전송
//	@PostMapping("/rest/adminSendEmailToConfirm")
//	public String adminSendEmailToConfirm(HttpSession session, Manager manager) {
//		System.out.println("::: post - adminSendEmailToConfirm :::");
//		
//		System.out.println(manager.toString());		
//		String code = yyjService.sendCodeToMail(manager);
//		session.setAttribute("verifyCode", code);
//		
//		return "success";
//	}
//	
//	// 인증메일 확인
//	@PostMapping("/rest/adminVerifyCode")
//	public boolean adminVerifyCode(Manager manager, HttpSession session, String code) {
//		System.out.println("::: post - adminVerifyCode :::");
//		System.out.println(manager.toString() + "입력받은 코드:" +code);
//		System.out.println("verifyCode : " + session.getAttribute("veriftCode"));
//		
//		if(session.getAttribute("verifyCode").equals(code) != true) {
//			
//			System.out.println("!password not correct");
//			return false;
//		}
//		
//		System.out.println("code correct!");
//		yyjService.addAdministrator(manager);
//		
//		return true;
//	}
//	
//	//재전송
//	@PostMapping("/rest/adminVerifyCodeForRest")
//	public boolean adminVerifyCodeForRest(HttpSession session, String code) {
//		System.out.println("::: post - adminVerifyCodeForRest :::");
//		
//		if(session.getAttribute("verifyCode").equals(code) != true) {
//			System.out.println("!password not correct");
//			System.out.println("code : "+code+", verifyCode: "+session.getAttribute("verifyCode"));
//			return false;
//		}
//		
//		System.out.println("code correct!");	
//		return true;
//	}
}