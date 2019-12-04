package com.example.codeblue.admin.service;

import java.util.List;

import com.example.codeblue.admin.vo.QuestionCount;

public interface AdminHomeService {
	public List<QuestionCount> getCurrentQuestionCountFor6Month();
	public List<QuestionCount> getCurrentQuestionCountFromFeild();
	
}
