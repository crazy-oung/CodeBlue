package com.example.codeblue.board.rest;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.board.service.QuestionBoardService;
import com.example.codeblue.board.vo.QuestionBoard;
import com.example.codeblue.board.vo.QuestionComment;


@RestController
public class QuestionBoardRestController {
	@Autowired
	private QuestionBoardService questionBoardSerivce;
	
	// 댓글 입력하기
	// 댓글 전체리스트 가져오기
	@PostMapping("/rest/getQuestionCommentList")
	public List<QuestionComment> getCommentList(int questionId){
		System.out.println("::: post - getQuestionCommentList :::");
		System.out.println("questionId : "+questionId);
		return questionBoardSerivce.getQuestionCommentList(questionId);
		
	}
	
	
	// 질문 리스트 가져오기
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
	@PostMapping("/rest/questionBoardOne")
	public QuestionBoard QuestionBoardOne(@RequestParam(value="questionId" , required=true)int questionId) {
		System.out.println("::: post - QuestionBoardOne :::");
		System.out.println("questionId : "+questionId);
		QuestionBoard questionBoard = questionBoardSerivce.getQuestionBoardOne(questionId);
		
		System.out.println(questionBoard.toString());
		
		return questionBoard;
	}
}
