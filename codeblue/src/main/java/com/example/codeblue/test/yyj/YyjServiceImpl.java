package com.example.codeblue.test.yyj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.codeblue.vo.User;

@Service
@Transactional
public class YyjServiceImpl implements YyjService{
	@Autowired YyjMapper yyjMapper;

//	@Override
//	public void modifyUserProfile(User user) {
//		System.out.println("::: UserServiceImpl - modifyUserProfile :::");
//		yyjMapper1.updateUserProfile(user);

	}
