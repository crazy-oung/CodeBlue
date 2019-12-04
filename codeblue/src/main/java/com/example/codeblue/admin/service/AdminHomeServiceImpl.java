package com.example.codeblue.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.admin.mapper.AdminHomeMapper;
import com.example.codeblue.admin.vo.QuestionCount;

@Transactional
@Service
public class AdminHomeServiceImpl implements AdminHomeService{
	
	@Autowired AdminHomeMapper adminHomeMapper;
	
	@Override
	public List<QuestionCount> getCurrentQuestionCountFor6Month() {
		System.out.println("::: AdminHomeServiceImpl - getCurrentQuestionCountFor6Month :::");
		return adminHomeMapper.selectCurrentQuestionCountFor6Month();
	}

	@Override
	public List<QuestionCount> getCurrentQuestionCountFromFeild() {
		System.out.println("::: AdminHomeServiceImpl - getCurrentQuestionCountFromFeild :::");
		return adminHomeMapper.selectCurrentQuestionCountFromFeild();
	}

}
