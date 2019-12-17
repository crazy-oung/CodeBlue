package com.example.codeblue.test.ljh;

import java.util.Map;

import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.ReportHistory;


public interface LjhService {
	
	
	
	
	//신고 내역 상세 페이지 출력
	public ReportHistory getReportHistoryOne(int reportHistoryId);
	//신고 대상(질문)상세 정보 가져오기
	public QuestionBoard getReportQuestionBoardOne(int questionId);
	//신고 대상(답변)상세 정보 가져오기
	public Answer getReportAnswerOne(int answerId);
	
	//public int addHospital(HospitalForm hospitalForm);
}