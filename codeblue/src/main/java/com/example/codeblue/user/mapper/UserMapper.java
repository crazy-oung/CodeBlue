package com.example.codeblue.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.user.vo.User;

@Mapper
public interface UserMapper {
	//로그인
	public User login(User user);
	//회원가입
	public int insertUser(User user);
	
	
}
