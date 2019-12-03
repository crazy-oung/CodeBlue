package com.example.codeblue.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.board.mapper.BoardMapper;
import com.example.codeblue.user.vo.Feild;
import com.example.codeblue.user.vo.Region;

@Transactional
@Service
public class BoardServiceImpl implements BoardService{
	@Autowired BoardMapper boardMapper;
	
	//지역 리스트 출력
	@Override
	public List<Region> getRegionList() {
		System.out.println("::: BoardServiceImpl - getRegionList :::");
		return boardMapper.selectRegionList();
	}

	@Override
	public List<Feild> getFeildList() {
		System.out.println("::: BoardServiceImpl - getFeildList :::");
		return boardMapper.selectFeildList();
	}
}
