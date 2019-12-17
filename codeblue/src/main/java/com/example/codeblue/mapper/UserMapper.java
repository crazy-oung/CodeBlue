package com.example.codeblue.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.AnswerComment;
import com.example.codeblue.vo.AnswerVote;
import com.example.codeblue.vo.Expert;
import com.example.codeblue.vo.FaqBoard;
import com.example.codeblue.vo.Hospital;
import com.example.codeblue.vo.Inquiry;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.InquiryHistoryAnswer;
import com.example.codeblue.vo.Manager;
import com.example.codeblue.vo.NoticeBoard;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionComment;
import com.example.codeblue.vo.QuestionVote;
import com.example.codeblue.vo.Report;
import com.example.codeblue.vo.ReportHistory;
import com.example.codeblue.vo.ServiceCategory;
import com.example.codeblue.vo.Tag;
import com.example.codeblue.vo.User;

@Mapper
public interface UserMapper {
	// 태그 리스트 출력
	public List<Map> selectTagList(Page page);
	// 태그 전체 행 수 
	public int selectTagTotalRow();
	
	//유저 질문 리스트(페이징)
	public List<QuestionBoard> selectQuestionPaging(Page page);
	//유저 질문수(해당유저)
	public int selectQuestionBoardCount(String userId);
	//유저 질문 차트
	public List<QuestionBoard> selectQuestionChart(String userId);
	
	//유저 댓글 수(해당유저)
	public int selectQuestionUserCommentCount(String userId);
	//유저 댓글 리스트(페이징)
	public List<QuestionComment> selectCommentPaging(Page page);	

	//유저 답글 리스트(페이징)
	public List<Answer> selectQuestionAnswerPaging(Page page);
	//유저 답글 리스트 수
	public int selectAnswerCount(String userId);
	//유저 답변 차트
	public List<Answer> selectAnswerChart(String userId);
	
	//유저 질문 글 추천 수 
	public int selectUserVote(String userId);
	//유저 질문 글 추천기능
	public int insertQuestionVote(QuestionVote questionVote);
	//유저 질문 추천 중복검사
	public QuestionVote selectQuestionVoteCheck(QuestionVote questionVote);
	
	//유저 답변 추천기능
	public int insertAnswerVote(AnswerVote answerVote);
	//유저 답변 추천 중복검사
	public AnswerVote selectAnswerVoteCheck(AnswerVote answerVote);

	//유저가 사용한 태그리스트(페이징)
	public List<Tag> selectUserTagPaging(Page page);
	//유저가 사용한 태그 수
	public int selectUserTagTotalRow(String userId);
	//질문글 수정
	public int updateQuestion(QuestionBoard questionBoard);
	
	///-----------------
	
	//답변  상세정보
	public Answer selectAnswerOne(String answerId);
	// 신고내역 저장하기
	public void insertReportHistory(ReportHistory reportHistory);
	// 신고카테고리
	public List<Report> selectReport();
	//태그 등록
	public int insertTag(Map map);
	//방금 등록한 질문
	public int selectLastInsertQuestionId();
	
	public User selectUserOne(String UserId);
	// 유저 로그인
	public User selectUserId(User user);
	public User selectUserIdForCheck(User user);
	// 관리자 로그인
	public Manager selectManagerId(User user);
	
	//유저 이름, 비밀번호 변경
	public void updateUserProfile(User user);
	
	//회원가입
	public int insertUser(User user);
	
	// 전문가 추가
	public int insertExpert(Expert expert);
	 
	// 비밀번호 변경
	public int updateUserPw(User user);
	
	// 질문 등록
	public int insertQuestion(QuestionBoard questionBoard);
	
	public List<NoticeBoard> selectNoticeBoardList(Page page);
	public NoticeBoard selectNoticeBoardOne(int noticeId);
	public int noticeBoardTotalRow();
	
	public int selectQuestionCommentCount(int questionId);
	public int selectQuestionBoardTotalCount(Page page);
	public List<QuestionBoard> selectQuestionBoardList(Page page);
	public QuestionBoard selectQuestionBoardOne(int questionId);
	public List<QuestionComment> selectQuestionCommentList(int questionId);
	
	//병원 리스트 
	public List<Hospital> hospitalList(Page page);
	//병원 수
	public int hospitalCount();
	//병원 상세정보 
	public List<Hospital> hospitalOne(int hospitalId);
	
	//최신순 
	public List<Tag> selectTagListDate(Page page);
	//인기순
	public List<Tag> selectTagListPopular(Page page);
	//이름순
	public List<Tag> selectTagListName(Page page);
	
	//질문 답변글 추가 
	public int insertAnswer(Answer answer);
	// 질문 답변글 리스트 가져오기
	public List<Answer> selectAnswerList(int questionId);
	//질문 답변 댓글 리스트 가져오기
	public List<AnswerComment> selectAnswerCommentList(int answerId);
	//질문 답변 개수 가져오기
	public int selectAnswerCommentCount(int answerId);
	//질문 댓글 토탈행
	public int selectQuestionCommentTotal(int questionId);
	//질문 댓글 추가
	public int insertQuestionComment(QuestionComment questionComment);
	//질문 답변 댓글 추가
	public int insertAnswerComment(AnswerComment answerComment);
	// 유저 유저조회
	public List<User> selectUserList(Page Page);
	// 유저 유저 수
	public int selectUserCount(Page Page);
	// serviceCategory 조회
	public List<ServiceCategory> selectServiceCategoryList();
	// faq 조회
	public List<FaqBoard> selectFaqList(Page page);
	// faq 총 수
	public int selectFaqCount(Page page);
	// faqone 출력 (이전글,다음글까지 출력)
	public List<FaqBoard> selectFaqOne(int faqId);
	//문의 답변 가져오기
	public InquiryHistoryAnswer selectInquiryHistoryAnswerOne(int inquiryHistoryId);
	//문의 상세내용가져오기
	public InquiryHistory selectInquiryHistoryOne(int inquiryHistoryId);
	//문의 사항 저장하기
	public void insertInquiryHistory(InquiryHistory inquiryHistory);
	// inquiry 카테고리 조회
	public List<Inquiry> selectInquiry();
	// 문의 내역 리스트  출력
	public List<InquiryHistory> selectInquiryHistory(Page page);
	// 문의 내역 리스트 행의 수
	public int selectInquiryHistoryCount(Page page);
}
