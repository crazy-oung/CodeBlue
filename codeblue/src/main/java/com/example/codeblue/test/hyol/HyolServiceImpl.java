package com.example.codeblue.test.hyol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.mapper.AdminMapper;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.User;
@Service
@Transactional
public class HyolServiceImpl implements HyolService {

	@Autowired private HyolMapper hyolMapper;
	
	// 회원 조회
	@Override
	public Map<String,Object> getAdminUserList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate) {
		System.out.println("::: AdminUserServiceImpl - selectUserList :::");
		int beginRow = (currentPage-1)*rowPerPage;
		Page page = new Page();
		page.setSearchWord(searchWord);
		page.setToDate(toDate);
		page.setFromDate(fromDate);
		int totalRow = hyolMapper.adminSelectUserCount(page);
		System.out.println("totalRow : "+totalRow);
		// 마지막 페이지 구하기
		int lastPage = 0;
		if(totalRow % rowPerPage != 0 ) {
			lastPage = (totalRow/rowPerPage)+1;
		} else {
			lastPage = totalRow/rowPerPage;
		}
		System.out.println("lastPage : "+lastPage);
		// page에 담아서 보내기
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		System.out.println(page.toString());
		List<User> list = hyolMapper.adminSelectUserList(page);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("totalRow", totalRow);
		map.put("lastPage", lastPage);
		map.put("list", list);
		map.put("toDate", toDate);
		map.put("fromDate", fromDate);
		return map;
	}
	// 회원 삭제(업데이트y->n)
	@Override
	public int removeAdminUser(List<String> checkBoxArr) {
		// 업데이트 전 체크한 회원 조회
		System.out.println("::: AdminUserServiceImpl - adminDeleteUser :::");
		int checking = hyolMapper.adminDeleteUser(checkBoxArr);
		return checking;
	}
}
