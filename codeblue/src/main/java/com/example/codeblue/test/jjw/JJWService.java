package com.example.codeblue.test.jjw;

import java.util.List;
import java.util.Map;

import com.example.codeblue.vo.Feild;
import com.example.codeblue.vo.Page;


public interface JJWService {
	
	public Map<String,Object> getWithdrawQuestionBoardList(Page page,int currentPage);
	public void removeQeustionBoardList(List<String> questionBoardIdList);
//	public List<Feild> getFeildList();
//	public Map<String,Object> getQuestionBoardList(Page page,int currentPage);
}
