package com.example.codeblue.vo;

import lombok.Data;

@Data
public class Page {
	public int beginRow;
	public int rowPerPage;
	// 신고내역 질문 or 답변 유형 저장 변수 (question or answer 저장)
	public String reportCategory;
	// 각 페이지에서의 검색 조건
	public String searchWord;
	public String searchCategory;
	// userTopBar에서 검색 조건
	public String searchQuestionBoard;
	public String toDate;
	public String fromDate;
	public int feildId;
	//프로필에서 해당유저 게시글 페이징
	public String userId;
}