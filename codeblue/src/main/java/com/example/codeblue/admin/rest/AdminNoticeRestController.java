package com.example.codeblue.admin.rest;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.admin.service.AdminNoticeService;
import com.example.codeblue.admin.vo.Notice;

@RestController
public class AdminNoticeRestController {
	@Autowired AdminNoticeService adminNoticeService;
	
	@PostMapping("/rest/adminNoticeBoard")
	public Map<String, Object> postNotice(@RequestParam(value="currentPage",defaultValue = "1")int currentPage,
							@RequestParam(value="rowPerPage",defaultValue = "10")int rowPerPage,
							@RequestParam(value="searchWord", required = false)String searchWord) {
		
		System.out.println(":::post - postNotice:::");
		System.out.println("currentPage"+currentPage);
		System.out.println("rowPerPage"+rowPerPage);
		System.out.println("searchWord"+searchWord);

		return adminNoticeService.getNoticeBoard(currentPage, rowPerPage, searchWord);
	}
	
	@PostMapping("/rest/adminNoticeBoardOne")
	public Notice postNoticeOne(@RequestParam(value="noticeId") int noticeId) {
		System.out.println(":::post - postNoticeOne:::");
		System.out.println("noticeId"+noticeId);
		return adminNoticeService.getNoticeOne(noticeId);
	}
	
	@PostMapping("/rest/adminNoticeAdd")
	public int postNoticeAdd(Notice notice) {
		System.out.println(":::post - postNoticeAdd");
		System.out.println("Notice"+notice);
		return adminNoticeService.addNotice(notice);
	}
}
