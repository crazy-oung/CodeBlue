package com.example.codeblue.test.yyj;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YyjRestController {
//	@Autowired YyjService yyjService;	
//
//	//병원 리스트
//	@PostMapping("/rest/hospitalTest")
//	public Map<String, Object>postHospital(@RequestParam(value="currentPage", defaultValue="1")int currentPage,
//										@RequestParam(value="rowPerPage", defaultValue="10")int rowPerPage,
//										   @RequestParam(value="searchWord", required = false)String searchWord) {
//	System.out.println(":::post - postHospital:::");
//	System.out.println("currentPage"+currentPage + " //rowPerPage"+rowPerPage + " //searchWord"+searchWord);
//	
//	return yyjService.getHospitalListTest(currentPage, rowPerPage, searchWord);
//	}
}