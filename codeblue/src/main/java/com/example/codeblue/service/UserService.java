package com.example.codeblue.service;

import java.util.List;
import java.util.Map;

import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.AnswerComment;
import com.example.codeblue.vo.Expert;
import com.example.codeblue.vo.Hospital;
import com.example.codeblue.vo.Manager;
import com.example.codeblue.vo.NoticeBoard;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionComment;
import com.example.codeblue.vo.User;

public interface UserService {
	
	public User selectUserOne(String UserId);
	public Map<String,Object> getQuestBoardList(int currentpage,int rowPerPage,String searchWord, int feildId);
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
	
	// 질문 상세페이지 답변 추가
	public int addAnswer(Answer answer);
	// 질문 답변 리스트 가져오기
	public List<Answer> getAnswerList(int questionId);
	// 질문 답변 댓글 리스트 가져오기
	public List<AnswerComment> getAnswerCommentList(int answerId);
}
