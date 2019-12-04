package com.example.codeblue.admin.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.admin.service.AdminHomeService;
import com.example.codeblue.admin.vo.QuestionCount;

@RestController
public class AdminHomeRestController {
	
	@Autowired AdminHomeService adminHomeService;
	
	@GetMapping("/getCurrentQuestionCountFor6Month")
	public List<QuestionCount> getCurrentQuestionCountFor6Month(){
		System.out.println("::: get - getCurrentQuestionCountFor6Month :::");
		return adminHomeService.getCurrentQuestionCountFor6Month();
	}
	
	@GetMapping("/getCurrentQuestionCountFromFeild")
	public List<QuestionCount> getCurrentQuestionCountFromFeild(){
		System.out.println("::: get - getCurrentQuestionCountFromFeild :::");
		return adminHomeService.getCurrentQuestionCountFromFeild();
	}
	
}
