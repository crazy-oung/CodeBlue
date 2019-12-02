package com.example.codeblue.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.codeblue.user.vo.Expert;
import com.example.codeblue.user.vo.Feild;
import com.example.codeblue.user.vo.Manager;
import com.example.codeblue.user.vo.Region;
import com.example.codeblue.user.vo.User;

@Mapper
public interface UserMapper {
	// 유저 로그인
	public User selectUserId(User user);
	// 관리자 로그인
	public Manager selectManagerId(User user);
	
	//회원가입
	public int insertUser(User user);
	
	//지역 리스트
	public List<Region> selectRegionList();
	
	//분야 리스트
	public List<Feild> selectFeildList(); 
	
	// 전문가 추가
	public int insertExpert(Expert expert);
	 
}
