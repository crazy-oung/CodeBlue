package com.example.codeblue.mapper;

import java.util.List;

import javax.swing.plaf.synth.Region;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.vo.Feild;

@Mapper
public interface BoardMapper {
	
	//지역 리스트
	public List<Region> selectRegionList();
	
	//분야 리스트
	public List<Feild> selectFeildList(); 
	
}
