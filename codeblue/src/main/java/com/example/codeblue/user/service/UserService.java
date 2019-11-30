package com.example.codeblue.user.service;

import com.example.codeblue.user.vo.User;

public interface UserService {
	public User verifyUser(User user); 
	public int addUser(User user); 
	public String sendCodeToMail(User user);
}
