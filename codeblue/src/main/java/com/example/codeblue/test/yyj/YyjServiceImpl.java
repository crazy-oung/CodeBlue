package com.example.codeblue.test.yyj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.vo.Manager;

@Service
@Transactional
public class YyjServiceImpl implements YyjService{
	@Autowired YyjMapper yyjMapper;
	@Autowired JavaMailSender javaMailSender;

//	@Override
//	public int addAdministrator(Manager manager) {
//		System.out.println("::: AdminServluceImpl - addaAdministrator :::"); 
//		
//		int a = yyjMapper.insertAdministrator(manager);
//		
//		System.out.println(manager.toString());
//		return a;
//	}
//	
//	@Override
//	public String sendCodeToMail(Manager manager) {	        
//		System.out.println("::: AdminServluceImpl - sendCodeToMail :::");
//		
//		String randNum = ""+(int)(Math.random()*100000)+1;
//		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//	    
//	    simpleMailMessage.setTo(manager.getManagerId()); 
//	    simpleMailMessage.setSubject("코드블루 인증코드입니다. 💙");
//	    simpleMailMessage.setText(manager.getManagerName()+"님! 어드민 추가관련 인증코드는  ["+randNum+"]입니다. 인증코드 입력란에 입력해주셔야 관리자 추가가 완료 됩니다! :) 감사합니다. 😍");
//	    System.out.println("인증번호: " + randNum);
//	    
//	    javaMailSender.send(simpleMailMessage);
//	    return randNum;
//	}

}
