package com.example.codeblue.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.AnswerComment;
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
import com.example.codeblue.vo.QuestionComment;
import com.example.codeblue.vo.QuestionCount;
import com.example.codeblue.vo.Report;
import com.example.codeblue.vo.ReportHistory;
import com.example.codeblue.vo.ServiceCategory;
import com.example.codeblue.vo.User;

@Mapper
public interface AdminMapper {
	// 유저 활동지 통계
	public Map<String, Object> selectUserRegionCount();
	// 문의 처리율
	public double selectInqueryAnswerPercentage();
	// 문의사항 답변 상세정보 가져오기
	public InquiryHistoryAnswer selectInquiryHistoryAnswerOne(int inquiryHistoryId);
	//Report 카테고리 가져오기
	public List<Report> selectReportList();
	//신고내역 리스트 삭제
	public int deleteReportHistoryList(List<String> reportHistoryIdList);
	//inquiry 리스트 삭제
	public int deleteInquiryHistoryList(List<String> inquiryHistoryIdList);
	//inquiryAnswer 리스트 삭제
	public int deleteInquiryHistoryAnswerList(List<String> inquiryHistoryIdList);
	//Inquiry 카테고리 가져오기
	public List<Inquiry> selectInquiryList();
	//답변 댓글 Id 값으로 삭제하기
	public void deleteAnswerCommentId(List<String> list);
	//답변 댓글 행수 가져오기
	public int selectAnswerCommentTotalCount(Page page);
	//답변 댓글 리스트 가져오기
	public List<AnswerComment> selectAnswerCommentList(Page page);
	//질문 댓글 Id 값으로 삭제하기
	public void deleteQuestionCommentId(List<String> list);
	//질문 댓글 행수 가져오기
	public int selectQuestionCommentTotalCount(Page page);
	//질문 댓글 리스트 가져오기
	public List<QuestionComment> selectQuestionCommentList(Page page);
	//관리자 추가
	public int insertAdministrator(Manager manager);	
	//답변  상세정보
	public Answer selectAnswerOne(String answerId);
	//답변 행수 가져오기
	public int selectAnswerTotalCount(Page page);
	//답변 리스트 가져오기
	public List<Answer> selectAnswerList(Page page);
	//삭제된 게시글 상세정보
	public QuestionBoard selectWithdrawQuestionBoardOne(String questionId);
	//게시글 상세정보
	public QuestionBoard selectQuestionBoardOne(String questionId);
	//삭제된 게시글 전체행수
	public int selectWithdrawQuestionBoardTotalCount(Page page);
	//삭제된 게시글 가져오기
	public List<QuestionBoard> selectWithdrawQuestionBoardList(Page page);
	//삭제한질문 테이블 옮기고 삭제
	public void deleteQuestionBoard(List<String> list);
	//질문에 해당하는 quesiton_board_img 삭제
	public void deleteQuestionBoardImg(List<String> list);
	//질문에 해당하는 question_comment 삭제
	public void deleteQuestionComment(List<String> list);
	//질문에 해당하는 question_vote 삭제
	public void deleteQuestionVote(List<String> list);
	//질문 지우는조건에 해당하는 answer 삭제 
	public void deleteQuestionBoardAnswer(List<String> list);
	//질문 지우는조건에 해당하는 answer_comment 삭제 
	public void deleteQuestionBoardAnswerComment(List<String> list);
	//질문 지우는조건에 해당하는 answer_vote 삭제
	public void deleteQuestionBoardAnswerVote(List<String> list);
	//Id 값으로 가져온 전체값을 다른 테이블에 저장
	public void insertWithdrawQuestionBoard(List<QuestionBoard> list);
	//질문에 해당되는 답변 Id 값 가져오기
	public List<String> selectQuestionBoardAnswerList(List<String> list);
	//질문Id 값으로 전체값 가져오기(삭제를 위한)
	public List<QuestionBoard> selectQuestionBoardCheckList(List<String> list);
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
	public int InquiryHistoryTotalRow(Page page);
	//신고내역 가져오기
	public List<ReportHistory> selectReportHistoryList(Page page);
	public int selectReportHistoryTotalRow(Page page);
	//문의내역 상세 내용 가져오기
	public InquiryHistory selectInquiryHistoryOne(int inquiryHistoryId);
	//신고내역 상세 내용 가져오기
	public ReportHistory selectReportHistoryOne(int reportHistoryId);
	//신고 대상(질문)상세 정보 가져오기
	public QuestionBoard selectReportQuestionBoardOne(int questionId);
	//신고 대상(답변)상세 정보 가져오기
	public Answer selectReportAnswerOne(int answerId);
	//서비스 카테고리 리스트 가져오기
	public List<ServiceCategory> selectServiceCategoryList();
	//공지사항 리스트
	public List<NoticeBoard> selectNoticeBoard(Page page);
	//공지사항 수
	public int selectNoticeBoardCount(Page page);
	//공지사항 상세보기
	public NoticeBoard noticeBoardOne(int noticeId);
	//공지사항 입력
	public int insertNoticeBoard(NoticeBoard noticeBoard);
	//공지사항 삭제
	public int deleteNoticeBoard(int noticeId);
	//공지사항 리스트 삭제
	public int deleteNoticeBoardList(List<String> noticeBoardIdList);
	//회원리스트
	public List<User> adminSelectUserList(Page page);
	//회원 수
	public int adminSelectUserCount(Page page);
	// 회원 삭제(y->n)
	public int adminDeleteUser(List<String> checkBoxArr);
	// 탈퇴회원리스트
	public List<User> adminSelectWithdrawUserList(Page page);
	// 탈퇴 회원 수
	public int adminSelectWithdrawUserCount(Page page);
	// 회원 복구(n->y)
	public int adminUpdateWithdrawUser(List<String> checkBoxArr);
	// 전문가 회원 리스트
	public List<User> adminSelectExpertUserList(Page page);
	// 전문가 회원 수
	public int adminSelectExpertUserCount(Page page);
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
	// 문의사항 답변 추가시 (N->Y)
	public int updateInquiryHistory(int inquiryHistoryId);
	// FAQ 전체리스트 가져오기
	public List<FaqBoard> selectFaqBoardList(Page page);
	// FAQ 전체 행 값 가져오기
	public int selectFaqBoardTotalCount(Page page);
	// FAQ 추가하기
	public int insertFaqBoard(FaqBoard faqBoard);
	// FAQ 상세정보가져오기
	public FaqBoard selectFaqOne(int faqId);
	// FAQ 삭제하기
	public int deleteFaq(int faqId);
	//FAQ 리스트 삭제
	public int deleteFaqBoardList(List<String> faqBoardIdList);
	// FAQ 수정하기
	public int updateFaq(FaqBoard faqBoard);
	// 관리자 정보 확인
	public Manager selectManagerId(User user);
	// 관리자 전체 리스트 가져오기
	public List<Manager> selectManagerList(Page page);
	// 관리자 테이블 총 행의 수 가져오기
	public int selectManagerTotalCount(Page page);
	// 관리자 삭제하기
	public int deleteManager(String managerId);
	// 관리자 상세보기 정보 가져오기
	public Manager selectManagerOne(String managerId);
}
