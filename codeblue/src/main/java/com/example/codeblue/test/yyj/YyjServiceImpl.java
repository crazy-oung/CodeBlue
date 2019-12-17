package com.example.codeblue.test.yyj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.Point;

@Service
@Transactional
public class YyjServiceImpl implements YyjService{
	@Autowired YyjMapper yyjMapper;

	@Override
	public Map<String, Object> getPointList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate) {
		System.out.println(":::AdminServiceImpl - getPointList:::");
		
		int beginRow = (currentPage-1)*rowPerPage;		
		Page page = new Page();
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setSearchWord(searchWord);
		page.setToDate(toDate);
		page.setFromDate(fromDate);		
		System.out.println("ServiceImpl PageVo toString" + page.toString());		
		
		int totalRow = yyjMapper.selectPointListTotalRow();
		int lastPage = 0;
		
		if(totalRow % rowPerPage != 0) {
			lastPage = (totalRow/rowPerPage)+1;
		}else {
			lastPage = totalRow/rowPerPage;
		}
				
		List<Point> list = yyjMapper.selectPointList(page);
		list = yyjMapper.selectPointList(page);
		System.out.println("ServiceImpl List toString" + list.toString());
		
		Map<String, Object> map = new HashMap<>();
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		map.put("totalRow", totalRow);
		map.put("lastPage", lastPage);
		map.put("list", list);
		map.put("toDate", toDate);
		map.put("fromDate", fromDate);
		
		return map;
	}
	
	@Override
	public Map<String, Object> getPointListTotal(int currentPage, int rowPerPage, String searchWord){
		System.out.println(":::AdminServiceImpl - getPointListTotal:::");
		
		System.out.println("rowPerPage : " + rowPerPage);
		
		int beginRow = (currentPage-1)*rowPerPage;
		
		System.out.println("beginRow : " + beginRow);
		
		Page page = new Page();
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setSearchWord(searchWord);
		
		System.out.println(page.toString());	
		
		int totalRow = yyjMapper.selectPointListSumTotalRow();
		
		System.out.println("totalRow : " + totalRow);
		int lastPage = 0;
		
		if(totalRow % rowPerPage != 0) {
			lastPage = (totalRow/rowPerPage)+1;
		}else {
			lastPage = totalRow/rowPerPage;
		}
		
		List<Map> list = yyjMapper.selectPointTotalList(page);
		System.out.println("getPointListTotal List toString" + list.toString());
		System.out.println(list.size()); 
		
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		map.put("totalRow", totalRow);
		map.put("lastPage", lastPage);
		map.put("list", list);
		
		return map;
	}
}
