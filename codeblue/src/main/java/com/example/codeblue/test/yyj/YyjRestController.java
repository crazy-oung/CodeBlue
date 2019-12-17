package com.example.codeblue.test.yyj;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YyjRestController {
	@Autowired YyjService yyjService;	
	
	@PostMapping("/rest/adminPointList")
	public Map<String, Object> adminPointList(@RequestParam(value="currentPage", defaultValue="1")int currentPage,
											@RequestParam(value="rowPerPage", defaultValue="10")int rowPerPage,
											@RequestParam(value="searchWord", required = false)String searchWord,
											@RequestParam(value="toDate", required = false)String toDate,
											@RequestParam(value="fromDate", required = false)String fromDate){
		System.out.println(":::post - adminPointList:::");
		
		System.out.println("currentPage"+currentPage);
		System.out.println("rowPerPage"+rowPerPage);
		System.out.println("searchWord"+searchWord);
		System.out.println("toDate : "+toDate);
		System.out.println("fromDate : "+fromDate);
		
		return yyjService.getPointList(currentPage, rowPerPage, searchWord, toDate, fromDate);
	}
	
	@PostMapping("/rest/adminPointListSum")
	public Map<String, Object> adminPointListSum(@RequestParam(value="currentPage", defaultValue="1")int currentPage,
												@RequestParam(value="rowPerPage", defaultValue="10")int rowPerPage,
												@RequestParam(value="searchWord", required = false)String searchWord){
		System.out.println(":::post - adminPointList:::");
		
		System.out.println("currentPage"+currentPage);
		System.out.println("rowPerPage"+rowPerPage);
		System.out.println("searchWord"+searchWord);
		
		return yyjService.getPointListTotal(currentPage, rowPerPage, searchWord);
	}

}