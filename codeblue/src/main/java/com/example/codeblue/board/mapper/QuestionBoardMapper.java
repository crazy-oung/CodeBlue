package com.example.codeblue.board.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.board.vo.Page;
import com.example.codeblue.board.vo.QuestionBoard;

@Mapper
public interface QuestionBoardMapper {
	
	public int selectQuestionBoardVotes(QuestionBoard questionBoard);
	public int selectQuestionBoardAnswerCount(QuestionBoard questionBoard);
	public int selectQuestionBoardTotalCount(Page page);
	public List<QuestionBoard> selectQuestionBoardList(Page page);
	
}
