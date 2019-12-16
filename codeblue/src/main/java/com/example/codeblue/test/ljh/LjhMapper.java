package com.example.codeblue.test.ljh;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.vo.Hospital;
import com.example.codeblue.vo.HospitalImg;
import com.example.codeblue.vo.NoticeBoard;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.Report;
import com.example.codeblue.vo.ReportHistory;

@Mapper
public interface LjhMapper {
	
	
	
	//신고내역 가져오기
	public List<ReportHistory> selectReportHistoryList(Page page);
	public int selectReportHistoryTotalRow(Page page);
	//Report 카테고리 가져오기
	public List<Report> selectReportList();
	
			
			
			
	
	
	
	
	
	
			
			
	//병원 데이터 입력
	public int insertHospital(Hospital hospital);
	//병원 이미지 입력
	public int insertHospital(HospitalImg HospitalImg);
	
	
}