package com.example.codeblue.test.jjw;

import java.util.List;
import java.util.Map;

import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.Feild;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;


public interface JJWService {
	
	//답변 댓글 삭제하기
	public void removeAnswerCommentList(List<String> answerCommentIdList);
	//답변 댓글 리스트 가져오기
	public Map<String,Object> getAnswerCommentList(Page page,int currentPage);
	//질문 댓글 삭제하기
	public void removeQuestionCommentList(List<String> questionCommentIdList);
	//질문 댓글 리스트 가져오기
	public Map<String,Object> getQuestionCommentList(Page page,int currentPage);
	//답변 상세정보 가져오기
	public Answer getAnswerOne(String answerId);
	//답변 삭제하기
	public void removeAnswerList(List<String> answerIdList);
	//답변 리스트 가져오기
	public Map<String,Object> getAnswerList(Page page,int currentPage);
	//삭제된 게시글 상세정보 가져오기
	public QuestionBoard getWithdrawQuestionBoardOne(String questionId);
	//게시글 상세정보 가져오기
	public QuestionBoard getQuestionBoardOne(String questionId);
	//삭제된 게시물 리스트 가져오기
	public Map<String,Object> getWithdrawQuestionBoardList(Page page,int currentPage);
	public void removeQeustionBoardList(List<String> questionBoardIdList);
//	public List<Feild> getFeildList();
	public Map<String,Object> getQuestionBoardList(Page page,int currentPage);
}
