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
	public int selectQuestionCommentCount();
	public List<QuestionComment> selectQuestionCommentList(String userId);
	public List<QuestionBoard> selectQuestionBoardList(String userId);
	public int selectQuestionBoardTotalCount();

}
