package com.example.codeblue.test.ljh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.vo.AnswerComment;
import com.example.codeblue.vo.QuestionComment;


@RestController
public class LjhRestController {
	@Autowired LjhService ljhService;
	/*
	 * //질문 댓글 추가하기
	 * 
	 * @PostMapping("/rest/questionCommentAdd") public int
	 * questionCommentAdd(QuestionComment questionComment) {
	 * System.out.println("::: post - questionCommentAdd :::");
	 * System.out.println(questionComment.toString()); return
	 * ljhService.addQeustionComment(questionComment); } //질문 답변 댓글 추가하기
	 * 
	 * @PostMapping("/rest/addAnswerCommnet") public int
	 * addAnswerCommnet(AnswerComment answerComment) {
	 * System.out.println("::: post - addAnswerCommnet :::");
	 * System.out.println(answerComment.toString()); return
	 * ljhService.addAnswerComment(answerComment); }
	 */
	/*
	//문의내역 상세페이지 가져오기
	@PostMapping("/rest/admin/adminInquiryOneTest")
	public InquiryHistory getInquiryHistoryOne(int inquiryHistoryId) {
		System.out.println("::: post - getInquiryHistoryOne :::");
		return ljhService.getInquiryHistoryOne(inquiryHistoryId);
	}
	@PostMapping("/rest/admin/getInquiryListTest")
	public Map<String,Object> getInquiryHistoryList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
									 @RequestParam(value="rowPerPage", defaultValue = "15")int rowPerPage) {
		System.out.println("::: post - getInquiryListTest :::"); 
		System.out.println("currentPage : " + currentPage);
		System.out.println("rowPerPage : " + rowPerPage);
		
		return ljhService.getInquiryHistoryList(currentPage, rowPerPage);
	}
	//문의사항 답변 추가하기
	@PostMapping("/rest/admin/addInquiryAnswerTest")
	public void addInquiryHistoryAnswer(InquiryHistoryAnswer inqruiyHistoryAnswer) {
		System.out.println("::: post - addInquiryHistoryAnswer :::"); 
		System.out.println(inqruiyHistoryAnswer.toString());
		ljhService.addInquiryHistoryAnswer(inqruiyHistoryAnswer);
	}
	*/
}