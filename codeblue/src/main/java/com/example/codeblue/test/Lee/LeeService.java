package com.example.codeblue.test.Lee;


import java.util.List;

import java.util.Map;

import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionComment;
import com.example.codeblue.vo.QuestionVote;
import com.example.codeblue.vo.User;

public interface LeeService {
	//유저 상세 프로필
	public User getUserOne(String userId);
	
	//해당 유저 질문 리스트 가져오기
	public List<QuestionBoard> getQuestionBoard(String userId);
	//해당 유저 질문 리스트 (페이징)
	public Map<String, Object> getQuestionBoardPaging(int currentPage, int rowPerPage, String userId);
	//해당 유저 질문 수
	public int questionBoardCount(String userId);
	//해당 유저 질문 수 차트
	public List<QuestionBoard> getQuestionChart(String userId);
	
	//해당 유저 댓글 리스트 가져오기.
	public List<QuestionComment> getQuestionComment(String userId);
	//해당 유저 댓글 수
	public int questionCommentCount(String userId);
	//해당 유저 댓글 리스트(페이징)
	public Map<String, Object> getCommentBoardPaging(int currentPage, int rowPerPage, String userId);
	
	//해당 유저 답글 리스트
	public List<Answer> getQuestionAnswer(String userId);
	//해당 유저 답글 리스트(페이징)
	public Map<String, Object> getAnswerPaging(int currentPage, int rowPerPage, String userId);
	//해당 유저 답글 수
	public int answerCount(String userId);
	//해당 유저 답글 수 차트
	public List<Answer> getAnswerChart(String userId);
	
	//해당 유저 질문 글 추천 수
	public int getUserVote(String userId);
	//유저 질문 중복 검사
	public String getQuestionVoteCheck(QuestionVote questionVote);
}
