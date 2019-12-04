package com.example.codeblue.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.admin.mapper.AdminUserMapper;
import com.example.codeblue.board.vo.Page;
import com.example.codeblue.user.vo.User;

@Service
@Transactional
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired private AdminUserMapper adminUserMapper;
	
	@Override
	public Map<String,Object> getAdminUserList(int currentPage, int rowPerPage) {
		System.out.println("::: AdminUserServiceImpl - selectUserList :::");
		int beginRow = (currentPage-1)*rowPerPage;
		int totalRow = adminUserMapper.adminSelectUserCount();
		int lastPage = 0;
		if(lastPage % rowPerPage == 0 ) {
			lastPage = totalRow/rowPerPage;
		} else {
			lastPage = (totalRow/rowPerPage)+1;
		}
		Page page = new Page();
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		System.out.println(page.toString());
		List<User> list = adminUserMapper.adminSelectUserList(page);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("lastPage", lastPage);
		map.put("list", list);
		return map;
	}
}
