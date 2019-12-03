package com.example.codeblue.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.user.vo.User;

@RestController
public class ProfileRestController {
	@Autowired ProfileService profileService;
	
	
	
	@PostMapping("/rest/userOne")
	public User getUserOne(String userId) {
		System.out.println("::: post - getUserOne :::"); 
		return profileService.selectUserOne(userId);
	}
}