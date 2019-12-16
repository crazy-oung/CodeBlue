package com.example.codeblue.test.ljh;

import java.util.List;
import java.util.Map;

import com.example.codeblue.vo.HospitalForm;
import com.example.codeblue.vo.Inquiry;

public interface LjhService {
	//질문 답변 댓글 개수 가져오기
	public int getAnswerCommentCount(int answerId);
	public int addHospital(HospitalForm hospitalForm);
	//FAQ 리스트 삭제
	public void removeFaqBoardList(List<String> faqBoardIdList);
	//FAQ 전체 리스트 가져오기
	public Map<String,Object> getFaqBoardList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate, String serviceCategory);
	//Inquiry 카테고리 가져오기
	public List<Inquiry> getInquiryList();
	//Inquiry 리스트 삭제
	public void removeInquiryHistoryList(List<String> inquiryHistoryIdList);
	//문의 내역 리스트 출력(복)
	public Map<String, Object> getInquiryHistoryList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate, String inquiryId);
}