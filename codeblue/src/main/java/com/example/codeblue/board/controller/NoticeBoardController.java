package com.example.codeblue.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.codeblue.board.service.NoticeBoardService;

@Controller
public class NoticeBoardController {
	@Autowired NoticeBoardService noticeBoardService;
	
	@GetMapping("/notice")
	public String notice() {
		System.out.println("::: get - notice - controller :::"); 
		return "notice";
	}
	
}
