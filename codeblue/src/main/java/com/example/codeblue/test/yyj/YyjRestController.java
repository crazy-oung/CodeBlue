package com.example.codeblue.test.yyj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.codeblue.vo.User;

@RestController
public class YyjRestController {
	@Autowired YyjService yyjService;	
	
//	@PostMapping("rest/modifyProfile")
//	public void modifyUserProfile(User user,
//									@RequestParam(value="userName")String userName,
//									@RequestParam(value="userPw")String userPw,
//									@RequestParam(value="userId")String userId) {
//		
//		System.out.println("::: post - modifyUserProfile :::");		
//		System.out.println("user Name : " + userName);
//		System.out.println("change Pw : " + userPw);	
//		
//		user = new User();
//			user.setUserName(userName);
//			user.setUserPw(userPw);
//			user.setUserId(userId);
//		System.out.println("user : " + user.toString());
//		
//		yyjService.modifyUserProfile(user);
//	
//		//return "redirect:/userOne?userId="+user.getUserId();
//	}

}