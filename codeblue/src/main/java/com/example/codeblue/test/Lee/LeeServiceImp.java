package com.example.codeblue.test.Lee;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionComment;
import com.example.codeblue.vo.User;


@Transactional
@Service
public class LeeServiceImp implements LeeService{
	@Autowired LeeMapper leeMapper;
	
	//해당 유저정보 
	@Override
	public User getUserOne(String userId) {
		System.out.println(":::UserServiceImp - getUserOne:::");
		
		return leeMapper.selectUserOne(userId);
	}
	//해당 유저 질문 리스트 가져오기
	@Override
	public List<QuestionBoard> getQuestionBoard(String userId) {
		System.out.println(":::UserServiceImp - getQuestionBoard:::");
		System.out.println("userId : "+userId);
		System.out.println(leeMapper.selectQuestionBoardList(userId));
		List<QuestionBoard> list = leeMapper.selectQuestionBoardList(userId);
		System.out.println(list.toString());
		System.out.println(userId);
		return leeMapper.selectQuestionBoardList(userId);
	}

	//해당 유저 답변 리스트 가져오기
	@Override
	public List<QuestionComment> getQuestionComment(String userId) {
		System.out.println(":::UserServiceImp - getQuestionComment:::");
		System.out.println("userId"+userId);
		System.out.println(leeMapper.selectQuestionCommentList(userId));
		return leeMapper.selectQuestionCommentList(userId);
	}	
}
