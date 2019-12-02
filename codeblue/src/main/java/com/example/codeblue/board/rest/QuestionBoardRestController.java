package com.example.codeblue.board.rest;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.board.service.QuestionBoardService;


@RestController
public class QuestionBoardRestController {
	@Autowired
	private QuestionBoardService questionBoardSerivce;
	
	//질문 리스트 가져오기
	@PostMapping("/rest/getBoardList")
	public Map<String,Object> getBoardList(@RequestParam(value="currentPage",defaultValue = "1")int currentPage,
											@RequestParam(value="rowPerPage",defaultValue = "10")int rowPerPage,
											@RequestParam(value="searchWord", required = false)String searchWord) {
		System.out.println("::: post - getBoardList :::");
		System.out.println("currentPage : "+ currentPage);
		System.out.println("rowPerPage : "+ rowPerPage);
		System.out.println("searchWord : "+ searchWord);
		return questionBoardSerivce.getQuestBoardList(currentPage, rowPerPage,searchWord);
	}
}
