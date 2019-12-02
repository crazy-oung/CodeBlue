package com.example.codeblue.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.board.mapper.QuestionBoardMapper;
import com.example.codeblue.board.vo.Page;
import com.example.codeblue.board.vo.QuestionBoard;


@Service
@Transactional
public class QuestionBoardServiceImpl implements QuestionBoardService{
	@Autowired
	private QuestionBoardMapper questionBoardMapper;
	
	@Override
	public Map<String,Object> getQuestBoardList(int currentPage, int rowPerPage,String searchWord) {
		System.out.println("::: QuestionBoardServiceImpl - selectQuestionBoardList :::");
		//페이징객체 생성
		Page page = new Page();
		//페이징 시작값
		int beginRow = (currentPage -1) * rowPerPage;
		//페이징 객체 값을 저장
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setSearchWord(searchWord);
		//질문 리스트 전체 행의 갯수
		int totalCount = questionBoardMapper.selectQuestionBoardTotalCount(page);
		//페이지 마지막값변수선언
		int lastPage = 0;
		//페이지갯수값 저장
		if(totalCount%rowPerPage == 0) {
			lastPage = totalCount/rowPerPage;
		} else {
			lastPage = (totalCount/rowPerPage)+1;
		}
		System.out.println(page.toString());
		// 질문 리스트 저장
		List<QuestionBoard> list = questionBoardMapper.selectQuestionBoardList(page);
		// 각질문에 해당하는 갯수 뽑기
		for(int i=0; i<list.size(); i++) {
			list.get(i).setAnswerCount(questionBoardMapper.selectQuestionBoardAnswerCount(list.get(i)));
			list.get(i).setVoteCount(questionBoardMapper.selectQuestionBoardVotes(list.get(i)));
		}
		System.out.println(list.toString());
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("lastPage", lastPage);
		map.put("currentPage",currentPage);
		map.put("list",list);
		map.put("totalCount",totalCount);
		map.put("searchWord",searchWord);
		return map;
	}
}
