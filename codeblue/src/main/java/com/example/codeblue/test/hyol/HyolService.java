package com.example.codeblue.test.hyol;

import java.util.Map;

public interface HyolService {

	//회원 리스트
		public Map<String,Object> getAdminUserList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate);
}
