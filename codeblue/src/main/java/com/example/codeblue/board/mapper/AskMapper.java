package com.example.codeblue.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.board.vo.QuestionBoard;

@Mapper
public interface AskMapper {
	public int insertQuestion(QuestionBoard questionBoard);
}
