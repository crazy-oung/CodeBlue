package com.example.codeblue.test.ljh;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.vo.Hospital;
import com.example.codeblue.vo.HospitalImg;

@Mapper
public interface LjhMapper {
	//질문 답변 개수 가져오기
	public int selectAnswerCommentCount(int answerId);
	//병원 데이터 입력
	public int insertHospital(Hospital hospital);
	//병원 이미지 입력
	public int insertHospital(HospitalImg HospitalImg);
}