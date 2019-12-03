package com.example.codeblue.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.user.vo.Feild;
import com.example.codeblue.user.vo.Region;

@Mapper
public interface BoardMapper {
	//지역 리스트
	public List<Region> selectRegionList();
	
	//분야 리스트
	public List<Feild> selectFeildList(); 
}
