package com.example.codeblue.test.jjw;

import java.util.List;

import com.example.codeblue.vo.Feild;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;

@org.apache.ibatis.annotations.Mapper
public interface JJWMapper {
	
	public List<Feild> selectFeildList();
	public int selectQuestionBoardTotalCount(Page page);
	public List<QuestionBoard> selectQuestionBoardList(Page page);
}
