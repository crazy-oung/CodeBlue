package com.example.codeblue.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.admin.mapper.AdminFaqBoardMapper;
import com.example.codeblue.admin.vo.FaqBoard;

@Service
@Transactional
public class AdminFaqBoardServiceImpl implements AdminFaqBoardService {
	@Autowired AdminFaqBoardMapper adminFaqBoardMapper;
	// 문의사항 답변
	@Override
	public int addFaqBoard(FaqBoard faqBoard) {
		System.out.println("::: AdminFaqBoardServiceImpl - addFaqBoard :::");
		faqBoard.toString();
		return adminFaqBoardMapper.insertFaqBoard(faqBoard);
	}	
	
}