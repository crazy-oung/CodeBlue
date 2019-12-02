package com.example.codeblue.board.service;

import java.util.Map;



public interface QuestionBoardService {
	
	public Map<String,Object> getQuestBoardList(int currentpage,int rowPerPage,String searchWord);
}
