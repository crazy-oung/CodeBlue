package com.example.codeblue.test.hyol;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.User;

@Mapper
public interface HyolMapper {

	//회원리스트
	public List<User> adminSelectUserList(Page page);
	//회원 수
	public int adminSelectUserCount(Page page);
}
