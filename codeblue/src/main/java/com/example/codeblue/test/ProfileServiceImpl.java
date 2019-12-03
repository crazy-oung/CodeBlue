package com.example.codeblue.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.user.vo.User;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService{
	@Autowired ProfileMapper profileMapper;
	
	@Override
	public User selectUserOne(String UserId) {
		System.out.println("::: ProfileServiceImpl - selectUserOne :::");
		User user = profileMapper.selectUserOne(UserId);
		
		return user;
	}

}
