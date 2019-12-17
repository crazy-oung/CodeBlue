package com.example.codeblue.test.yyj;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class YyjController {
	@Autowired
	YyjService yyjService;
	
	@GetMapping("/adminPointList")
	public String getadminPointList(HttpSession session) {
		System.out.println("::: get - adminPointList :::");
		if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("user")) {
			System.out.println("user admin 페이지 접근 시도 차단");
			return "/home";
		}
		return "/codeblue/admin/adminPointList";
	}
	
}
