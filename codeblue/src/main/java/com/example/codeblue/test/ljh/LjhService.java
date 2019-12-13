package com.example.codeblue.test.ljh;

import java.util.List;

import com.example.codeblue.vo.HospitalForm;

public interface LjhService {
	//질문 답변 댓글 개수 가져오기
	public int getAnswerCommentCount(int answerId);
	public int addHospital(HospitalForm hospitalForm);
	//공지사항 리스트 삭제
	public void removeNoticeBoardList(List<String> noticeBoardIdList);
}