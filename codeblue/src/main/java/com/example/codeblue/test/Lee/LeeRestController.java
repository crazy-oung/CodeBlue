package com.example.codeblue.test.Lee;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionComment;
import com.example.codeblue.vo.User;

@RestController
public class LeeRestController {
	@Autowired LeeService leeService;
	
	//프로필 정보 가져오기 
	@PostMapping("/rest/profile")
	public User postProfile(@RequestParam(value="userId")String userId){
		System.out.println(":::post - postProfile:::");
		System.out.println("userId"+userId);
		return leeService.getUserOne(userId);
	}

	//유저 질문 리스트
	@PostMapping("/rest/profileQuestionBoard")
	public List<QuestionBoard> postProfileQuestionBoard(@RequestParam(value="userId")String userId){
		System.out.println(":::post - postProfileQuestionBoard:::");
		System.out.println("userId"+userId);
		return leeService.getQuestionBoard(userId);
	}
	
	//유저 질문 리스트(페이징)
	@PostMapping("/rest/questionBoardPaging")
	public Map<String, Object> postQuestionBoardPaging(@RequestParam(value="userId")String userId,
														@RequestParam(value="currentPage", defaultValue="1")int currentPage,
														@RequestParam(value="rowPerPage", defaultValue="10")int rowPerPage){
		System.out.println(":::post - postQuestionBoardPaging");
		System.out.println("userId"+userId);
		System.out.println("currentPage"+currentPage);
		System.out.println("rowPerPage"+rowPerPage);
		return leeService.getQuestionBoardPaging(currentPage, rowPerPage, userId);
	}
	
	//유저 질문 수(해당유저)
	@PostMapping("/rest/QuestionCount")
	public int postQuestionCount(@RequestParam(value="userId")String userId){
		System.out.println(":::post - postQuestionCount:::");
		System.out.println("userId"+userId);
		return leeService.questionBoardCount(userId);
	}
	
	//유저 질문 수 차트
	@PostMapping("/rest/questionChart")
	public List<QuestionBoard> postQuestionChart(@RequestParam(value="userId")String userId) {
		System.out.println(":::post - postQuestionChart :::");
		System.out.println("userId"+userId);
		return leeService.getQuestionChart(userId);
	}
	
	//유저 댓글 리스트
	@PostMapping("/rest/profileQuestionComment")
	public List<QuestionComment> postProfileQuestionComment(@RequestParam(value="userId")String userId){
		System.out.println(":::post - postProfile:::");
		System.out.println("userId"+userId);
		return leeService.getQuestionComment(userId);
	}
	
	//유저 댓글 리스트(페이징)
	@PostMapping("/rest/questionCommentPaging")
	public Map<String, Object> postQuestionCommentPaging(@RequestParam(value="userId")String userId,
														@RequestParam(value="currentPage", defaultValue="1")int currentPage,
														@RequestParam(value="rowPerPage", defaultValue="10")int rowPerPage){
	System.out.println(":::post - postQuestionBoardPaging");
	System.out.println("userId"+userId);
	System.out.println("currentPage"+currentPage);
	System.out.println("rowPerPage"+rowPerPage);
	return leeService.getCommentBoardPaging(currentPage, rowPerPage, userId);
	}
	
	//유저 댓글 수(해당유저)
	@PostMapping("/rest/CommentCount")
	public int postCommentCount(@RequestParam(value="userId")String userId){
		System.out.println(":::post - postCommentCount:::");
		System.out.println("userId"+userId);
		return leeService.questionCommentCount(userId);
	}
	
	//유저 댓글 수 차트
	@PostMapping("/rest/commentChart")
	public List<QuestionComment> postCommentChart(@RequestParam(value="userId")String userId){
		System.out.println(":::post - postCommentChart:::");
		System.out.println("userId"+userId);
		return leeService.getCommentChart(userId);
	}
	
	//유저 답글 리스트
	@PostMapping("/rest/questionAnswer")
	public List<Answer> postQuestionAnswer(@RequestParam(value="userId")String userId){
		System.out.println(":::post - postQuestionAnswer:::");
		System.out.println("userId"+userId);
		return leeService.getQuestionAnswer(userId);
	}
	
	//유저 답글 리스트(페이징)
	@PostMapping("/rest/questionAnswerPaging")
	public Map<String, Object> postQuestionAnswerPaging(@RequestParam(value="userId")String userId,
														@RequestParam(value="currentPage", defaultValue="1")int currentPage,
														@RequestParam(value="rowPerPage", defaultValue="10")int rowPerPage){
		System.out.println(":::post - postQuestionAnswerPaging");
		System.out.println("userId"+userId);
		System.out.println("currentPage"+currentPage);
		System.out.println("rowPerPage"+rowPerPage);												
		return leeService.getAnswerPaging(currentPage, rowPerPage, userId);
	}
}
