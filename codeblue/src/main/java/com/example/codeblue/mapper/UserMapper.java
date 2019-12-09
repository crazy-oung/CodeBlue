package com.example.codeblue.mapper;

import java.util.List;

import org.apache.catalina.Manager;
import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.vo.Expert;
import com.example.codeblue.vo.Hospital;
import com.example.codeblue.vo.NoticeBoard;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionComment;
import com.example.codeblue.vo.Tag;
import com.example.codeblue.vo.User;

@Mapper
public interface UserMapper {
	public User selectUserOne(String UserId);
	// 유저 로그인
	public User selectUserId(User user);
	public User selectUserIdForCheck(User user);
	// 관리자 로그인
	public Manager selectManagerId(User user);
	
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
	public int selectQuestionBoardVotes(QuestionBoard questionBoard);
	public int selectQuestionBoardAnswerCount(QuestionBoard questionBoard);
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
}
