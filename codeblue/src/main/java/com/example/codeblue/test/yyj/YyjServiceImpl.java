package com.example.codeblue.test.yyj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.vo.Hospital;
import com.example.codeblue.vo.Page;

@Service
@Transactional
public class YyjServiceImpl implements YyjService{
	@Autowired YyjMapper yyjMapper;
	
//	@Override 
//	public Map<String, Object> getHospitalListTest(int currentPage, int rowPerPage, String searchWord) {
//		System.out.println(":::HospitalServiceImpl - getHospitalList:::");
//		
//		int beginRow = (currentPage-1)*rowPerPage;
//		Page page = new Page();
//		page.setBeginRow(beginRow);
//		page.setRowPerPage(rowPerPage);
//		page.setSearchWord(searchWord);
//		
//		int totalRow = yyjMapper.hospitalCountTest();
//		int lastPage = 0;
//		
//		if(totalRow % rowPerPage ==0) {
//			lastPage = totalRow/rowPerPage;
//		}else {
//			lastPage = (totalRow/rowPerPage)+1;
//		}
//		
//		System.out.println("lastPage : "+lastPage);
//		
//		List<Hospital> list = new ArrayList<Hospital>();
//		list = yyjMapper.hospitalListTest(page);
//		System.out.println(list.toString());
//		
//		Map<String,Object> map = new  HashMap<String, Object>();
//		map.put("currentPage", currentPage);
//		map.put("rowPerPage", rowPerPage);
//		map.put("searchWord", searchWord);
//		map.put("totalRow", totalRow);
//		map.put("lastPage", lastPage);
//		map.put("list", list);
//		
//		return map;
//	}

}
