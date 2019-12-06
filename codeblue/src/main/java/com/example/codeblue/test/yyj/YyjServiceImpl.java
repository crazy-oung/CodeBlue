package com.example.codeblue.test.yyj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class YyjServiceImpl implements YyjService{
	@Autowired YyjMapper mapper;
	
	@Override
	public int removeNoticeBoardTest(int noticeId) {
		System.out.println(":::ServiceImpl - removeNoticeBoardTest:::");
		System.out.println("notice Id : " + noticeId);
		
		return mapper.deleteNoticeBoardTest(noticeId);
	}
}
