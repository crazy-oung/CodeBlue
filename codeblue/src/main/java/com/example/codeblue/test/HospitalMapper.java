package com.example.codeblue.test;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.vo.Hospital;
import com.example.codeblue.vo.Page;

@Mapper
public interface HospitalMapper {
	
	//병원 리스트 
	public List<Hospital> hospitalList(Page page);
	public int hospitalCount();
}
