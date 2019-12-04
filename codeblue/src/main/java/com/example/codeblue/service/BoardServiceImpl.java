package com.example.codeblue.service;

import java.util.List;

import javax.swing.plaf.synth.Region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.mapper.BoardMapper;
import com.example.codeblue.vo.Feild;

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
