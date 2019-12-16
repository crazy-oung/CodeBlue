package com.example.codeblue.test.ljh;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.vo.FaqBoard;
import com.example.codeblue.vo.Hospital;
import com.example.codeblue.vo.HospitalImg;
import com.example.codeblue.vo.Inquiry;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.Page;

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
	// FAQ 전체리스트 가져오기
	public List<FaqBoard> selectFaqBoardList(Page page);
	// FAQ 전체 행 값 가져오기
	public int selectFaqBoardTotalCount(Page page);
	//FAQ 리스트 삭제
	public int deleteFaqBoardList(List<String> faqBoardIdList);
	//Inquiry 카테고리 가져오기
	public List<Inquiry> selectInquiryList();
	//inquiry 리스트 삭제
	public int deleteInquiryHistoryList(List<String> inquiryHistoryIdList);
	//inquiryAnswer 리스트 삭제
	public int deleteInquiryHistoryAnswerList(List<String> inquiryHistoryIdList);
	//문의내역 가져오기
	public List<InquiryHistory> selectInquiryHistoryList(Page page);
	public int InquiryHistoryTotalRow(Page page);
}