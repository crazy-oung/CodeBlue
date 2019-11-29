package com.example.codeblue.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.codeblue.user.mapper.UserMapper;
import com.example.codeblue.user.vo.User;

@Service
public class UserService {
	@Autowired UserMapper userMapper;
	
	public User loginUser(User user) {
		return userMapper.checkUser(user);
	}
	
	//회원가입
	public int addUser(User user) {
		
		userMapper.insertUser(user);
		return 0;
	}
	
	@Autowired JavaMailSender javaMailSender;
	//회원가입 메일 보내기
	public String sendmail(User user) {	        
	    
		String randNum = ""+(int)(Math.random()*1000000)+10000;
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	    
	    simpleMailMessage.setTo(user.getUserId());
	    simpleMailMessage.setFrom("admin@gmail.com");
	    simpleMailMessage.setSubject("코드 발송");
	    simpleMailMessage.setText(user.getUserName()+"님!. 인증코드는  ["+randNum+"]입니다.");
	    
	    javaMailSender.send(simpleMailMessage);
	    return randNum;
	}
}
