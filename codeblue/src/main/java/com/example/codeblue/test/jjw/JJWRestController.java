package com.example.codeblue.test.jjw;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.Feild;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;


@org.springframework.web.bind.annotation.RestController
public class JJWRestController {
	
	@Autowired
	private JJWService service;
	
//	//답변 상세정보
//	@PostMapping("/rest/getAnswerOne")
//	public Answer getAnswerOne(@RequestParam(value="answerId")String answerId) {
//		System.out.println("::: post - getAnswerOne :::");
//		System.out.println("answerId : "+answerId);
//		return service.getAnswerOne(answerId);
//	}
//	//답변 삭제 하기
//	@PostMapping("/rest/removeAnswerList")
//	public String removeAnswerList(@RequestParam(value="checkBoxArr")List<String> answerIdList) {
//		System.out.println("::: post - removeAnswerList :::");
//		System.out.println(answerIdList.toString());
//		service.removeAnswerList(answerIdList);
//		return "답변 삭제 성공";
//	}
//	//답변 리스트 가져오기
//	@PostMapping("/rest/getAnswerList")
//	public Map<String,Object> getAnswerList(Page page,@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
//												@RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage) {
//		System.out.println("::: post - getAnswerList :::");
//		System.out.println(page.toString());
//		System.out.println("currentPage : "+currentPage);
//		System.out.println("rowPerPage : "+rowPerPage);
//		page.setRowPerPage(rowPerPage);
//		return service.getAnswerList(page, currentPage);
//	}
//	
//	@PostMapping("/rest/getWithdrawQuestionBoardOne")
//	public QuestionBoard getWithdrawQuestionBoardOne(@RequestParam(value="questionId")String questionId) {
//		System.out.println("::: post - getWithdrawQuestionBoardOne :::");
//		System.out.println("questionId "+questionId);
//		return service.getWithdrawQuestionBoardOne(questionId);
//	}
//	
//	@PostMapping("/rest/getQuestionBoardOne")
//	public QuestionBoard getQuestionBoardOne(@RequestParam(value="questionId")String questionId) {
//		System.out.println("::: post - getQuestionBoardOne :::");
//		System.out.println("questionId "+questionId);
//		return service.getQuestionBoardOne(questionId);
//	}
//	//검색 조건에 따른 삭제된 게시글 가져오기
//	@PostMapping("/rest/getWithdrawQuestionBoardList")
//	public Map<String,Object> getWithdrawQuestionBoardList(Page page,@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
//												@RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage) {
//		System.out.println("::: post - questionBoardList :::");
//		System.out.println("currentPage : "+currentPage);
//		System.out.println("rowPerPage : " +rowPerPage);
//		page.setRowPerPage(rowPerPage);
//		System.out.println(page.toString());
//		return service.getWithdrawQuestionBoardList(page,currentPage);
//	}
//	
//	//체크박스로 선택한 questionId 배열 가져오기
//	@PostMapping("/rest/removeQuestionBoardList")
//	public String removeQuestionBoardList(@RequestParam(value="checkBoxArr")List<String> questionBoardIdList) {
//		System.out.println("::: post - removeQuestionBoardList :::");
//		System.out.println(questionBoardIdList.toString());
//		service.removeQeustionBoardList(questionBoardIdList);
//		return "삭제성공";
//	}
//	
//	@PostMapping("/rest/getFeildListTest")
//	public List<Feild> getFeildList() {
//		System.out.println("::: post - FeildList :::");
//		return service.getFeildList();
//	}
	//검색 조건에 따른 리스트 가져오기
//	@PostMapping("/rest/getQuestionBoardListTest")
//	public Map<String,Object> questionBoardList(Page page,@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
//												@RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage) {
//		System.out.println("::: post - questionBoardList :::");
//		System.out.println("currentPage : "+currentPage);
//		System.out.println("rowPerPage : " +rowPerPage);
//		page.setRowPerPage(rowPerPage);
//		System.out.println(page.toString());
//		return service.getQuestionBoardList(page,currentPage);
//	}
}
