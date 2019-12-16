package com.example.codeblue.test.hyol;

import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import com.example.codeblue.vo.FaqBoard;
import com.example.codeblue.vo.Inquiry;
import com.example.codeblue.vo.ServiceCategory;

public interface HyolService {

	// 회원 리스트
	public Map<String,Object> getAdminUserList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate);
	// 회원 탈퇴(activity를 y->n으로)
	public int removeAdminUser(List<String> checkBoxArr);
	// 탈퇴회원 조회 리스트
	public Map<String,Object> getAdminWithdrawUserList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate);
	// 탈퇴회원 복구(activity를 n->y로)
	public int modifyAdminWithdrawUser(List<String> checkBoxArr);
	// 전문가회원 리스트
	public Map<String,Object> getAdminExpertUserList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate);
	// ----------------------------------------------------------------유저---------------------------------------------------
	// 유저 유저조회
	public Map<String,Object> getUserList(int currentPage, int rowPerPage, String searchWord);
	// serviceCategory 조회
	public List<ServiceCategory> getServiceCategoryList();
	// faq 조회
	public Map<String,Object> getFaqList(int currentPage, int rowPerPage, String searchCategory);
	// faqone 출력 (이전글,다음글까지 출력)
	public List<FaqBoard> getFaqOne(int faqId);
	// inquiry 출력
	public List<Inquiry> getInquiryList();
	// inquiry 히스토리출력(자신이 올린 글만)
	public Map<String,Object> getInquiryHistoryBoard(int currentPage, int rowPerPage, String loginUserId, String searchCategory);
}