package com.example.codeblue.board.service;

import java.util.List;
import java.util.Map;

import com.example.codeblue.board.vo.QuestionBoard;
import com.example.codeblue.board.vo.QuestionComment;



public interface QuestionBoardService {
	
	public Map<String,Object> getQuestBoardList(int currentpage,int rowPerPage,String searchWord);
	public QuestionBoard getQuestionBoardOne(int questionId);
	public List<QuestionComment> getQuestionCommentList(int questionId);
}
