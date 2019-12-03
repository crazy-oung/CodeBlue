package com.example.codeblue.board.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.board.vo.Page;
import com.example.codeblue.board.vo.QuestionBoard;
import com.example.codeblue.board.vo.QuestionComment;

@Mapper
public interface QuestionBoardMapper {
	
	public int selectQuestionCommentCount(int questionId);
	public int selectQuestionBoardVotes(QuestionBoard questionBoard);
	public int selectQuestionBoardAnswerCount(QuestionBoard questionBoard);
	public int selectQuestionBoardTotalCount(Page page);
	public List<QuestionBoard> selectQuestionBoardList(Page page);
	public QuestionBoard selectQuestionBoardOne(int questionId);
	public List<QuestionComment> selectQuestionCommentList(int questionId);
	
}
