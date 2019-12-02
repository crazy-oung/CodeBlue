package com.example.codeblue.board.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.board.service.NoticeBoardService;

@RestController
public class NoticeBoardRestController {
	@Autowired NoticeBoardService noticeBoardService;
	
	@GetMapping("/rest/getNoticeList")
	public Map<String,Object> getnoticeList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
									 @RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage) {
		System.out.println("::: post - getnoticeList :::"); 
		System.out.println("currentPage : " + currentPage);
		System.out.println("rowPerPage : " + rowPerPage);
		
		Map<String,Object> map = noticeBoardService.getNoticeBoardList(currentPage, rowPerPage);
		System.out.println("리턴!");
		System.out.println(map.toString());
		return noticeBoardService.getNoticeBoardList(currentPage, rowPerPage);
		
	}
	@PostMapping("/rest/getNoticeList")
	public Map<String,Object> getNoticeList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
									 @RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage) {
		System.out.println("::: post - getnoticeList :::"); 
		System.out.println("currentPage : " + currentPage);
		System.out.println("rowPerPage : " + rowPerPage);
		
		Map<String,Object> map = noticeBoardService.getNoticeBoardList(currentPage, rowPerPage);
		System.out.println("리턴!");
		System.out.println(map.toString());
		return noticeBoardService.getNoticeBoardList(currentPage, rowPerPage);
}
}
