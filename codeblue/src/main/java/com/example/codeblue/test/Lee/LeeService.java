package com.example.codeblue.test.Lee;


import java.util.List;

import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionComment;
import com.example.codeblue.vo.User;

public interface LeeService {
	public User getUserOne(String userId);
	
	public List<QuestionBoard> getQuestionBoard(String userId);
	public List<QuestionComment> getQuestionComment(String userId);
	}
