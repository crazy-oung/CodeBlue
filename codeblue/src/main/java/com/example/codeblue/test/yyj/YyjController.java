package com.example.codeblue.test.yyj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.codeblue.vo.Manager;
@Controller
public class YyjController {
	@Autowired YyjService yyjService;
//	
//	@GetMapping("/manageAdmin")
//	public String addAdministrator(Manager manager) {
//			System.out.println("::get - addAdministrator:::");
//		return "/codeBlue/admin/adminAddAdministrator";
//	}

}
