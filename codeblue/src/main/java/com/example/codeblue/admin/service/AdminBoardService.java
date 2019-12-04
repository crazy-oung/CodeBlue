package com.example.codeblue.admin.service;

import java.util.List;
import java.util.Map;

import com.example.codeblue.board.vo.Page;

public interface AdminBoardService {

	public List<String> getAdminFeildList();
	public Map<String,Object> getAdminBoardList(Page page,int currentPage);
}
