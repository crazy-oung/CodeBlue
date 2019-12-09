package com.example.codeblue.test.ljh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.vo.FaqBoard;

@RestController
public class LjhRestController {
	@Autowired LjhService ljhService;
	
//	//FAQ 상세정보 가져오기
//	@PostMapping("/rest/adminFaqOne")
//	public FaqBoard getFaqOne(@RequestParam(value="faqId")int faqId) {
//		System.out.println(":::post - getFaqOne:::");
//		System.out.println("faqId : "+ faqId);
//		return ljhService.getFaqOne(faqId);
//	}
//	//FAQ 삭제
//	@PostMapping("/rest/removeFaqBoard")
//	public int removeFaqBoard(@RequestParam(value="faqId")int faqId) {
//		System.out.println(":::post - removeFaqBoard:::");
//		
//		return ljhService.removeFaq(faqId);
//	}
//	//FAQ 수정하기
//	@PostMapping("/rest/modifyFaqBorad")
//	public int modifyFaqBoard(FaqBoard faqBoard) {
//		System.out.println(":::post - modifyFaqBoard:::");
//		System.out.println("faqBoard : " + faqBoard.toString());
//		return ljhService.modifyFaq(faqBoard);
//	}
}