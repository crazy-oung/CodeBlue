package com.example.codeblue.test.hdy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HdyTestController {
	
	@GetMapping("/tags")
	public String getTags() {
		System.out.println("::: bget - getTags :::");
		return "/tags";
	}

}
