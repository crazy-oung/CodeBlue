package com.example.codeblue.test.hyol;

import java.util.List;
import java.util.Map;

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
}
