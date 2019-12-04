package com.example.codeblue.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.board.vo.Page;
import com.example.codeblue.board.vo.QuestionBoard;

@Mapper
public interface AdminBoardMapper {

	public List<String> selectAdminFeildList();
	public int selectAdminBoardTotalCount(Page page);
	public List<QuestionBoard> selectAdminBoardList(Page page);
}
