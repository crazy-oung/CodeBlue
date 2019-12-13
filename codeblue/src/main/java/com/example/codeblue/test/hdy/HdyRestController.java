package com.example.codeblue.test.hdy;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HdyRestController {
	
	@Autowired HdyService hdyService;
	
	@PostMapping("/rest/addTag")
	public String[] addTag(String[] list) {
		System.out.println("::: post - addTag :::");
		System.out.println(Arrays.toString(list));
		System.out.println(list.toString());
		return list;
		
	}
}
