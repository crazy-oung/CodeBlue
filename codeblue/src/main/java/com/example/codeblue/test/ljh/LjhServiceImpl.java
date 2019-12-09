package com.example.codeblue.test.ljh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.vo.FaqBoard;

@Service
@Transactional
public class LjhServiceImpl implements LjhService{
	@Autowired LjhMapper ljhMapper;
//	//FAQ 상세정보 가져오기
//	@Override
//	public FaqBoard getFaqOne(int faqId) {
//		System.out.println(":::LjhServiceImpl - getFaqOne:::");
//		return ljhMapper.selectFaqOne(faqId);
//	}
//	//FAQ 삭제하기
//	@Override
//	public int removeFaq(int faqId) {
//		System.out.println(":::LjhServiceImpl - removeFaq:::");
//		return ljhMapper.deleteFaq(faqId);
//	}
//	//FAQ 수정하기
//	@Override
//	public int modifyFaq(FaqBoard faqBoard) {
//		System.out.println(":::LjhServiceImpl - modifyFaq:::");
//		return ljhMapper.updateFaq(faqBoard);
//	}
//	
}