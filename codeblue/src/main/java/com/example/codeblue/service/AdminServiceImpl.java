package com.example.codeblue.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.mapper.AdminMapper;
import com.example.codeblue.vo.FaqBoard;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.Notice;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionCount;
import com.example.codeblue.vo.ReportHistory;
import com.example.codeblue.vo.User;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public Map<String,Object> getAdminUserList(int currentPage, int rowPerPage, String searchWord) {
		System.out.println("::: AdminUserServiceImpl - selectUserList :::");
		int beginRow = (currentPage-1)*rowPerPage;
		int totalRow = adminMapper.adminSelectUserCount();
		int lastPage = 0;
		if(lastPage % rowPerPage == 0 ) {
			lastPage = totalRow/rowPerPage;
		} else {
			lastPage = (totalRow/rowPerPage)+1;
		}
		Page page = new Page();
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setSearchWord(searchWord);
		System.out.println(page.toString());
		List<User> list = adminMapper.adminSelectUserList(page);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("lastPage", lastPage);
		map.put("list", list);
		return map;
	}
	@Override
	public Map<String, Object> getNoticeBoard(int currentPage, int rowPerPage, String searchWord) {
		System.out.println(":::AdminNoticeServiceImpl - getNoticeBoard:::");
		System.out.println("currentPage :"+currentPage+"/rowPerPage :"+rowPerPage);
		
		int beginRow = (currentPage-1)*rowPerPage;
		Page page = new Page();
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setSearchWord(searchWord);
		
		int totalRow = adminMapper.noticeBoardCount(page);
		int lastPage = 0;
		
		if(totalRow % rowPerPage ==1) {
			lastPage = (totalRow/rowPerPage)+1;
		}else {
			lastPage = totalRow/rowPerPage;
		}
		System.out.println("lastPage:"+ lastPage );
		
		List<Notice> list = adminMapper.selectNoticeBoard(page);
		System.out.println(list.toString());
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		map.put("totalRow", totalRow);
		map.put("lastPage", lastPage);
		map.put("list", list);
		
				
		return map;
	}

	@Override
	public Notice getNoticeOne(int noticeId) {
		System.out.println(":::AdminNoticeServiceImpl - getNoticeOne");
		System.out.println("noticeId"+noticeId);
		
		return adminMapper.noticeBoardOne(noticeId);
	}

	@Override
	public int addNotice(Notice notice) {
		System.out.println(":::AdminNoticeServiceImpl - addNotice");
		System.out.println("Notice"+ notice);
		return adminMapper.insertNoticeBoard(notice);
	}
	//신고내역 상세 페이지 가져오기
	@Override
	public ReportHistory getReportHistoryOne(int reportHistoryId) {
		System.out.println("::: AdminInquiryServiceImpl - getReportHistoryOne :::");
		return adminMapper.selectReportHistoryOne(reportHistoryId);
	}
	//문의내역 상세페이지 가져오기
	@Override
	public InquiryHistory getInquiryHistoryOne(int inquiryHistoryId) {
		System.out.println("::: AdminInquiryServiceImpl - getInquiryHistoryOne :::");
		return adminMapper.selectInquiryHistoryOne(inquiryHistoryId);
	}
	//신고내역 가져오기
	@Override
	public Map<String, Object> getReportHistoryList(int currentPage, int rowPerPage) {
		System.out.println("::: AdminInquiryServiceImpl - getReportHistoryList :::");
		
		Page page = new Page();
		page.setRowPerPage(rowPerPage);
		page.setBeginRow((currentPage-1)*rowPerPage);
		
		int totalRow = adminMapper.ReportHistoryTotalRow();
		int lastPage = totalRow/rowPerPage;
		
		if(totalRow % rowPerPage != 0) {
			lastPage ++;
		}
		List<ReportHistory> list = adminMapper.selectReportHistoryList(page);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalRow", totalRow);
		map.put("list", list);
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("lastPage", lastPage);
		System.out.println(map.toString());
		return map;
	}
	
	//문의 내역 리스트 가져오기
	@Override
	public Map<String, Object> getInquiryHistoryList(int currentPage, int rowPerPage) {
		System.out.println("::: AdminInquiryServiceImpl - getInquiryHistoryList :::");
		
		Page page = new Page();
		page.setRowPerPage(rowPerPage);
		page.setBeginRow((currentPage-1)*rowPerPage);
		
		int totalRow = adminMapper.InquiryHistoryTotalRow();
		int lastPage = totalRow/rowPerPage;
		
		if(totalRow % rowPerPage != 0) {
			lastPage ++;
		}
		List<InquiryHistory> list = adminMapper.selectInquiryHistoryList(page);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalRow", totalRow);
		map.put("list", list);
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("lastPage", lastPage);
		System.out.println(map.toString());
		return map;
	}
	@Override
	public List<QuestionCount> getCurrentQuestionCountFor6Month() {
		System.out.println("::: AdminHomeServiceImpl - getCurrentQuestionCountFor6Month :::");
		return adminMapper.selectCurrentQuestionCountFor6Month();
	}

	@Override
	public List<QuestionCount> getCurrentQuestionCountFromFeild() {
		System.out.println("::: AdminHomeServiceImpl - getCurrentQuestionCountFromFeild :::");
		return adminMapper.selectCurrentQuestionCountFromFeild();
	}
	// 문의사항 답변
	@Override
	public int addFaqBoard(FaqBoard faqBoard) {
		System.out.println("::: AdminFaqBoardServiceImpl - addFaqBoard :::");
		faqBoard.toString();
		return adminMapper.insertFaqBoard(faqBoard);
	}	
	@Override
	public List<String> getAdminFeildList() {
		System.out.println("::: AdminBoardServiceImpl - getAdminFeildList :::");
		return adminMapper.selectAdminFeildList();
	}
	
	@Override
	public Map<String,Object> getAdminBoardList(Page page,int currentPage) {
		System.out.println("::: AdminBoardServiceImpl - getAdminBoardList :::");
		
		//시작값 정하기
		int beginRow = (currentPage -1) * page.getRowPerPage();
		page.setBeginRow(beginRow);
		System.out.println(page.toString());
		//질문 리스트 전체 행의 갯수
		int totalCount = adminMapper.selectAdminBoardTotalCount(page);
		System.out.println("totalCount : "+totalCount);
		//페이지 마지막값변수선언
		int lastPage = 0;
		//페이지갯수값 저장
		if(totalCount%page.getRowPerPage() == 0) {
			lastPage = totalCount/page.getRowPerPage();
		} else {
			lastPage = (totalCount/page.getRowPerPage())+1;
		}
		System.out.println("lastPage : "+lastPage);
		// 질문 리스트 저장
		List<QuestionBoard> list = adminMapper.selectAdminBoardList(page);
		System.out.println(list.toString());
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("lastPage", lastPage);
		map.put("currentPage",currentPage);
		map.put("list",list);
		map.put("totalCount",totalCount);
		map.put("searchWord",page.getSearchWord());
		return map;
	}
}
