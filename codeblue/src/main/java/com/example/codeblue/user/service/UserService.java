package com.example.codeblue.user.service;

import com.example.codeblue.user.vo.Expert;
import com.example.codeblue.user.vo.Manager;
import com.example.codeblue.user.vo.User;

public interface UserService {
	public User verifyUser(User user); 
	public String getUserIdForCheck(User user); 
	public Manager verifyManager(User user);
	public int addUser(User user); 
	public int addExpert(Expert expert); 
	
	public String sendCodeToMail(User user);
	public String resetPassword(User user);
	public int modifyUserPw(User user);
}
