package com.example.codeblue.test;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.user.vo.User;

@Mapper
public interface ProfileMapper {
	public User selectUserOne(String UserId);
}