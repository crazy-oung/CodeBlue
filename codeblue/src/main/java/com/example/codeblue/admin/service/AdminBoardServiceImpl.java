package com.example.codeblue.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.admin.mapper.AdminBoardMapper;
import com.example.codeblue.board.vo.Page;
import com.example.codeblue.board.vo.QuestionBoard;

@Service
@Transactional
public class AdminBoardServiceImpl implements AdminBoardService {
	@Autowired
	private AdminBoardMapper adminBoardMapper;
	
	@Override
	public List<String> getAdminFeildList() {
		System.out.println("::: AdminBoardServiceImpl - getAdminFeildList :::");
		return adminBoardMapper.selectAdminFeildList();
	}
	
	@Override
	public Map<String,Object> getAdminBoardList(Page page,int currentPage) {
		System.out.println("::: AdminBoardServiceImpl - getAdminBoardList :::");
		
		//시작값 정하기
		int beginRow = (currentPage -1) * page.getRowPerPage();
		page.setBeginRow(beginRow);
		System.out.println(page.toString());
		//질문 리스트 전체 행의 갯수
		int totalCount = adminBoardMapper.selectAdminBoardTotalCount(page);
		System.out.println("totalCount : "+totalCount);
		//페이지 마지막값변수선언
		int lastPage = 0;
		//페이지갯수값 저장
		if(totalCount%page.getRowPerPage() == 0) {
			lastPage = totalCount/page.getRowPerPage();
		} else {
			lastPage = (totalCount/page.getRowPerPage())+1;
		}
		System.out.println("lastPage : "+lastPage);
		// 질문 리스트 저장
		List<QuestionBoard> list = adminBoardMapper.selectAdminBoardList(page);
		System.out.println(list.toString());
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("lastPage", lastPage);
		map.put("currentPage",currentPage);
		map.put("list",list);
		map.put("totalCount",totalCount);
		map.put("searchWord",page.getSearchWord());
		return map;
	}
}
