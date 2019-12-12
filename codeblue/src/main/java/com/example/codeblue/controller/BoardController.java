package com.example.codeblue.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.codeblue.service.BoardService;

@Controller
public class BoardController {
	@Autowired BoardService boardService;
	// 코드블루 소개 패이지
	@GetMapping("index")
	public String getIndex(HttpSession session) {
		return "/index";
	}
	
	@GetMapping("/")
	public String getHome(HttpSession session) {
		System.out.println("::: get - codeBlue home :::");
		System.out.println(session.getAttribute("loginUser"));
		if(session.getAttribute("loginUser") != null) {
			if(session.getAttribute("loginManager")!= null) {
				return "codeblue/admin/home";
			}
			return "/codeblue/today";
		}
		return "/index";
	}
}
