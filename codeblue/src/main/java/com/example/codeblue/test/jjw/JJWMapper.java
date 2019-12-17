package com.example.codeblue.test.jjw;

import java.util.List;

import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.AnswerComment;
import com.example.codeblue.vo.Feild;
import com.example.codeblue.vo.Inquiry;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.InquiryHistoryAnswer;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionComment;
import com.example.codeblue.vo.Report;
import com.example.codeblue.vo.ReportHistory;

@org.apache.ibatis.annotations.Mapper
public interface JJWMapper {
	
	//문의 답변 가져오기
	public InquiryHistoryAnswer selectInquiryHistoryAnswerOne(int inquiryHistoryId);
	//문의 상세내용가져오기
	public InquiryHistory selectInquiryHistoryOne(int inquiryHistoryId);
	//문의 사항 저장하기
	public void insertInquiryHistory(InquiryHistory inquiryHistory);
	//문의 카테고리가져오기
	public List<Inquiry> selectInquiry();
	// 신고내역 저장하기
	public void insertReportHistory(ReportHistory reportHistory);
	// 신고카테고리
	public List<Report> selectReport();
	// 질문 등록
	public int insertQuestion(QuestionBoard questionBoard);
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
	public List<Feild> selectFeildList();
	public int selectQuestionBoardTotalCount(Page page);
	public List<QuestionBoard> selectQuestionBoardList(Page page);
}
