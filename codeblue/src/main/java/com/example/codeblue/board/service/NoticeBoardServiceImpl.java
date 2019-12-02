package com.example.codeblue.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.board.mapper.NoticeBoardMapper;
import com.example.codeblue.board.vo.NoticeBoard;
import com.example.codeblue.board.vo.Page;

@Service
@Transactional
public class NoticeBoardServiceImpl implements NoticeBoardService{
	@Autowired NoticeBoardMapper noticeBoardMapper;
	
	@Override
	public Map<String, Object> getNoticeBoardList(int currentPage, int rowPerPage) {
		
		List<NoticeBoard> list = new ArrayList<>();
		System.out.println("::: NoticeBoardServiceImpl - getNoticeBoardList :::");
		System.out.println("currentPage : " + currentPage);
		System.out.println("rowPerPage :  " + rowPerPage);
		
		
		Page page = new Page();
		page.setRowPerPage(rowPerPage);
		page.setBeginRow((currentPage-1)*rowPerPage);
		
		int totalRow = noticeBoardMapper.noticeBoardTotalRow();
		int lastPage = totalRow/rowPerPage;
		
		if(totalRow % rowPerPage != 0) {
			lastPage ++;
		}
		
		list = noticeBoardMapper.selectNoticeBoardList(page);
		System.out.println(list);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalRow", totalRow);
		map.put("list", list);
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("lastPage", lastPage);
			
		System.out.println(map.toString());
		System.out.println("-------------------");
		return map;
	}
	
}
