package com.example.codeblue.tag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.board.vo.Page;
import com.example.codeblue.tag.vo.Tag;

@Mapper
public interface TagMapper {
	//최신순 
	public List<Tag> selectTagListDate(Page page);
	//인기순
	public List<Tag> selectTagListPopular(Page page);
	//이름순
	public List<Tag> selectTagListName(Page page);
}
