package com.example.codeblue.service;

import java.util.List;
import java.util.Map;

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
import com.example.codeblue.vo.User;

public interface UserService {
	
	// 태그 리스트 출력
	public List<Map> getTagList(Page page);
	// 태그 전체 행 수
	public int getTagTotalRow();
	
	//유저 상세 프로필
	public User getUserOne(String userId);
	
	//해당 유저 질문 리스트 (페이징)
	public Map<String, Object> getQuestionBoardPaging(int currentPage, int rowPerPage, String userId);
	//해당 유저 질문 수
	public int questionBoardCount(String userId);
	//해당 유저 질문 수 차트
	public List<QuestionBoard> getQuestionChart(String userId);

	//해당 유저 댓글 수
	public int questionCommentCount(String userId);
	//해당 유저 댓글 리스트(페이징)
	public Map<String, Object> getCommentBoardPaging(int currentPage, int rowPerPage, String userId);

	//해당 유저 답글 리스트(페이징)
	public Map<String, Object> getAnswerPaging(int currentPage, int rowPerPage, String userId);
	//해당 유저 답글 수
	public int answerCount(String userId);
	//해당 유저 답글 수 차트
	public List<Answer> getAnswerChart(String userId);
	
	//해당 유저 질문 글 추천 수
	public int getUserVote(String userId);
	//유저 질문 중복 검사
	public int getQuestionVoteCheck(QuestionVote questionVote);
	
	//유저 질문 중복 검사
	public int getAnswerVoteCheck(AnswerVote answerVote);

	//유저가 사용한 태그리스트(페이징)
	public Map<String, Object> getUserTagPaging(int currentPage, int rowPerPage, String userId);
	//유저가 사용한 태그리스트 수
	public int getUserTagCount(String userId);
	
	//질문글 수정
	public int modifyQuestion(QuestionBoard questionBoard);
	
	//-----------test
	
	//답변 상세정보 가져오기
	public Answer getAnswerOne(String answerId);
	//신고내역 저장하기
	public void addReportHistory(ReportHistory reportHistory);
	//신고창 카테고리
	public List<Report> getReportList();
	// 방금 등록한 질문 번호 가져오기
	public int getLastQuestionId();
	// 태그 등록
	public int addTag(String tags,int questionId);
	
	public User selectUserOne(String UserId);
	public Map<String,Object> getQuestBoardList(int currentpage,int rowPerPage,String searchWord,String searchCategory, int feildId);
	public QuestionBoard getQuestionBoardOne(int questionId);
	public List<QuestionComment> getQuestionCommentList(int questionId);
	public Map<String, Object> getNoticeBoardList(int currentPage, int rowPerPage);
	public NoticeBoard getNoticeBoardOne(int noticeId);
	public int addQuestion(QuestionBoard questionBoard);
	public User verifyUser(User user); 
	public String getUserIdForCheck(User user); 
	public int addUser(User user); 
	public int addExpert(Expert expert); 
	
	//제휴병원 리스트
	public Map<String, Object> getHospitalList(int currentPage, int rowPerPage, String searchWord);
	public List<Hospital> getHospitalOne(int hospitalId);
	
	public String sendCodeToMail(User user);
	public String resetPassword(User user);
	public int modifyUserPw(User user);
	
	//유저 이름, 비밀번호 변경
	public void modifyUserProfile(User user);
	
	// 질문 상세페이지 답변 추가
	public int addAnswer(Answer answer);
	// 질문 답변 리스트 가져오기
	public List<Answer> getAnswerList(int questionId);
	// 질문 답변 댓글 리스트 가져오기
	public List<AnswerComment> getAnswerCommentList(int answerId);
	//질문 답변 댓글 개수 가져오기
	public int getAnswerCommentCount(int answerId);
	// 질문 댓글 추가하기.
	public int addQeustionComment(QuestionComment questionComment);
	// 질문 답변의 댓글 추가하기
	public int addAnswerComment(AnswerComment answerComment);
	// 유저조회
	public Map<String,Object> getUserList(int currentPage, int rowPerPage, String searchWord);
	// serviceCategory 조회
	public List<ServiceCategory> getServiceCategoryList();
	// faq 조회
	public Map<String,Object> getFaqList(int currentPage, int rowPerPage, String searchCategory);
	// faqone 출력 (이전글,다음글까지 출력)
	public List<FaqBoard> getFaqOne(int faqId);
	//문의 답변 가져오기
	public InquiryHistoryAnswer getInquiryHistoryAnswerOne(int inquiryHistoryId);
	//문의 상세내용 가져오기
	public InquiryHistory getInquiryHistoryOne(int inquiryHistoryId);
	//문의 사항 저장하기
	public void addInquiryHistory(InquiryHistory inquiryHistory);
	// inquiry 출력
	public List<Inquiry> getInquiryList();
	// inquiry 히스토리출력(자신이 올린 글만)
	public Map<String,Object> getInquiryHistoryBoard(int currentPage, int rowPerPage, String loginUserId, String searchCategory);
}
