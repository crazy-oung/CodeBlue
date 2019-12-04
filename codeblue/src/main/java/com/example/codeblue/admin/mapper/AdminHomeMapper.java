package com.example.codeblue.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.admin.vo.QuestionCount;

@Mapper
public interface AdminHomeMapper {
	public List<QuestionCount> selectCurrentQuestionCountFor6Month();
	public List<QuestionCount> selectCurrentQuestionCountFromFeild();
}
