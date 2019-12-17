package com.example.codeblue.test.yyj;

import java.util.Map;
import com.example.codeblue.vo.Page;

public interface YyjService {
	
	public Map<String, Object> getPointList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate);
	public Map<String, Object> getPointListTotal(int currentPage, int rowPerPage, String searchWord);
}
