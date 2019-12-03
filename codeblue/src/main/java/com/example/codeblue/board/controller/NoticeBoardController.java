package com.example.codeblue.board.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import com.example.codeblue.board.service.NoticeBoardService;


@Controller
public class NoticeBoardController {
	@Autowired NoticeBoardService noticeBoardService;
	
	@GetMapping("/notice")
	public String notice() {
		System.out.println("::: get - notice :::"); 
		return "notice";
	}
	@GetMapping("/noticeOne")
	public String noticeOne() {
		System.out.println("::: get - noticeOne :::"); 
		return "noticeOne";
	}
}