package com.example.codeblue.test.ljh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.vo.AnswerComment;
import com.example.codeblue.vo.QuestionComment;

@Service
@Transactional
public class LjhServiceImpl implements LjhService{
	@Autowired LjhMapper ljhMapper;
	/*
	 * //질문 댓글 추가하기.
	 * 
	 * @Override public int addQeustionComment(QuestionComment questionComment) {
	 * System.out.println("::: LjhServiceImpl - addQeustionComment :::");
	 * ljhMapper.insertQuestionComment(questionComment); return
	 * ljhMapper.selectQuestiocCommentTotal(questionComment.getQuestionBoard().
	 * getQuestionId()); } //질문 답변 댓글 추가하기
	 * 
	 * @Override public int addAnswerComment(AnswerComment answerComment) {
	 * System.out.println("::: LjhServiceImpl - addAnswerComment :::");
	 * System.out.println("answerComment : "+ answerComment.toString()); return
	 * ljhMapper.insertAnswerComment(answerComment); }
	 */



	
	
	
	
	
	
	
	
	
	/*
	//문의사항 답변 저장
	@Override
	public void addInquiryHistoryAnswer(InquiryHistoryAnswer inqruiyHistoryAnswer) {
		System.out.println(":::AdminServiceImpl - addInquiryHistoryAnswer:::");
		int row = ljhMapper.insertInquiryHistoryAnswer(inqruiyHistoryAnswer);
		System.out.println(inqruiyHistoryAnswer.getInquiryHistory().getInquiryHistoryId());
		if(row != 0 ) {
			ljhMapper.updateInquiryHistory(inqruiyHistoryAnswer.getInquiryHistory().getInquiryHistoryId());
		}
	}
	//문의내역 상세페이지 가져오기
	@Override
	public InquiryHistory getInquiryHistoryOne(int inquiryHistoryId) {
		System.out.println("::: AdminServiceImpl - getInquiryHistoryOne :::");
		return ljhMapper.selectInquiryHistoryOne(inquiryHistoryId);
	}
	//문의 내역 리스트 가져오기
		@Override
		public Map<String, Object> getInquiryHistoryList(int currentPage, int rowPerPage) {
			System.out.println("::: AdminServiceImpl - getInquiryHistoryList :::");
			
			Page page = new Page();
			page.setRowPerPage(rowPerPage);
			page.setBeginRow((currentPage-1)*rowPerPage);
			
			int totalRow = ljhMapper.InquiryHistoryTotalRow();
			int lastPage = totalRow/rowPerPage;
			
			if(totalRow % rowPerPage != 0) {
				lastPage ++;
			}
			List<InquiryHistory> list = ljhMapper.selectInquiryHistoryList(page);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("totalRow", totalRow);
			map.put("list", list);
			map.put("currentPage", currentPage);
			map.put("rowPerPage", rowPerPage);
			map.put("lastPage", lastPage);
			System.out.println(map.toString());
			return map;
		}*/
	
}