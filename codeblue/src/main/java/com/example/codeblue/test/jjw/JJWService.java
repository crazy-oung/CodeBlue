package com.example.codeblue.test.jjw;

import java.util.List;
import java.util.Map;

import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.Feild;
import com.example.codeblue.vo.Inquiry;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.InquiryHistoryAnswer;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.Report;
import com.example.codeblue.vo.ReportHistory;


public interface JJWService {
	
	
	//문의 답변 가져오기
	public InquiryHistoryAnswer getInquiryHistoryAnswerOne(int inquiryHistoryId);
	//문의 상세내용 가져오기
	public InquiryHistory getInquiryHistoryOne(int inquiryHistoryId);
	//문의 사항 저장하기
	public void addInquiryHistory(InquiryHistory inquiryHistory);
	//문의내역 카테고리가져오기
	public List<Inquiry> getInquiryList();
	//신고내역 저장하기
	public void addReportHistory(ReportHistory reportHistory);
	//신고창 카테고리
	public List<Report> getReportList();
	//질문 등록
	public int addQuestion(QuestionBoard questionBoard);
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
	public void removeQeustionBoardList(List<String> questionBoardIdList);
//	public List<Feild> getFeildList();
	public Map<String,Object> getQuestionBoardList(Page page,int currentPage);
}
