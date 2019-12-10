package com.example.codeblue.test.Lee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionComment;
import com.example.codeblue.vo.User;


@Transactional
@Service
public class LeeServiceImp implements LeeService{
	@Autowired LeeMapper leeMapper;
	
	@Override
	public User getUserOne(String userId) {
		System.out.println(":::UserServiceImp - getUserOne:::");
		
		return leeMapper.selectUserOne(userId);
	}

	@Override
	public List<QuestionBoard> getQuestionBoard(String userId) {
		System.out.println(":::UserServiceImp - getQuestionBoard:::");
		System.out.println("userId"+userId);
		System.out.println(leeMapper.selectQuestionBoardList(userId));
		List<QuestionBoard> list = leeMapper.selectQuestionBoardList(userId);
		System.out.println(list.toString());
		System.out.println(userId);
		return leeMapper.selectQuestionBoardList(userId);
	}

	@Override
	public List<QuestionComment> getQuestionComment(String userId) {
		System.out.println(":::UserServiceImp - getQuestionComment:::");
		System.out.println("userId"+userId);
		System.out.println(leeMapper.selectQuestionCommentList(userId));
		return leeMapper.selectQuestionCommentList(userId);
	}	
}
