package com.example.codeblue.test.yyj;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.vo.NoticeBoard;

@RestController
public class YyjRestController {
	@Autowired YyjService yyjService;
	
//	@PostMapping("/rest/adminNoticeBoardTest")
//	public Map<String, Object> postNoticeTest(@RequestParam(value="currentPage",defaultValue = "1")int currentPage,
//							@RequestParam(value="rowPerPage",defaultValue = "10")int rowPerPage,
//							@RequestParam(value="searchWord", required = false)String searchWord) {
//		
//		System.out.println(":::post - postNotice:::");
//		System.out.println("currentPage"+currentPage);
//		System.out.println("rowPerPage"+rowPerPage);
//		System.out.println("searchWord"+searchWord);
//
//		return yyjService.getNoticeBoardTest(currentPage, rowPerPage, searchWord);
//	}
//	
//	@PostMapping("/rest/adminNoticeBoardOneTest")
//	public NoticeBoard postNoticeOneTest(@RequestParam(value="noticeId") int noticeId) {
//		System.out.println(":::post - postNoticeOne:::");
//		System.out.println("noticeId"+noticeId);
//		return yyjService.getNoticeOneTest(noticeId);
//	}
//	
//	@PostMapping("/rest/adminNoticeAddTest")
//	public int postNoticeAddTest(NoticeBoard noticeBoard) {
//		System.out.println(":::post - postNoticeAdd");
//		System.out.println("NoticeBoard"+noticeBoard);
//		return yyjService.addNoticeTest(noticeBoard);
//	}
//	@PostMapping("/rest/removeNoticeBoardTest")
//	public String removeNoticeBoardTest(@RequestParam(value="noticeId")int noticeId) {
//		System.out.println(":::post - removeNoticeBoardTest:::");
//		System.out.println("noticeId Controller : " + noticeId);
//		yyjService.removeNoticeBoardTest(noticeId);
//		
//		return "/codeBlue/admin/adminNoticeBoardTest";
//	}
	
}
