package com.example.codeblue.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.admin.mapper.AdminNoticeMapper;
import com.example.codeblue.admin.vo.Notice;
import com.example.codeblue.board.mapper.NoticeBoardMapper;
import com.example.codeblue.board.vo.Page;
@Transactional
@Service
public class AdminNoticeServiceImpl implements AdminNoticeService {
	@Autowired AdminNoticeMapper adminNoticeMapper;
	
	@Override
	public Map<String, Object> getNoticeBoard(int currentPage, int rowPerPage, String searchWord) {
		System.out.println(":::AdminNoticeServiceImpl - getNoticeBoard:::");
		System.out.println("currentPage :"+currentPage+"/rowPerPage :"+rowPerPage);
		
		int beginRow = (currentPage-1)*rowPerPage;
		Page page = new Page();
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setSearchWord(searchWord);
		
		int totalRow = adminNoticeMapper.noticeBoardCount(page);
		int lastPage = 0;
		
		if(totalRow % rowPerPage ==1) {
			lastPage = (totalRow/rowPerPage)+1;
		}else {
			lastPage = totalRow/rowPerPage;
		}
		System.out.println("lastPage:"+ lastPage );
		
		List<Notice> list = adminNoticeMapper.selectNoticeBoard(page);
		System.out.println(list.toString());
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		map.put("totalRow", totalRow);
		map.put("lastPage", lastPage);
		map.put("list", list);
		
				
		return map;
	}

	@Override
	public Notice getNoticeOne(int noticeId) {
		System.out.println(":::AdminNoticeServiceImpl - getNoticeOne");
		System.out.println("noticeId"+noticeId);
		
		return adminNoticeMapper.noticeBoardOne(noticeId);
	}

	@Override
	public int addNotice(Notice notice) {
		System.out.println(":::AdminNoticeServiceImpl - addNotice");
		System.out.println("Notice"+ notice);
		return adminNoticeMapper.insertNoticeBoard(notice);
	}

}
