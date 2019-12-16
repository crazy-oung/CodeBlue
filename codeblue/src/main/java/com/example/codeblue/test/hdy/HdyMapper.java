package com.example.codeblue.test.hdy;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.vo.Page;

@Mapper
public interface HdyMapper {
	public List<Map> selectTagList(Page page);
	public int selectTagTotalRow();
	
}
