package com.example.codeblue.test.Lee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionComment;
import com.example.codeblue.vo.User;


@Transactional
@Service
public class LeeServiceImp implements LeeService{
	@Autowired LeeMapper leeMapper;
	
	//해당 유저정보 
	@Override
	public User getUserOne(String userId) {
		System.out.println(":::UserServiceImp - getUserOne:::");
		
		return leeMapper.selectUserOne(userId);
	}
	//해당 유저 질문 리스트 가져오기
	@Override
	public List<QuestionBoard> getQuestionBoard(String userId) {
		System.out.println(":::UserServiceImp - getQuestionBoard:::");
		System.out.println("userId : "+userId);
		System.out.println(leeMapper.selectQuestionBoardList(userId));
		List<QuestionBoard> list = leeMapper.selectQuestionBoardList(userId);
		System.out.println(list.toString());
		System.out.println(userId);
		return leeMapper.selectQuestionBoardList(userId);
	}
	
	//유저 질문 수 
	@Override
	public int questionBoardCount(String userId) {
		System.out.println(":::UserServiceImp - questionBoardCount:::");
		System.out.println("userId"+userId);
		return leeMapper.selectQuestionBoardCount(userId);
	}
	
	//해당 유저 질문수 차트
	@Override
	public List<QuestionBoard> getQuestionChart(String userId) {
		System.out.println("::::UserServiceImp - getQuestionChart");
		System.out.println("userId"+userId);
		return leeMapper.selectQuestionChart(userId);
	}
	
	//해당유저 질문수 리스트(페이징)
	@Override
	public Map<String, Object> getQuestionBoardPaging(int currentPage, int rowPerPage, String userId) {
		System.out.println(":::UserServiceImp - getQuestionBoardPaging");
		System.out.println("currentPage :"+currentPage +"/rowPerPage :"+rowPerPage);
		
		rowPerPage =10;
		
		Page page = new Page();
		
		int beginRow = (currentPage-1)*rowPerPage;
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setUserId(userId);
		
		System.out.println(page.toString());
		
		int totalRow = leeMapper.selectQuestionBoardCount(userId);
		int lastPage = totalRow/rowPerPage;
		
		if( totalRow%rowPerPage==0) {
			lastPage = totalRow/rowPerPage;
		}else {
			lastPage = (totalRow/rowPerPage)+1;
		}
		
		List<QuestionBoard> list = leeMapper.selectQuestionPaging(page);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("lastPage",lastPage);
		map.put("list", list);
		map.put("beginRow", beginRow);
		
		return map;
	}
	
	//해당유저 댓글 리스트(페이징)
	@Override
	public Map<String, Object> getCommentBoardPaging(int currentPage, int rowPerPage, String userId) {
		System.out.println(":::UserServiceImp - getCommentBoardPaging:::");
		System.out.println("currentPage : "+currentPage +"/rowPerPage :"+rowPerPage+"/userId:"+userId);
		
		rowPerPage =10;
		
		Page page = new Page();
		
		int beginRow = (currentPage-1)*rowPerPage;
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setUserId(userId);
		
		System.out.println(page.toString());
		
		int totalRow = leeMapper.selectQuestionCommentCount(userId);
		int lastPage = totalRow/rowPerPage;
		
		if( totalRow%rowPerPage==0) {
			lastPage = totalRow/rowPerPage;
		}else {
			lastPage = (totalRow/rowPerPage)+1;
		}
		
		List<QuestionComment> list = leeMapper.selectCommentPaging(page);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("lastPage",lastPage);
		map.put("list", list);
		map.put("beginRow", beginRow);
		return map;
	}	
	
	//해당 유저 댓글 리스트 가져오기
	@Override
	public List<QuestionComment> getQuestionComment(String userId) {
		System.out.println(":::UserServiceImp - getQuestionComment:::");
		System.out.println("userId"+userId);
		System.out.println(leeMapper.selectQuestionCommentList(userId));
		return leeMapper.selectQuestionCommentList(userId);
	}
	
	//해당유저 댓글 수
	@Override
	public int questionCommentCount(String userId) {
		System.out.println(":::UserServiceImp - selectCommentCount");
		System.out.println("userId"+userId);
		return leeMapper.selectQuestionCommentCount(userId);
	}
	
	//해당유저 댓글 수 차트
	@Override
	public List<QuestionComment> getCommentChart(String userId) {
		System.out.println(":::UserServiceImp - selectCommentChart");
		System.out.println("userId"+userId);
		return leeMapper.selectCommentChart(userId);
	}
	
	//해당유저 답글 리스트
	@Override
	public List<Answer> getQuestionAnswer(String userId) {
		System.out.println(":::UserServiceImp - getQuestionAnswer");
		System.out.println("userId"+userId);
		return leeMapper.selectQuestionAnswerList(userId);
	}
	
	//해당유저 답글 리스트(페이징)
	@Override
	public Map<String, Object> getAnswerPaging(int currentPage, int rowPerPage, String userId) {
		System.out.println(":::UserServiceImp - getAnswerPaging:::");
		System.out.println("currentPage : "+currentPage +"/rowPerPage :"+rowPerPage+"/userId:"+userId);
		
		rowPerPage =10;
		
		Page page = new Page();
		
		int beginRow = (currentPage-1)*rowPerPage;
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setUserId(userId);
		
		System.out.println(page.toString());
		
		int totalRow = leeMapper.selectAnswerCount(userId);
		int lastPage = totalRow/rowPerPage;
		
		if( totalRow%rowPerPage == 0) {
			lastPage = totalRow/rowPerPage;
		}else {
			lastPage = (totalRow/rowPerPage)+1;
		}
		
		List<Answer> list = leeMapper.selectQuestionAnswerPaging(page);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("lastPage",lastPage);
		map.put("list", list);
		map.put("beginRow", beginRow);
		return map;
	}
		
}
