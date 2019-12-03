package com.example.codeblue.board.service;

import java.util.List;

import com.example.codeblue.user.vo.Feild;
import com.example.codeblue.user.vo.Region;

public interface BoardService {

	public List<Region> getRegionList();
	public List<Feild> getFeildList();
}
