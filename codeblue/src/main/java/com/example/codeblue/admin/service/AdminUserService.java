package com.example.codeblue.admin.service;

import java.util.Map;


public interface AdminUserService {

	public Map<String,Object> getAdminUserList(int currentPage, int rowPerPage, String searchWord);
}
