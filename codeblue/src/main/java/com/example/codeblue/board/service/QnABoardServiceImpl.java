package com.example.codeblue.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.board.mapper.BoardMapper;
import com.example.codeblue.user.vo.Feild;

@Transactional
@Service
public class QnABoardServiceImpl implements QnABoardService{
	@Autowired BoardMapper boardMapper;	
	
	@Override
	public List<Feild> getFeildList() {
		System.out.println("::: QnABoardServiceImpl - getFeildList :::");
		return boardMapper.selectFeildList();
	}

}
