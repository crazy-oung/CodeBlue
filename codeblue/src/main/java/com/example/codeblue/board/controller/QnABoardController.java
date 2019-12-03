package com.example.codeblue.board.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.board.service.QnABoardService;

@RestController
public class QnABoardController {
	@Autowired QnABoardService qnaBoardService;
	
}
