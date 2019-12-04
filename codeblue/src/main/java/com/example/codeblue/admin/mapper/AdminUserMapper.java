package com.example.codeblue.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.board.vo.Page;
import com.example.codeblue.user.vo.User;

@Mapper
public interface AdminUserMapper {

	public List<User> adminSelectUserList(Page page);
	public int adminSelectUserCount();
}
