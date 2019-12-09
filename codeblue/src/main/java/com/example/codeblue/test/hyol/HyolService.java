package com.example.codeblue.test.hyol;

import java.util.List;
import java.util.Map;

public interface HyolService {

	//회원 리스트
	public Map<String,Object> getAdminUserList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate);
	// 회원 업데이트(activity를 y->n으로)
	public int removeAdminUser(List<String> checkBoxArr);
}
