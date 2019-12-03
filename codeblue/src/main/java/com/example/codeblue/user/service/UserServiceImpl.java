package com.example.codeblue.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.user.mapper.UserMapper;
import com.example.codeblue.user.vo.Expert;
import com.example.codeblue.user.vo.Feild;
import com.example.codeblue.user.vo.Manager;
import com.example.codeblue.user.vo.Region;
import com.example.codeblue.user.vo.User;

@Transactional
@Service
public class UserServiceImpl implements UserService{
	@Autowired UserMapper userMapper; 
	@Autowired JavaMailSender javaMailSender;
	
	@Override
	public User verifyUser(User user) {
		System.out.println("::: UserServluceImpl - verifyUser :::");
		return userMapper.selectUserId(user);
	}
	
	//회원가입
	@Override
	public int addUser(User user) { 
		System.out.println("::: UserServluceImpl - addUser :::");
		int rs = userMapper.insertUser(user);
		return rs;
	}
	
	//회원가입 메일 보내기
	@Override
	public String sendCodeToMail(User user) {	        
		System.out.println("::: UserServluceImpl - sendCodeToMail :::");
		
		String randNum = ""+(int)(Math.random()*100000)+1;
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	    
	    simpleMailMessage.setTo(user.getUserId()); 
	    simpleMailMessage.setSubject("코드블루 인증코드입니다. 💙");
	    simpleMailMessage.setText(user.getUserName()+"님! 인증코드는  ["+randNum+"]입니다. <br> 인증코드 입력란에 입력해주셔야 회원가입이 완료 됩니다! :) <br> 감사합니다.");
	    System.out.println("인증번호: " + randNum);
	    
	    javaMailSender.send(simpleMailMessage);
	    return randNum;
	}

	@Override
	public int addExpert(Expert expert) {
		System.out.println("::: UserServluceImpl - addExpert :::"); 
		return userMapper.insertExpert(expert);
	}

	@Override
	public Manager verifyManager(User user) {
		System.out.println("::: UserServluceImpl - verifyManager :::"); 
		return userMapper.selectManagerId(user);
	}

	@Override
	public String resetPassword(User user) {
		System.out.println("::: UserServluceImpl - resetPassword :::"); 
		System.out.println(user.toString());
		
		if(userMapper.selectUserId(user) == null) {
			return "noSuchUser";
		}
		
		String randNum = sendCodeToMail(user);
		return randNum;
	}

	@Override
	public String getUserIdForCheck(User user) {
		System.out.println("::: UserServluceImpl - verifyUserForReset :::");
		
		if(userMapper.selectUserIdForCheck(user) == null) {
			return null;
		}
		
		String randNum = sendCodeToMail(user);
		return randNum;
	}

	@Override
	public int modifyUserPw(User user) {
		System.out.println("::: UserServluceImpl - modifyUserPw :::");
		return userMapper.updateUserPw(user);
	}

}
