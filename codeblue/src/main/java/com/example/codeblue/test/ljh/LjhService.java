package com.example.codeblue.test.ljh;

import com.example.codeblue.vo.HospitalForm;

public interface LjhService {
	//질문 답변 댓글 개수 가져오기
	public int getAnswerCommentCount(int answerId);
	public int addHospital(HospitalForm hospitalForm);
}