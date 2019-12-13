package com.example.codeblue.test.ljh;

import java.util.List;

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
	//공지사항 리스트 삭제
	public int deleteNoticeBoard(List<String> noticeBoardIdList);
}