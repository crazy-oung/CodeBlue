package com.example.codeblue.test.Lee;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionComment;
import com.example.codeblue.vo.User;

@Mapper
public interface LeeMapper {
	//재사용
	public User selectUserOne(String  userId); //<-- 얘만 확인
	//유저 질문 리스트
	public List<QuestionBoard> selectQuestionBoardList(String userId);
	//유저 질문 리스트(페이징)
	public List<QuestionBoard> selectQuestionPaging(Page page);
	//유저 질문수(해당유저)
	public int selectQuestionBoardCount(String userId);
	//유저 질문 차트
	public List<QuestionBoard> selectQuestionChart(String userId);
	
	//유저 댓글 수(해당유저)
	public int selectQuestionCommentCount(String userId);
	//유저 댓글 차트
	public List<QuestionComment> selectCommentChart(String userId);
	//전체 댓글 수
	public int selectQuestionCommentCount();
	//유저 댓글 리스트
	public List<QuestionComment> selectQuestionCommentList(String userId);
	//유저 댓글 리스트(페이징)
	public List<QuestionComment> selectCommentPaging(Page page);	
	
	//유저 답글 리스트
	public List<Answer> selectQuestionAnswerList(String userId);
	//유저 답글 리스트(페이징)
	public List<Answer> selectQuestionAnswerPaging(Page page);
	//유저 답글 리스트 수
	public int selectAnswerCount(String userId);
}
