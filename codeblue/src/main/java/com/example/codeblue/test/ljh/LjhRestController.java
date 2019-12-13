package com.example.codeblue.test.ljh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.vo.HospitalForm;



@RestController
public class LjhRestController {
	@Autowired LjhService ljhService;
//	
//	//체크박스로 선택한 questionId 배열 가져오기
//	@PostMapping("/rest/admin/removeNoticeBoardList")
//	public String removeNoticeBoardList(@RequestParam(value="checkBoxArr")List<String> noticeBoardIdList) {
//		System.out.println("::: post - removeNoticeBoardList :::");
//		System.out.println(noticeBoardIdList.toString());
//		ljhService.removeNoticeBoardList(noticeBoardIdList);
//		return "삭제성공";
//	}
	
//	//병원 이미지 업로드
//	@PostMapping("/rest/admin/hospitalAdd")
//	public int addHospitalTest(HospitalForm hospitalForm) {
//		System.out.println("::: post - addHospitalTest :::");
//		System.out.println("hOSPITALfORM : " + hospitalForm);
//		return ljhService.addHospital(hospitalForm);
//	}
	//질문 답변 댓글 수 가져오기
//	@PostMapping("/rest/getAnswerCommentCount")
//	public int getAnswerCommentCount(int answerId) {
//		System.out.println("::: post - getAnswerCommentCount :::");
//		return ljhService.getAnswerCommentCount(answerId);
//	}
}