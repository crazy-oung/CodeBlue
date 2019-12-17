package com.example.codeblue.test.jjw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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

@org.springframework.stereotype.Service
@Transactional
public class JJWServiceImpl implements JJWService{
	@Autowired 
	private JJWMapper jjwMapper;
	
	//문의 답변 가져오기
	@Override
	public InquiryHistoryAnswer getInquiryHistoryAnswerOne(int inquiryHistoryId) {
		System.out.println("::: AdminServiceImpl - getInquiryHistoryOne :::");
		return jjwMapper.selectInquiryHistoryAnswerOne(inquiryHistoryId);
	}
	//문의 상세내용
	@Override
	public InquiryHistory getInquiryHistoryOne(int inquiryHistoryId) {
		System.out.println("::: AdminServiceImpl - getInquiryHistoryOne :::");
		return jjwMapper.selectInquiryHistoryOne(inquiryHistoryId);
	}
	//문의 저장
	@Override
	public void addInquiryHistory(InquiryHistory inquiryHistory) {
		System.out.println("::: AdminServiceImpl - addReport :::");
		jjwMapper.insertInquiryHistory(inquiryHistory);
		
	}
	
	//문의 카테고리
	@Override
	public List<Inquiry> getInquiryList() {
		System.out.println("::: AdminServiceImpl - getInquiryList :::");
		return jjwMapper.selectInquiry();
	}
	//신고 저장
	@Override
	public void addReportHistory(ReportHistory reportHistory) {
		System.out.println("::: AdminServiceImpl - addReport :::");
		jjwMapper.insertReportHistory(reportHistory);
	}
	//신고창 카테고리
	@Override
	public List<Report> getReportList() {
		System.out.println("::: AdminServiceImpl - getReportList :::");
		return jjwMapper.selectReport();
	}
	//질문 등록
	@Override
	public int addQuestion(QuestionBoard questionBoard) {
		System.out.println("::: AskServiceImpl - addQuestion :::");
		return jjwMapper.insertQuestion(questionBoard);
	}
	
	
	//답변 댓글 지우기
	@Override
	public void removeAnswerCommentList(List<String> answerCommentIdList) {
		System.out.println("::: AdminBoardServiceImpl - removeAnswerCommentList :::");
		System.out.println(answerCommentIdList.toString());
		//댓글 지우기
		jjwMapper.deleteAnswerCommentId(answerCommentIdList);
		System.out.println("답변 댓글 지우기 성공");
	}
	//답변 댓글 리스트 가져오기
	@Override
	public Map<String, Object> getAnswerCommentList(Page page, int currentPage) {
		System.out.println("::: AdminBoardServiceImpl - getAnswerCommentList :::");
		
		//시작값 정하기
		int beginRow = (currentPage -1) * page.getRowPerPage();
		page.setBeginRow(beginRow);
		System.out.println(page.toString());
		//질문 리스트 전체 행의 갯수
		int totalCount = jjwMapper.selectAnswerCommentTotalCount(page);
		System.out.println("totalCount : "+totalCount);
		//페이지 마지막값변수선언
		int lastPage = 1;
		//페이지갯수값 저장
		if(totalCount%page.getRowPerPage() == 0) {
			lastPage = totalCount/page.getRowPerPage();
		} else {
			lastPage = (totalCount/page.getRowPerPage())+1;
		}
		System.out.println("lastPage : "+lastPage);
		// 질문 리스트 저장
		List<AnswerComment> list = jjwMapper.selectAnswerCommentList(page);
		System.out.println(list.toString());
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("lastPage", lastPage);
		map.put("currentPage",currentPage);
		map.put("list",list);
		map.put("totalCount",totalCount);
		map.put("searchWord",page.getSearchWord());
		return map;
	}
	//질문 댓글 삭제하기
	@Override
	public void removeQuestionCommentList(List<String> questionCommentIdList) {
		System.out.println("::: AdminBoardServiceImpl - removeQuestionComment :::");
		System.out.println(questionCommentIdList.toString());
		//댓글 지우기
		jjwMapper.deleteQuestionCommentId(questionCommentIdList);
		System.out.println("질문 댓글 지우기 성공");
	}
	//질문 댓글 리스트 가져오기
	@Override
	public Map<String, Object> getQuestionCommentList(Page page, int currentPage) {
		System.out.println("::: AdminBoardServiceImpl - getQuestionCommentList :::");
		
		//시작값 정하기
		int beginRow = (currentPage -1) * page.getRowPerPage();
		page.setBeginRow(beginRow);
		System.out.println(page.toString());
		//질문 리스트 전체 행의 갯수
		int totalCount = jjwMapper.selectQuestionCommentTotalCount(page);
		System.out.println("totalCount : "+totalCount);
		//페이지 마지막값변수선언
		int lastPage = 1;
		//페이지갯수값 저장
		if(totalCount%page.getRowPerPage() == 0) {
			lastPage = totalCount/page.getRowPerPage();
		} else {
			lastPage = (totalCount/page.getRowPerPage())+1;
		}
		System.out.println("lastPage : "+lastPage);
		// 질문 리스트 저장
		List<QuestionComment> list = jjwMapper.selectQuestionCommentList(page);
		System.out.println(list.toString());
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("lastPage", lastPage);
		map.put("currentPage",currentPage);
		map.put("list",list);
		map.put("totalCount",totalCount);
		map.put("searchWord",page.getSearchWord());
		return map;
	}
	//답변 상세정보
	@Override
	public Answer getAnswerOne(String answerId) {
		System.out.println("::: AdminBoardServiceImpl - getAnswerOne :::");
		return jjwMapper.selectAnswerOne(answerId);
	}
	
	//답변 지우기
	@Override
	public void removeAnswerList(List<String> answerIdList) {
		System.out.println("::: AdminBoardServiceImpl - removeAnswerList :::");
		System.out.println(answerIdList.toString());
		// 1번째로 답변의 추천수 지우기
		jjwMapper.deleteQuestionBoardAnswerVote(answerIdList);
		System.out.println("답변의 추천수지우기성공");
		// 2번째로 답변에 해당하는 댓글 지우기
		jjwMapper.deleteQuestionBoardAnswerComment(answerIdList);
		System.out.println("답변의 댓글지우기성공");
		// 3번째로 질문에 해당하는 답변 지우기
		jjwMapper.deleteQuestionBoardAnswer(answerIdList);
		System.out.println("답변 지우기 성공");
	}
	
	//답변 리스트 가져오기
	@Override
	public Map<String, Object> getAnswerList(Page page, int currentPage) {
		System.out.println("::: AdminBoardServiceImpl - getAnswerList :::");
		
		//시작값 정하기
		int beginRow = (currentPage -1) * page.getRowPerPage();
		page.setBeginRow(beginRow);
		System.out.println(page.toString());
		//질문 리스트 전체 행의 갯수
		int totalCount = jjwMapper.selectAnswerTotalCount(page);
		System.out.println("totalCount : "+totalCount);
		//페이지 마지막값변수선언
		int lastPage = 1;
		//페이지갯수값 저장
		if(totalCount%page.getRowPerPage() == 0) {
			lastPage = totalCount/page.getRowPerPage();
		} else {
			lastPage = (totalCount/page.getRowPerPage())+1;
		}
		System.out.println("lastPage : "+lastPage);
		// 질문 리스트 저장
		List<Answer> list = jjwMapper.selectAnswerList(page);
		System.out.println(list.toString());
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("lastPage", lastPage);
		map.put("currentPage",currentPage);
		map.put("list",list);
		map.put("totalCount",totalCount);
		map.put("searchWord",page.getSearchWord());
		return map;
	}
	//삭제된 게시글 상세정보
	@Override
	public QuestionBoard getWithdrawQuestionBoardOne(String questionId) {
		System.out.println("::: AdminBoardServiceImpl - getWithdrawQuestionBoardOne :::");
		return jjwMapper.selectWithdrawQuestionBoardOne(questionId);
	}
	//게시글 상세정보
	@Override
	public QuestionBoard getQuestionBoardOne(String questionId) {
		System.out.println("::: AdminBoardServiceImpl - getQuestionBoardOne :::");
		return jjwMapper.selectQuestionBoardOne(questionId);
	}
	
	//삭제된 게시글 가져오기
	@Override
	public Map<String,Object> getWithdrawQuestionBoardList(Page page,int currentPage) {
		System.out.println("::: AdminBoardServiceImpl - getWithdrawQuestionBoardList :::");
		
		//시작값 정하기
		int beginRow = (currentPage -1) * page.getRowPerPage();
		page.setBeginRow(beginRow);
		System.out.println(page.toString());
		//질문 리스트 전체 행의 갯수
		int totalCount = jjwMapper.selectWithdrawQuestionBoardTotalCount(page);
		System.out.println("totalCount : "+totalCount);
		//페이지 마지막값변수선언
		int lastPage = 1;
		//페이지갯수값 저장
		if(totalCount%page.getRowPerPage() == 0) {
			lastPage = totalCount/page.getRowPerPage();
		} else {
			lastPage = (totalCount/page.getRowPerPage())+1;
		}
		System.out.println("lastPage : "+lastPage);
		// 질문 리스트 저장
		List<QuestionBoard> list = jjwMapper.selectWithdrawQuestionBoardList(page);
		System.out.println(list.toString());
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("lastPage", lastPage);
		map.put("currentPage",currentPage);
		map.put("list",list);
		map.put("totalCount",totalCount);
		map.put("searchWord",page.getSearchWord());
		return map;
	}
	
	@Override
	public void removeQeustionBoardList(List<String> questionBoardIdList) {
		System.out.println("::: AdminBoardServiceImpl - removeQeustionBoardList :::");
		//질문 상세한정보 가져오기
		List<QuestionBoard> questionBoardList = jjwMapper.selectQuestionBoardCheckList(questionBoardIdList);
		System.out.println(questionBoardList.toString());
		//질문에 해당하는 답변 id 값 가져오기
		List<String> answerIdList = jjwMapper.selectQuestionBoardAnswerList(questionBoardIdList);
		System.out.println(answerIdList.toString());
		System.out.println(questionBoardIdList.toString());
		// 맨처음으로 질문을 삭제된 질문테이블로 저장
		jjwMapper.insertWithdrawQuestionBoard(questionBoardList);
		if(answerIdList.size() != 0) { //답변이 있을시 반응한다.
			// 1번째로 답변의 추천수 지우기
			jjwMapper.deleteQuestionBoardAnswerVote(answerIdList);
			System.out.println("답변의 추천수지우기성공");
			// 2번째로 답변에 해당하는 댓글 지우기
			jjwMapper.deleteQuestionBoardAnswerComment(answerIdList);
			System.out.println("답변의 댓글지우기성공");
			// 3번째로 질문에 해당하는 답변 지우기
			jjwMapper.deleteQuestionBoardAnswer(answerIdList);
			System.out.println("답변 지우기 성공");
		}
		// 4번째로 질문에 해당되는 추천수 지우기
		jjwMapper.deleteQuestionVote(questionBoardIdList);
		System.out.println("질문 추천수 지우기 성공");
		// 5번째로 질문에 해당되는 댓글 지우기
		jjwMapper.deleteQuestionComment(questionBoardIdList);
		System.out.println("질문 댓글 지우기 성공");
		// 6번째로 질문에 해당되는 이미지 지우기
		jjwMapper.deleteQuestionBoardImg(questionBoardIdList);
		System.out.println("질문 이미지 지우기 성공");
		// 7번째로 질문테이블에서 지운다.
		jjwMapper.deleteQuestionBoard(questionBoardIdList);
		System.out.println("질문 지우기 성공");
	}
	
//	@Override
//	public List<Feild> getFeildList() {
//		System.out.println("::: AdminBoardServiceImpl - getAdminFeildList :::");
//		return jjwMapper.selectFeildList();
//	}
//	
	@Override
	public Map<String,Object> getQuestionBoardList(Page page,int currentPage) {
		System.out.println("::: AdminBoardServiceImpl - getAdminBoardList :::");
		
		//시작값 정하기
		int beginRow = (currentPage -1) * page.getRowPerPage();
		page.setBeginRow(beginRow);
		System.out.println(page.toString());
		//질문 리스트 전체 행의 갯수
		int totalCount = jjwMapper.selectQuestionBoardTotalCount(page);
		System.out.println("totalCount : "+totalCount);
		//페이지 마지막값변수선언
		int lastPage = 1;
		//페이지갯수값 저장
		if(totalCount%page.getRowPerPage() == 0) {
			lastPage = totalCount/page.getRowPerPage();
		} else {
			lastPage = (totalCount/page.getRowPerPage())+1;
		}
		System.out.println("lastPage : "+lastPage);
		// 질문 리스트 저장
		List<QuestionBoard> list = jjwMapper.selectQuestionBoardList(page);
		System.out.println(list.toString());
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("lastPage", lastPage);
		map.put("currentPage",currentPage);
		map.put("list",list);
		map.put("totalCount",totalCount);
		map.put("searchWord",page.getSearchWord());
		return map;
	}
}
