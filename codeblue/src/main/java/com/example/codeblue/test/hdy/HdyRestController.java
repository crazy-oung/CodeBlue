package com.example.codeblue.test.hdy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.vo.Page;

@RestController
public class HdyRestController {
	
	@Autowired HdyService hdyService;
	
	@GetMapping("/rest/getTagList")
	public	Map<String, Object> getTagList(Page page, int currentPage){
		System.out.println("::: get - getTagList :::");
		System.out.println(page);
		Map<String, Object> map = new HashMap<>();
		page.setBeginRow( (currentPage -1)*page.getBeginRow() );
		
		List<Map> list = hdyService.getTagList(page);
		System.out.println(list);

		map.put("list", list);
		int totalRow = hdyService.getTagTotalRow();
		int lastPage = totalRow/page.getRowPerPage();
		if(totalRow%page.getRowPerPage() != 0) {
			lastPage ++;
		}
		map.put("lastPage", lastPage);
		map.put("currentPage", currentPage);
		
		return map;
	}
	
}
