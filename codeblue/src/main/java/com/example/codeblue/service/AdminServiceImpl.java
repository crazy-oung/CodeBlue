package com.example.codeblue.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.mapper.AdminMapper;
import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.FaqBoard;
import com.example.codeblue.vo.Feild;
import com.example.codeblue.vo.Hospital;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.InquiryHistoryAnswer;
import com.example.codeblue.vo.NoticeBoard;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionCount;
import com.example.codeblue.vo.ReportHistory;
import com.example.codeblue.vo.ServiceCategory;
import com.example.codeblue.vo.User;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminMapper;
	
	//답변 상세정보
	@Override
	public Answer getAnswerOne(String answerId) {
		System.out.println("::: AdminBoardServiceImpl - getAnswerOne :::");
		return adminMapper.selectAnswerOne(answerId);
	}
	
	//답변 지우기
	@Override
	public void removeAnswerList(List<String> answerIdList) {
		System.out.println("::: AdminBoardServiceImpl - removeAnswerList :::");
		System.out.println(answerIdList.toString());
		// 1번째로 답변의 추천수 지우기
		adminMapper.deleteQuestionBoardAnswerVote(answerIdList);
		System.out.println("답변의 추천수지우기성공");
		// 2번째로 답변에 해당하는 댓글 지우기
		adminMapper.deleteQuestionBoardAnswerComment(answerIdList);
		System.out.println("답변의 댓글지우기성공");
		// 3번째로 질문에 해당하는 답변 지우기
		adminMapper.deleteQuestionBoardAnswer(answerIdList);
		System.out.println("답변 지우기 성공");
	}
	
	//답변 리스트 가져오기
	@Override
	public Map<String, Object> getAnswerList(Page page, int currentPage) {
		System.out.println("::: AdminBoardServiceImpl - getAnswerList :::");
		
		//시작값 정하기
		int beginRow = (currentPage -1) * page.getRowPerPage();
		page.setBeginRow(beginRow);
		System.out.println(page.toString());
		//질문 리스트 전체 행의 갯수
		int totalCount = adminMapper.selectAnswerTotalCount(page);
		System.out.println("totalCount : "+totalCount);
		//페이지 마지막값변수선언
		int lastPage = 1;
		//페이지갯수값 저장
		if(totalCount%page.getRowPerPage() == 0) {
			lastPage = totalCount/page.getRowPerPage();
		} else {
			lastPage = (totalCount/page.getRowPerPage())+1;
		}
		System.out.println("lastPage : "+lastPage);
		// 질문 리스트 저장
		List<Answer> list = adminMapper.selectAnswerList(page);
		System.out.println(list.toString());
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("lastPage", lastPage);
		map.put("currentPage",currentPage);
		map.put("list",list);
		map.put("totalCount",totalCount);
		map.put("searchWord",page.getSearchWord());
		return map;
	}
	//삭제된 게시글 상세정보
	@Override
	public QuestionBoard getWithdrawQuestionBoardOne(String questionId) {
		System.out.println("::: AdminBoardServiceImpl - getWithdrawQuestionBoardOne :::");
		return adminMapper.selectWithdrawQuestionBoardOne(questionId);
	}
	//게시글 상세정보
	@Override
	public QuestionBoard getQuestionBoardOne(String questionId) {
		System.out.println("::: AdminBoardServiceImpl - getQuestionBoardOne :::");
		return adminMapper.selectQuestionBoardOne(questionId);
	}
	
	//삭제된 게시글 가져오기
	@Override
	public Map<String,Object> getWithdrawQuestionBoardList(Page page,int currentPage) {
		System.out.println("::: AdminBoardServiceImpl - getWithdrawQuestionBoardList :::");
		
		//시작값 정하기
		int beginRow = (currentPage -1) * page.getRowPerPage();
		page.setBeginRow(beginRow);
		System.out.println(page.toString());
		//질문 리스트 전체 행의 갯수
		int totalCount = adminMapper.selectWithdrawQuestionBoardTotalCount(page);
		System.out.println("totalCount : "+totalCount);
		//페이지 마지막값변수선언
		int lastPage = 1;
		//페이지갯수값 저장
		if(totalCount%page.getRowPerPage() == 0) {
			lastPage = totalCount/page.getRowPerPage();
		} else {
			lastPage = (totalCount/page.getRowPerPage())+1;
		}
		System.out.println("lastPage : "+lastPage);
		// 질문 리스트 저장
		List<QuestionBoard> list = adminMapper.selectWithdrawQuestionBoardList(page);
		System.out.println(list.toString());
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("lastPage", lastPage);
		map.put("currentPage",currentPage);
		map.put("list",list);
		map.put("totalCount",totalCount);
		map.put("searchWord",page.getSearchWord());
		return map;
	}
	//게시글 삭제하기
	@Override
	public void removeQeustionBoardList(List<String> questionBoardIdList) {
		System.out.println("::: AdminBoardServiceImpl - removeQeustionBoardList :::");
		//질문 상세한정보 가져오기
		List<QuestionBoard> questionBoardList = adminMapper.selectQuestionBoardCheckList(questionBoardIdList);
		System.out.println(questionBoardList.toString());
		//질문에 해당하는 답변 id 값 가져오기
		List<String> answerIdList = adminMapper.selectQuestionBoardAnswerList(questionBoardIdList);
		System.out.println(answerIdList.toString());
		System.out.println(questionBoardIdList.toString());
		// 맨처음으로 질문을 삭제된 질문테이블로 저장
		adminMapper.insertWithdrawQuestionBoard(questionBoardList);
		if(answerIdList.size() != 0) { //답변이 있을시 반응한다.
			// 1번째로 답변의 추천수 지우기
			adminMapper.deleteQuestionBoardAnswerVote(answerIdList);
			System.out.println("답변의 추천수지우기성공");
			// 2번째로 답변에 해당하는 댓글 지우기
			adminMapper.deleteQuestionBoardAnswerComment(answerIdList);
			System.out.println("답변의 댓글지우기성공");
			// 3번째로 질문에 해당하는 답변 지우기
			adminMapper.deleteQuestionBoardAnswer(answerIdList);
			System.out.println("답변 지우기 성공");
		}
		// 4번째로 질문에 해당되는 추천수 지우기
		adminMapper.deleteQuestionVote(questionBoardIdList);
		System.out.println("질문 추천수 지우기 성공");
		// 5번째로 질문에 해당되는 댓글 지우기
		adminMapper.deleteQuestionComment(questionBoardIdList);
		System.out.println("질문 댓글 지우기 성공");
		// 6번째로 질문에 해당되는 이미지 지우기
		adminMapper.deleteQuestionBoardImg(questionBoardIdList);
		System.out.println("질문 이미지 지우기 성공");
		// 7번째로 질문테이블에서 지운다.
		adminMapper.deleteQuestionBoard(questionBoardIdList);
		System.out.println("질문 지우기 성공");
	}
	//문의사항 답변 저장
	@Override
	public int addInquiryHistoryAnswer(InquiryHistoryAnswer inqruiyHistoryAnswer) {
		System.out.println(":::AdminServiceImpl - addInquiryHistoryAnswer:::");
		return adminMapper.insertInquiryHistoryAnswer(inqruiyHistoryAnswer);
	}
	//FAQ 상세정보 가져오기
	@Override
	public FaqBoard getFaqOne(int faqId) {
		System.out.println(":::AdminServiceImpl - getFaqOne:::");
		return adminMapper.selectFaqOne(faqId);
	}
	//FAQ 삭제하기
	@Override
	public int removeFaq(int faqId) {
		System.out.println(":::AdminServiceImpl - removeFaq:::");
		return adminMapper.deleteFaq(faqId);
	}
	//FAQ 수정하기
	@Override
	public int modifyFaq(FaqBoard faqBoard) {
		System.out.println(":::AdminServiceImpl - modifyFaq:::");
		return adminMapper.updateFaq(faqBoard);
	}
	//FAQ 추가하기
	@Override
	public int addFaqBoard(FaqBoard faqBoard) {
		System.out.println(":::AdminServiceImpl - addFaqBoard:::");
		return adminMapper.insertFaqBoard(faqBoard);
	}
	
	//FAQ 전체 리스트 가져오기
	@Override
	public Map<String, Object> getFaqBoardList(int currentPage, int rowPerPage, String searchWord) {
		System.out.println(":::AdminServiceImpl - getInquiryHistoryAnswerList:::");
		System.out.println("currentPage :"+currentPage+"/rowPerPage :"+rowPerPage);

		Page page = new Page();
		page.setBeginRow((currentPage-1)*rowPerPage);
		page.setRowPerPage(rowPerPage);
		page.setSearchWord(searchWord);
		System.out.println("setBeginRow" + page.getBeginRow());
		System.out.println("setRowPerPage" + page.getRowPerPage());
		System.out.println("setSearchWord" + page.getSearchWord());
		int totalRow = adminMapper.selectFaqBoardTotalCount();
		int lastPage = 0;
		
		if(totalRow % rowPerPage ==1) {
			lastPage = (totalRow/rowPerPage)+1;
		}else {
			lastPage = totalRow/rowPerPage;
		}
		System.out.println("lastPage:"+ lastPage );
		
		List<FaqBoard> list = adminMapper.selectFaqBoardList(page);
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
	
	//서비스 카테고리 리스트 가져오기
	@Override
	public List<ServiceCategory> getServiceCategoryList() {
		System.out.println(":::AdminService - getServiceCategoryList:::");
		return adminMapper.selectServiceCategoryList();
	}
	
	//병원정보 수정
		@Override
		public int modifyHospital(Hospital hospital) {
			System.out.println(":::AdminService - updateHospital:::");
			System.out.println("hospital "+hospital);
			return adminMapper.updateHospital(hospital);
	}
	
	//병원 리스트
		@Override 
		public Map<String, Object> getHospitalList(int currentPage, int rowPerPage, String searchWord) {
			System.out.println(":::HospitalServiceImpl - getHospitalList:::");
			
			int beginRow = (currentPage-1)*rowPerPage;
			Page page = new Page();
			page.setBeginRow(beginRow);
			page.setRowPerPage(rowPerPage);
			page.setSearchWord(searchWord);
			
			int totalRow = adminMapper.hospitalCount();
			int lastPage = 0;
			
			if(totalRow % rowPerPage ==0) {
				lastPage = totalRow/rowPerPage;
			}else {
				lastPage = (totalRow/rowPerPage)+1;
			}
			
			System.out.println("lastPage : "+lastPage);
			
			List<Hospital> list = new ArrayList<Hospital>();
			list = adminMapper.hospitalList(page);
			System.out.println(list.toString());
			
			Map<String,Object> map = new  HashMap<String, Object>();
			map.put("currentPage", currentPage);
			map.put("rowPerPage", rowPerPage);
			map.put("searchWord", searchWord);
			map.put("totalRow", totalRow);
			map.put("lastPage", lastPage);
			map.put("list", list);
			
			return map;
		}
		
		//제휴병원 추가
		@Override
		public int addHospital(Hospital hospital) {
			System.out.println(":::HospitalServiceImpl - addHospital:::");
			System.out.println("hospital"+hospital);
			return adminMapper.insertHospital(hospital);
		}
		
		//제휴병원 삭제
		@Override
		public int removeHospital(int hospitalId) {
			System.out.println(":::HospitalServiceImpl - removeHospital:::");
			System.out.println("hospitalId"+hospitalId);
			return adminMapper.deleteHospital(hospitalId);
		}
		
		//제휴병원 상세정보
		@Override
		public List<Hospital> getHospitalOne(int hospitalId) {
			System.out.println(":::HospitalServiceImpl - getHospitalOne:::");
			System.out.println("hospitalId"+hospitalId);

			return adminMapper.hospitalOne(hospitalId);
		}
	// 회원 조회
	@Override
	public Map<String,Object> getAdminUserList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate) {
		System.out.println("::: AdminUserServiceImpl - adminSelectUserList :::");
		int beginRow = (currentPage-1)*rowPerPage;
		Page page = new Page();
		page.setSearchWord(searchWord);
		page.setToDate(toDate);
		page.setFromDate(fromDate);
		int totalRow = adminMapper.adminSelectUserCount(page);
		System.out.println("totalRow"+totalRow);
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
		List<User> list = adminMapper.adminSelectUserList(page);
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
		int checking = adminMapper.adminDeleteUser(checkBoxArr);
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
		int totalRow = adminMapper.adminSelectWithdrawUserCount(page);
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
		List<User> list = adminMapper.adminSelectWithdrawUserList(page);
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
		int checking = adminMapper.adminUpdateWithdrawUser(checkBoxArr);
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
		int totalRow = adminMapper.adminSelectExpertUserCount(page);
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
		List<User> list = adminMapper.adminSelectExpertUserList(page);
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
	//공지사항 리스트 가져오기
	@Override
	public Map<String, Object> getNoticeBoard(int currentPage, int rowPerPage, String searchWord) {
		System.out.println(":::AdminServiceImpl - getNoticeBoard:::");
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
		
		List<NoticeBoard> list = adminMapper.selectNoticeBoard(page);
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
	//공지사항 상세페이지 가져오기
	@Override
	public NoticeBoard getNoticeOne(int noticeId) {
		System.out.println(":::AdminServiceImpl - getNoticeOne");
		System.out.println("noticeId"+noticeId);
		
		return adminMapper.noticeBoardOne(noticeId);
	}
	//공지사항 추가
	@Override
	public int addNotice(NoticeBoard noticeBoard) {
		System.out.println(":::AdminServiceImpl - addNotice");
		System.out.println("NoticeBoard"+ noticeBoard);
		return adminMapper.insertNoticeBoard(noticeBoard);
	}
	//공지사항 삭제
	@Override
	public int removeNoticeBoard(int noticeId) {
		System.out.println(":::AdminServiceImpl - removeNoticeBoard:::");
		System.out.println("notice Id : " + noticeId);
		
		return adminMapper.deleteNoticeBoard(noticeId);
	}
	
	//신고내역 상세 페이지 가져오기
	@Override
	public ReportHistory getReportHistoryOne(int reportHistoryId) {
		System.out.println("::: AdminServiceImpl - getReportHistoryOne :::");
		return adminMapper.selectReportHistoryOne(reportHistoryId);
	}
	//문의내역 상세페이지 가져오기
	@Override
	public InquiryHistory getInquiryHistoryOne(int inquiryHistoryId) {
		System.out.println("::: AdminServiceImpl - getInquiryHistoryOne :::");
		return adminMapper.selectInquiryHistoryOne(inquiryHistoryId);
	}
	//신고내역 가져오기
	@Override
	public Map<String, Object> getReportHistoryList(int currentPage, int rowPerPage) {
		System.out.println("::: AdminServiceImpl - getReportHistoryList :::");
		
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
		System.out.println("::: AdminServiceImpl - getInquiryHistoryList :::");
		
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
	public List<QuestionCount> getYearlyQuestionCount() {
		System.out.println("::: AdminHomeServiceImpl - getYearlyQuestionCount :::");
		return adminMapper.selectYearlyQuestionCount();
	}

	@Override
	public List<QuestionCount> getCurrentQuestionCountFromFeild() {
		System.out.println("::: AdminHomeServiceImpl - getCurrentQuestionCountFromFeild :::");
		System.out.println(adminMapper.selectCurrentQuestionCountFromFeild());
		System.out.println("size -"+adminMapper.selectCurrentQuestionCountFromFeild().size());
		return adminMapper.selectCurrentQuestionCountFromFeild();
	}
	//검색 조건 카테고리 리스트 가져오기
	@Override
	public List<Feild> getFeildList() {
		System.out.println("::: AdminBoardServiceImpl - getAdminFeildList :::");
		return adminMapper.selectFeildList();
	}
	//질문 리스트 가져오기
	@Override
	public Map<String,Object> getQuestionBoardList(Page page,int currentPage) {
		System.out.println("::: AdminBoardServiceImpl - getAdminBoardList :::");
		
		//시작값 정하기
		int beginRow = (currentPage -1) * page.getRowPerPage();
		page.setBeginRow(beginRow);
		System.out.println(page.toString());
		//질문 리스트 전체 행의 갯수
		int totalCount = adminMapper.selectQuestionBoardTotalCount(page);
		System.out.println("totalCount : "+totalCount);
		//페이지 마지막값변수선언
		int lastPage = 1;
		//페이지갯수값 저장
		if(totalCount%page.getRowPerPage() == 0) {
			lastPage = totalCount/page.getRowPerPage();
		} else {
			lastPage = (totalCount/page.getRowPerPage())+1;
		}
		System.out.println("lastPage : "+lastPage);
		// 질문 리스트 저장
		List<QuestionBoard> list = adminMapper.selectQuestionBoardList(page);
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
