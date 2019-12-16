package com.example.codeblue.test.hyol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.mapper.AdminMapper;
import com.example.codeblue.vo.FaqBoard;
import com.example.codeblue.vo.Inquiry;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.ServiceCategory;
import com.example.codeblue.vo.User;
@Service
@Transactional
public class HyolServiceImpl implements HyolService {

	@Autowired private HyolMapper hyolMapper;
	
	// 회원 조회
	@Override
	public Map<String,Object> getAdminUserList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate) {
		System.out.println("::: AdminUserServiceImpl - adminSelectUserList :::");
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
	// 탈퇴회원 조회
	@Override
	public Map<String,Object> getAdminWithdrawUserList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate) {
		System.out.println("::: AdminUserServiceImpl - adminSelectWithdrawUserList :::");
		int beginRow = (currentPage-1)*rowPerPage;
		Page page = new Page();
		page.setSearchWord(searchWord);
		page.setToDate(toDate);
		page.setFromDate(fromDate);
		int totalRow = hyolMapper.adminSelectWithdrawUserCount(page);
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
		List<User> list = hyolMapper.adminSelectWithdrawUserList(page);
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
	// 회원 복구(업데이트n->y)
	@Override
	public int modifyAdminWithdrawUser(List<String> checkBoxArr) {
		// 업데이트 전 체크한 회원 조회
		System.out.println("::: AdminUserServiceImpl - adminUpdateWithdrawUser :::");
		int checking = hyolMapper.adminUpdateWithdrawUser(checkBoxArr);
		return checking;
	}
	// 전문가 회원 조회
	@Override
	public Map<String, Object> getAdminExpertUserList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate) {
		System.out.println("::: AdminUserServiceImpl - adminSelectExpertUserList :::");
		int beginRow = (currentPage-1)*rowPerPage;
		Page page = new Page();
		page.setSearchWord(searchWord);
		page.setToDate(toDate);
		page.setFromDate(fromDate);
		int totalRow = hyolMapper.adminSelectExpertUserCount(page);
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
		List<User> list = hyolMapper.adminSelectExpertUserList(page);
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
	// -------------------------------------------------------------유저-------------------------------------------------------
	@Override
	public Map<String, Object> getUserList(int currentPage, int rowPerPage, String searchWord) {
		System.out.println("::: UserServiceImpl - selectUserListTest :::");
		int beginRow = (currentPage-1)*rowPerPage;
		// page에 담아서 mapper의 parm으로 사용
		Page page = new Page();
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setSearchWord(searchWord);
		System.out.println(page.toString());
		// 전체행의 수
		int totalRow = hyolMapper.selectUserCount(page);
		System.out.println("totalRow : "+totalRow);
		// 마지막 페이지 구하기
		int lastPage = 0;
		if(totalRow%rowPerPage != 0) {
			lastPage = (totalRow/rowPerPage)+1;
		} else {
			lastPage = totalRow/rowPerPage;
		}
		System.out.println("lastPage : "+lastPage);
		// 리스트 출력
		List<User> list = hyolMapper.selectUserList(page);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("currentPage", currentPage);
		map.put("totalRow", totalRow);
		map.put("lastPage", lastPage);
		return map;
	}
	// serviceCategory 조회
	@Override
	public List<ServiceCategory> getServiceCategoryList() {
		System.out.println("::: UserServiceImpl - selectServiceCategoryListTest :::");
		List<ServiceCategory> list = hyolMapper.selectServiceCategoryList();
		System.out.println(list.toString());
		return list;
	}
	// faq 리스트 조회
	@Override
	public Map<String, Object> getFaqList(int currentPage, int rowPerPage, String searchCategory) {
		System.out.println("::: UserServiceImpl - selectFaqListTest :::");
		int beginRow = (currentPage-1)*rowPerPage;
		Page page = new Page();
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setSearchCategory(searchCategory);
		// 전체행의 수
		int totalRow = hyolMapper.selectFaqCount(page);
		System.out.println("totalRow : "+totalRow);
		// 마지막 페이지 구하기
		int lastPage = 0;
		if(totalRow%rowPerPage != 0) {
			lastPage = (totalRow/rowPerPage)+1;
		} else {
			lastPage = totalRow/rowPerPage;
		}
		System.out.println("lastPage : "+lastPage);
		// 리스트 출력
		List<FaqBoard> list = hyolMapper.selectFaqList(page);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("currentPage", currentPage);
		map.put("totalRow", totalRow);
		map.put("lastPage", lastPage);
		// 서비스 카테고리아이디를 page의 searchCategory에 담으려고 한것이기 떄문에 다시 원래이름으로 되돌려준다
		map.put("serviceCategoryId", searchCategory);
		return map;
	}
	// faqone 출력 (이전글,다음글까지 출력)
	@Override
	public List<FaqBoard> getFaqOne(int faqId) {
		System.out.println("::: UserServiceImpl - selectFaqOneTest :::");
		List<FaqBoard> list = hyolMapper.selectFaqOne(faqId);
		return list;
	}
	// inquiry 출력
	@Override
	public List<Inquiry> getInquiryList() {
		System.out.println("::: UserServiceImpl - selectInquiryTest :::");
		List<Inquiry> list = hyolMapper.selectInquiry();
		System.out.println(list);
		return list;
	}
	// inquiry 히스토리출력(자신이 올린 글만)
	@Override
	public Map<String, Object> getInquiryHistoryBoard(int currentPage, int rowPerPage, String loginUserId, String searchCategory) {
		System.out.println("::: UserServiceImpl - selectInquiryHistoryTest :::");
		// 페이징
		int beginRow = (currentPage-1)*rowPerPage;
		Page page = new Page();
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setUserId(loginUserId);
		page.setSearchCategory(searchCategory);
		// 전체행의 수
		int totalRow = hyolMapper.selectInquiryHistoryCount(page);
		System.out.println("totalRow : "+totalRow);
		// 마지막 페이지 구하기
		int lastPage = 0;
		if(totalRow%rowPerPage != 0) {
			lastPage = (totalRow/rowPerPage)+1;
		} else {
			lastPage = totalRow/rowPerPage;
		}
		System.out.println("lastPage : "+lastPage);
		// 리스트 출력
		List<InquiryHistory> list = hyolMapper.selectInquiryHistory(page);
		System.out.println(list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("currentPage", currentPage);
		map.put("totalRow", totalRow);
		map.put("lastPage", lastPage);
		// 서비스 카테고리아이디를 page의 searchCategory에 담으려고 한것이기 떄문에 다시 원래이름으로 되돌려준다
		map.put("inquiryId", searchCategory);
		
		return map;
	}
}