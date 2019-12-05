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
	
	@GetMapping("/")
	public String getHome(HttpSession session) {
		System.out.println("::: get - codeBlue home :::");
		if(session.getAttribute("user") == null) {
			return "/home";
		}
		return "/codeBlue/today";
	}
}
