package com.example.codeblue.test.Lee;


import java.util.List;

import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionComment;
import com.example.codeblue.vo.User;

public interface LeeService {
	//유저 상세 프로필
	public User getUserOne(String userId);
	//해당 유저 질문 리스트 가져오기
	public List<QuestionBoard> getQuestionBoard(String userId);
	//해당 유저 댓글 리스트 가져오기.
	public List<QuestionComment> getQuestionComment(String userId);
	//해당 유저 질문 수
	public int questionBoardCount(String userId);
	//해당 유저 질문 수 차트
	public List<QuestionBoard> getQuestionChart(String userId);
	//해당 유저 답변 수
	public int questionCommentCount(String userId);
	//해당 유저 답변 수 차트
	public List<QuestionComment> getCommentChart(String userId);
	}
