package com.example.codeblue.test.hdy;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HdyMapper {
	public int insertTag(String tagName);
}
