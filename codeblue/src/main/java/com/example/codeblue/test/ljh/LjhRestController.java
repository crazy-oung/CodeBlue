package com.example.codeblue.test.ljh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.vo.HospitalForm;



@RestController
public class LjhRestController {
	@Autowired LjhService ljhService;
	//병원 이미지 업로드
	@PostMapping("/rest/admin/hospitalAdd")
	public int addHospitalTest(HospitalForm hospitalForm) {
		System.out.println("::: post - addHospitalTest :::");
		System.out.println("hOSPITALfORM : " + hospitalForm);
		return ljhService.addHospital(hospitalForm);
	}
	//질문 답변 댓글 수 가져오기
//	@PostMapping("/rest/getAnswerCommentCount")
//	public int getAnswerCommentCount(int answerId) {
//		System.out.println("::: post - getAnswerCommentCount :::");
//		return ljhService.getAnswerCommentCount(answerId);
//	}
}