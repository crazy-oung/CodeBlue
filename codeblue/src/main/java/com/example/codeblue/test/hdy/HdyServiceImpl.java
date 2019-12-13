package com.example.codeblue.test.hdy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.vo.Tag;

@Transactional
@Service
public class HdyServiceImpl implements HdyService{
//	@Autowired HdyMapper hdyMapper;

	@Override
	public int addTag(Tag tag) {
		System.out.println("::: HdyServiceImpl - addTag :::");
		System.out.println(tag);
		List<String> tags = new ArrayList<String>();
		
//		hdyMapper.insertTag(tag);
		return 0;
	}
	
	
}
