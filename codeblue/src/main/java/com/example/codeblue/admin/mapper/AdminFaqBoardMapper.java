package com.example.codeblue.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.admin.vo.FaqBoard;

@Mapper
public interface AdminFaqBoardMapper {
	//고객센터 답변 삽입
	public int insertFaqBoard(FaqBoard faqBoard);
}
