package com.example.codeblue.test.hyol;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.vo.FaqBoard;
import com.example.codeblue.vo.Inquiry;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.ServiceCategory;
import com.example.codeblue.vo.User;

@Mapper
public interface HyolMapper {

	// 회원리스트
	public List<User> adminSelectUserList(Page page);
	// 회원 수
	public int adminSelectUserCount(Page page);
	// 회원 삭제(y->n)
	public int adminDeleteUser(List<String> checkBoxArr);
	// 탈퇴회원리스트
	public List<User> adminSelectWithdrawUserList(Page page);
	// 탈퇴 회원 수
	public int adminSelectWithdrawUserCount(Page page);
	// 회원 복구(n->y)
	public int adminUpdateWithdrawUser(List<String> checkBoxArr);
	// 전문가 회원 리스트
	public List<User> adminSelectExpertUserList(Page page);
	// 전문가 회원 수
	public int adminSelectExpertUserCount(Page page);
	// -------------------------------------------------------유저-----------------------------------------------
	// 유저 유저조회
	public List<User> selectUserList(Page Page);
	// 유저 유저 수
	public int selectUserCount(Page Page);
	// serviceCategory 조회
	public List<ServiceCategory> selectServiceCategoryList();
	// faq 조회
	public List<FaqBoard> selectFaqList(Page page);
	// faq 총 수
	public int selectFaqCount(Page page);
	// faqone 출력 (이전글,다음글까지 출력)
	public List<FaqBoard> selectFaqOne(int faqId);
	// inquiry 카테고리 조회
	public List<Inquiry> selectInquiry();
	// 문의 내역 리스트  출력
	public List<InquiryHistory> selectInquiryHistory(Page page);
	// 문의 내역 리스트 행의 수
	public int selectInquiryHistoryCount(Page page);
	
}