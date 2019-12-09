package com.example.codeblue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.vo.FaqBoard;
import com.example.codeblue.vo.Feild;
import com.example.codeblue.vo.Hospital;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.InquiryHistoryAnswer;
import com.example.codeblue.vo.NoticeBoard;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionCount;
import com.example.codeblue.vo.ReportHistory;
import com.example.codeblue.vo.ServiceCategory;
import com.example.codeblue.vo.User;

@Mapper
public interface AdminMapper {

	//병원정보 수정
	public int updateHospital(Hospital hospital);
	//
	public List<Feild> selectFeildList();
	//질문 전체 갯수
	public int selectQuestionBoardTotalCount(Page page);
	//질문 리스트
	public List<QuestionBoard> selectQuestionBoardList(Page page);
	// 관리자 통계
	public List<QuestionCount> selectYearlyQuestionCount();
	public List<QuestionCount> selectCurrentQuestionCountFromFeild();
	//문의내역 가져오기
	public List<InquiryHistory> selectInquiryHistoryList(Page page);
	public int InquiryHistoryTotalRow();
	//신고내역 가져오기
	public List<ReportHistory> selectReportHistoryList(Page page);
	public int ReportHistoryTotalRow();
	//문의내역 상세 내용 가져오기
	public InquiryHistory selectInquiryHistoryOne(int inquiryHistoryId);
	//신고내역 상세 내용 가져오기
	public ReportHistory selectReportHistoryOne(int reportHistoryId);
	//서비스 카테고리 리스트 가져오기
	public List<ServiceCategory> selectServiceCategoryList();
	//공지사항 리스트
	public List<NoticeBoard> selectNoticeBoard(Page page);
	//공지사항 수
	public int noticeBoardCount(Page page);
	//공지사항 상세보기
	public NoticeBoard noticeBoardOne(int noticeId);
	//공지사항 입력
	public int insertNoticeBoard(NoticeBoard noticeBoard);
	//공지사항 삭제
	public int deleteNoticeBoard(int noticeId);
	//회원리스트
	public List<User> adminSelectUserList(Page page);
	//회원 수
	public int adminSelectUserCount(Page page);
	// 회원 삭제(y->n)
	public int adminDeleteUser(List<String> checkBoxArr);
	//병원 리스트 
	public List<Hospital> hospitalList(Page page);
	//병원 수
	public int hospitalCount();
	//병원 데이터 입력
	public int insertHospital(Hospital hospital);
	//병원 데이터 삭제
	public int deleteHospital(int hospitalId);
	//병원 상세정보 
	public List<Hospital> hospitalOne(int hospitalId);
	// 문의사항 답변 추가하기
	public int insertInquiryHistoryAnswer(InquiryHistoryAnswer inqruiyHistoryAnswer);
	// FAQ 전체리스트 가져오기
	public List<FaqBoard> selectFaqBoardList(Page page);
	// FAQ 전체 행 값 가져오기
	public int selectFaqBoardTotalCount();
	// FAQ 추가하기
	public int insertFaqBoard(FaqBoard faqBoard);
	// FAQ 상세정보가져오기
	public FaqBoard selectFaqOne(int faqId);
	// FAQ 삭제하기
	public int deleteFaq(int faqId);
	// FAQ 수정하기
	public int updateFaq(FaqBoard faqBoard);
}
