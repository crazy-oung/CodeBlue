package com.example.codeblue.test.hyol;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.User;

@Mapper
public interface HyolMapper {

	//회원리스트
	public List<User> adminSelectUserList(Page page);
	//회원 수
	public int adminSelectUserCount(Page page);
	// 회원 삭제(y->n)
	public int adminDeleteUser(List<String> checkBoxArr);
}
