package com.example.codeblue.test.jjw;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.codeblue.vo.Feild;
import com.example.codeblue.vo.Page;

@org.springframework.web.bind.annotation.RestController
public class JJWRestController {
	
	@Autowired
	private JJWService service;
	
	//체크박스로 선택한 questionId 배열 가져오기
	@PostMapping("/rest/removeQuestionBoardList")
	public String removeQuestionBoardList(@RequestParam(value="checkBoxArr")List<String> questionId) {
		System.out.println("::: post - removeQuestionBoardList :::");
		System.out.println(questionId.toString());
		return "success";
	}
	
	@PostMapping("/rest/getFeildListTest")
	public List<Feild> getFeildList() {
		System.out.println("::: post - FeildList :::");
		return service.getFeildList();
	}
	//검색 조건에 따른 리스트 가져오기
	@PostMapping("/rest/getQuestionBoardListTest")
	public Map<String,Object> questionBoardList(Page page,@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
												@RequestParam(value="rowPerPage", defaultValue = "10")int rowPerPage) {
		System.out.println("::: post - questionBoardList :::");
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : " +rowPerPage);
		page.setRowPerPage(rowPerPage);
		System.out.println(page.toString());
		return service.getQuestionBoardList(page,currentPage);
	}
}
