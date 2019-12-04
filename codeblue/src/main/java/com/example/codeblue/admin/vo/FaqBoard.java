package com.example.codeblue.admin.vo;

import com.example.codeblue.user.vo.ServiceCategory;

import lombok.Data;

@Data
public class FaqBoard {
	private int faqId;
	private String faqTitle;
	private ServiceCategory serviceCategory;
	private String faqContent;
	private String faqDatetime;
	//임시 컬럼
	private int serviceCategoryId;
}
