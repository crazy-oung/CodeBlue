package com.example.codeblue.test.ljh;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.ReportHistory;

@Mapper
public interface LjhMapper {
	
	//신고내역 상세 내용 가져오기
	public ReportHistory selectReportHistoryOne(int reportHistoryId);
	//신고 대상(질문)상세 정보 가져오기
	public QuestionBoard selectReportQuestionBoardOne(int questionId);
	//신고 대상(답변)상세 정보 가져오기
	public Answer selectReportAnswerOne(int answerId);
	
	//신고내역 가져오기
	public List<ReportHistory> selectReportHistoryList(Page page);
	public int selectReportHistoryTotalRow(Page page);
	
	
	
	
//	//Report 카테고리 가져오기
//	public List<Report> selectReportList();
			
//	//병원 데이터 입력
//	public int insertHospital(Hospital hospital);
//	//병원 이미지 입력
//	public int insertHospital(HospitalImg HospitalImg);
	
	
}