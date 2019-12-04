package com.example.codeblue.service;

import java.util.List;
import java.util.Map;

import org.apache.catalina.Manager;

import com.example.codeblue.vo.Expert;
import com.example.codeblue.vo.NoticeBoard;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionComment;
import com.example.codeblue.vo.User;

public interface UserService {
	
	public User selectUserOne(String UserId);
	public Map<String,Object> getQuestBoardList(int currentpage,int rowPerPage,String searchWord);
	public QuestionBoard getQuestionBoardOne(int questionId);
	public List<QuestionComment> getQuestionCommentList(int questionId);
	public Map<String, Object> getNoticeBoardList(int currentPage, int rowPerPage);
	public NoticeBoard getNoticeBoardOne(int noticeId);
	public int addQuestion(QuestionBoard questionBoard);
	public User verifyUser(User user); 
	public String getUserIdForCheck(User user); 
	public Manager verifyManager(User user);
	public int addUser(User user); 
	public int addExpert(Expert expert); 
	
	public String sendCodeToMail(User user);
	public String resetPassword(User user);
	public int modifyUserPw(User user);
}
