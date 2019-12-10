package com.example.codeblue.service;

import java.util.List;
import java.util.Map;

import com.example.codeblue.vo.Answer;
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

public interface AdminService {
	
	
	//답변 상세정보 가져오기
	public Answer getAnswerOne(String answerId);
	//답변 삭제하기
	public void removeAnswerList(List<String> answerIdList);
	//답변 리스트 가져오기
	public Map<String,Object> getAnswerList(Page page,int currentPage);
	//삭제된 게시글 상세정보 가져오기
	public QuestionBoard getWithdrawQuestionBoardOne(String questionId);
	//게시글 상세정보 가져오기
	public QuestionBoard getQuestionBoardOne(String questionId);
	//삭제된 게시물 리스트 가져오기
	public Map<String,Object> getWithdrawQuestionBoardList(Page page,int currentPage);
	//게시물 삭제하기
	public void removeQeustionBoardList(List<String> questionBoardIdList);
	//병원정보 수정
	public int modifyHospital(Hospital hospital);
	//회원 리스트
	public Map<String,Object> getAdminUserList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate);
	// 회원 탈퇴(activity를 y->n으로)
	public int removeAdminUser(List<String> checkBoxArr);
	// 탈퇴회원 조회 리스트
	public Map<String,Object> getAdminWithdrawUserList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate);
	// 탈퇴회원 복구(activity를 n->y로)
	public int modifyAdminWithdrawUser(List<String> checkBoxArr);
	// 전문가회원 리스트
	public Map<String,Object> getAdminExpertUserList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate);
	//공지사항 리스트
	public Map<String,Object> getNoticeBoard(int currentPage,int rowPerPage, String searchWord);
	//공지사항 상세보기
	public NoticeBoard getNoticeOne(int noticeId);
	//공지사항 추가하기
	public int addNotice(NoticeBoard noticeBoard);
	//공지사항 삭제
	public int removeNoticeBoard(int noticeId);
	//문의 내역 리스트 출력
	public Map<String, Object> getInquiryHistoryList(int currentPage, int rowPerPage);
	//문의 내역 상세 페이지 출력
	public InquiryHistory getInquiryHistoryOne(int inquiryHistoryId);
	//신고 내역 리스트 출력
	public Map<String, Object> getReportHistoryList(int currentPage, int rowPerPage);
	//신고 내역 상세 페이지 출력
	public ReportHistory getReportHistoryOne(int reportHistoryId);
	public List<QuestionCount> getYearlyQuestionCount();
	public List<QuestionCount> getCurrentQuestionCountFromFeild();
	//검색 조건 카테고리 리스트 가져오기
	public List<Feild> getFeildList();
	//질문 리스트 출력
	public Map<String,Object> getQuestionBoardList(Page page,int currentPage);
	//서비스 카테고리 리스트 가져오기
	public List<ServiceCategory> getServiceCategoryList();
	//병원 리스트
	public Map<String, Object> getHospitalList(int currentPage, int rowPerPage, String searchWord);
	//병원 추가
	public int addHospital(Hospital hospital);
	//병원 삭제
	public int removeHospital(int hospitalId);
	//병원 상세페이지
	public List<Hospital> getHospitalOne(int hospitalId);
	//문의사항 답변 추가하기
	public int addInquiryHistoryAnswer(InquiryHistoryAnswer inqruiyHistoryAnswer);
	//FAQ 전체 리스트 가져오기
	public Map<String,Object> getFaqBoardList(int currentPage, int rowPerPage, String searchWord);
	//FAQ 추가하기
	public int addFaqBoard(FaqBoard faqBoard);
	//FAQ 상세정보 가져오기
	public FaqBoard getFaqOne(int faqId);
	//FAQ 정보 삭제하기
	public int removeFaq(int faqId);
	//FAQ 수정하기
	public int modifyFaq(FaqBoard faqBoard);
}
