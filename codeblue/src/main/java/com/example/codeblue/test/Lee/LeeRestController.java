package com.example.codeblue.test.Lee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping("/rest/profileQuestionBoard")
	public List<QuestionBoard> postProfileQuestionBoard(@RequestParam(value="userId")String userId){
		System.out.println(":::post - postProfileQuestionBoard:::");
		System.out.println("userId"+userId);
		return leeService.getQuestionBoard(userId);
	}
	
	@PostMapping("/rest/profileQuestionComment")
	public List<QuestionComment> postProfileQuestionComment(@RequestParam(value="userId")String userId){
		System.out.println(":::post - postProfile:::");
		System.out.println("userId"+userId);
		return leeService.getQuestionComment(userId);
	}
	
	@PostMapping("/rest/QuestionCount")
	public int postQuestionCount(@RequestParam(value="userId")String userId){
		System.out.println(":::post - postQuestionCount:::");
		System.out.println("userId"+userId);
		return leeService.questionBoardCount(userId);
	}
	
	@PostMapping("/rest/questionChart")
	public int postQuestionChart(@RequestParam(value="userId")String userId) {
		System.out.println(":::post - postQuestionChart :::");
		System.out.println("userId"+userId);
		return leeService.getQuestionChart(userId);
	}
}
