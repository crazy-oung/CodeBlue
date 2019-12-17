package com.example.codeblue.test.yyj;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.codeblue.vo.User;

@Controller
public class YyjController {
	@Autowired
	YyjService yyjService;

	/*
	 * @GetMapping("/profileModify") public String modifyUserProfile(HttpSession
	 * session, User user) { 세션 검사 if(session.getAttribute("loginUser") != null) {
	 * System.out.println("already loged in Back to user Home");
	 * System.out.println("Get modifyUserProfile:::"); return "/home"; } return
	 * "/home"; }
	 */
}
