package com.example.codeblue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.vo.FaqBoard;
import com.example.codeblue.vo.Feild;
import com.example.codeblue.vo.Hospital;
import com.example.codeblue.vo.InquiryHistory;
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
	
	public List<Feild> selectAdminFeildList();
	public int selectAdminBoardTotalCount(Page page);
	public List<QuestionBoard> selectAdminBoardList(Page page);
	//고객센터 답변 삽입
	public int insertFaqBoard(FaqBoard faqBoard);
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
	//회원리스트
	public List<User> adminSelectUserList(Page page);
	//회원 수
	public int adminSelectUserCount(Page page);
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
	
}
