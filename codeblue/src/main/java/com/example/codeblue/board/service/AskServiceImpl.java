package com.example.codeblue.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.board.mapper.AskMapper;
import com.example.codeblue.board.vo.QuestionBoard;

@Transactional
@Service
public class AskServiceImpl implements AskService{
	@Autowired AskMapper askMapper;
	@Override
	public int addQuestion(QuestionBoard questionBoard) {
		System.out.println("::: AskServiceImpl - addQuestion :::");
		return askMapper.insertQuestion(questionBoard);
	}
	
}
