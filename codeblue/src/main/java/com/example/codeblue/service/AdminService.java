package com.example.codeblue.service;

import java.util.List;
import java.util.Map;

import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.FaqBoard;
import com.example.codeblue.vo.Feild;
import com.example.codeblue.vo.Hospital;
import com.example.codeblue.vo.Inquiry;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.InquiryHistoryAnswer;
import com.example.codeblue.vo.Manager;
import com.example.codeblue.vo.NoticeBoard;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionCount;
import com.example.codeblue.vo.Report;
import com.example.codeblue.vo.ReportHistory;
import com.example.codeblue.vo.ServiceCategory;
import com.example.codeblue.vo.User;

public interface AdminService {
	
	// 유저 활동지 통계
	public Map<String, Object> getUserRegionCount();
	// 문의 처리율 
	public double getInqueryAnswerPercentage();
	// 문의사항 답변 상세정보 가져오기
	public InquiryHistoryAnswer getInquiryHistoryAnswerOne(int inquiryHistoryId);
	//신고내역  리스트 삭제
	public void removeReportHistoryList(List<String> reportHistoryIdList);
	//Report 카테고리 가져오기
	public List<Report> getReportList();
	//Inquiry 리스트 삭제
	public void removeInquiryHistoryList(List<String> inquiryHistoryIdList);
	//Inquiry 카테고리 가져오기
	public List<Inquiry> getInquiryList();
	//답변 댓글 삭제하기
	public void removeAnswerCommentList(List<String> answerCommentIdList);
	//답변 댓글 리스트 가져오기
	public Map<String,Object> getAnswerCommentList(Page page,int currentPage);
	//질문 댓글 삭제하기
	public void removeQuestionCommentList(List<String> questionCommentIdList);
	//질문 댓글 리스트 가져오기
	public Map<String,Object> getQuestionCommentList(Page page,int currentPage);
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
	public Map<String,Object> getNoticeBoard(int currentPage,int rowPerPage, String searchWord, String toDate, String fromDate);
	//공지사항 상세보기
	public NoticeBoard getNoticeOne(int noticeId);
	//공지사항 추가하기
	public int addNotice(NoticeBoard noticeBoard);
	//공지사항 삭제
	public int removeNoticeBoard(int noticeId);
	//공지사항 리스트 삭제
	public void removeNoticeBoardList(List<String> noticeBoardIdList);
	//문의 내역 리스트 출력
	public Map<String, Object> getInquiryHistoryList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate, String inquiryId, String inquiryCategory);
	//문의 내역 상세 페이지 출력
	public InquiryHistory getInquiryHistoryOne(int inquiryHistoryId);
	//신고 내역 리스트 출력
	public Map<String, Object> getReportHistoryList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate, String reportId, String reportCategory);
	//신고 내역 상세 페이지 출력
	public ReportHistory getReportHistoryOne(int reportHistoryId);
	public List<QuestionCount> getYearlyQuestionCount();
	public List<QuestionCount> getCurrentQuestionCountFromFeild();
	//신고 대상(질문)상세 정보 가져오기
	public QuestionBoard getReportQuestionBoardOne(int questionId);
	//신고 대상(답변)상세 정보 가져오기
	public Answer getReportAnswerOne(int answerId);
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
	public void addInquiryHistoryAnswer(InquiryHistoryAnswer inqruiyHistoryAnswer);
	//FAQ 전체 리스트 가져오기
	public Map<String,Object> getFaqBoardList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate, String serviceCategory);
	//FAQ 추가하기
	public int addFaqBoard(FaqBoard faqBoard);
	//FAQ 상세정보 가져오기
	public FaqBoard getFaqOne(int faqId);
	//FAQ 정보 삭제하기
	public int removeFaq(int faqId);
	//FAQ 리스트 삭제
	public void removeFaqBoardList(List<String> faqBoardIdList);
	//FAQ 수정하기
	public int modifyFaq(FaqBoard faqBoard);
	//관리자 추가
	public int addAdministrator(Manager manager);
	//관리자 추가 인증 메일
	public String sendCodeToMail(Manager manager);
	// 관리자 확인
	public Manager verifyManager(User user);
	// 관리자 전체 리스트 가져오기
	public Map<String, Object> getManagerList(int currentPage, int rowPerPage);
	// 관리자 삭제하기
	public int removeManager(String managerId);
	// 관리자 상세보기 정보 가져오기
	public Manager getManagerOne(String managerId);
	
}
