package com.example.codeblue.vo;

import lombok.Data;

@Data
public class FaqBoard {
	private int faqId;
	private String faqTitle;
	private ServiceCategory serviceCategory;
	private String faqContent;
	private String faqDatetime;
}
