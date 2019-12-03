package com.example.codeblue.board.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.board.service.BoardService;
import com.example.codeblue.user.vo.Feild;
import com.example.codeblue.user.vo.Region;

@RestController
public class BoardRestController {
	@Autowired BoardService boardService;
	
	@GetMapping("/rest/getRegionList")
	public List<Region> getRegionList(){
		System.out.println("::: get - getRegionList :::");
		return boardService.getRegionList();
	}
	
	@GetMapping("/rest/getFeildList")
	public List<Feild> getFeildList(){
		System.out.println("::: get - getFeildList :::");
		return boardService.getFeildList();
	}
}
