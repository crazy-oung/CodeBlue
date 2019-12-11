package com.example.codeblue.test.Lee;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionComment;
import com.example.codeblue.vo.User;

@Mapper
public interface LeeMapper {
	//재사용
	public User selectUserOne(String  userId); //<-- 얘만 확인
	
	//전체 답변 수
	public int selectQuestionCommentCount();
	//유저 답변 리스트
	public List<QuestionComment> selectQuestionCommentList(String userId);
	//유저 질문 리스트
	public List<QuestionBoard> selectQuestionBoardList(String userId);
	//유저 답변수
	public int selectQuestionBoardCount(String userId);
	//유저 질문 차트
	public List<QuestionBoard> selectQuestionChart(String userId);
	//유저 답변 수
	public int selectQuestionCommentCount(String userId);
	//유저 답변 차트
	public List<QuestionComment> selectCommentChart(String userId);
}
