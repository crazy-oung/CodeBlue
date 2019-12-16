package com.example.codeblue.test.ljh;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.vo.Inquiry;



@RestController
public class LjhRestController {
	@Autowired LjhService ljhService;
	// 문의 내역 리스트 가져오기
	@PostMapping("/rest/admin/getInquiryHistoryListTest")
	public Map<String,Object> getInquiryHistoryList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
									 @RequestParam(value="rowPerPage", defaultValue = "15")int rowPerPage,
									 @RequestParam(value="searchWord", required = false)String searchWord,
										@RequestParam(value="toDate", required = false)String toDate,
										 @RequestParam(value="fromDate", required = false)String fromDate,
										 @RequestParam(value="inquiryId", required = false)String inquiryId) {
		System.out.println("::: post - getInquiryHistoryList :::"); 
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : "+rowPerPage);
		System.out.println("searchWord : "+searchWord);
		System.out.println("toDate : "+toDate);
		System.out.println("fromDate : "+fromDate);
		System.out.println("inquiryId : "+inquiryId);
		return ljhService.getInquiryHistoryList(currentPage, rowPerPage, searchWord, toDate, fromDate, inquiryId);
	}
	
	//inquiry 카테고리 가져오기
	@GetMapping("/rest/admin/getInquiryListTest")
	public List<Inquiry> getInquiryList(){
		System.out.println("::: get - getInquiryList :::"); 
		return ljhService.getInquiryList();
	}
	
	//체크박스로 선택한 inquiry배열 가져오고 삭제하기
	@PostMapping("/rest/admin/removeInquiryHistoryListTest")
	public String removeInquiryHistoryList(@RequestParam(value="checkBoxArr")List<String> inquiryHistoryIdList) {
		System.out.println("::: post - removeInquiryHistoryList :::");
		System.out.println(inquiryHistoryIdList.toString());
		ljhService.removeInquiryHistoryList(inquiryHistoryIdList);
		return "삭제성공";
	}
	
	//FAQ 리스트 바로 가져오기
	@PostMapping("/rest/admin/getFaqBoardListTest")
	public Map<String,Object> getFaqBoardList(@RequestParam(value="currentPage",defaultValue = "1")int currentPage,
			@RequestParam(value="rowPerPage",defaultValue = "10")int rowPerPage,
			@RequestParam(value="searchWord", required = false)String searchWord,
			@RequestParam(value="toDate", required = false)String toDate,
			 @RequestParam(value="fromDate", required = false)String fromDate,
			 @RequestParam(value="serviceCategoryId", required = false)String serviceCategoryId) {
		System.out.println("::: post - getFaqBoardListTest :::"); 
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : "+rowPerPage);
		System.out.println("searchWord : "+searchWord);
		System.out.println("toDate : "+toDate);
		System.out.println("fromDate : "+fromDate);
		System.out.println("serviceCategory : "+serviceCategoryId);
		return ljhService.getFaqBoardList(currentPage, rowPerPage, searchWord, toDate, fromDate, serviceCategoryId);
	}
}