package com.example.codeblue.test.hdy;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.vo.Page;

@Transactional
@Service
public class HdyServiceImpl implements HdyService{
	@Autowired HdyMapper hdyMapper;

	@Override
	public List<Map> getTagList(Page page) {
		System.out.println("::: HdyServiceImpl - getTagList :::");
		System.out.println(page);
		List<Map> map = hdyMapper.selectTagList(page);
		return map;
	}

	@Override
	public int getTagTotalRow() {
		System.out.println("::: HdyServiceImpl - getTagTotalRow :::");
		return hdyMapper.selectTagTotalRow();
	}
	
	
}
