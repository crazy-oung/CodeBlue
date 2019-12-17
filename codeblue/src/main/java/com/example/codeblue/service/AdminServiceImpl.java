package com.example.codeblue.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.mapper.AdminMapper;
import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.AnswerComment;
import com.example.codeblue.vo.FaqBoard;
import com.example.codeblue.vo.Feild;
import com.example.codeblue.vo.Hospital;
import com.example.codeblue.vo.Inquiry;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.InquiryHistoryAnswer;
import com.example.codeblue.vo.Manager;
import com.example.codeblue.vo.NoticeBoard;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionComment;
import com.example.codeblue.vo.QuestionCount;
import com.example.codeblue.vo.Report;
import com.example.codeblue.vo.ReportHistory;
import com.example.codeblue.vo.ServiceCategory;
import com.example.codeblue.vo.User;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired private AdminMapper adminMapper;
	@Autowired private JavaMailSender javaMailSender;
	// 유저 활동지 통계
	@Override
	public Map<String, Object> getUserRegionCount() {
		System.out.println("::: AdminServiceImpl - getUserRegionCount :::");
		return adminMapper.selectUserRegionCount();
	}
	// 문의 처리율
	@Override
	public double getInqueryAnswerPercentage() {
		System.out.println("::: AdminServiceImpl - getInqueryAnswerPercentage :::");
		return adminMapper.selectInqueryAnswerPercentage();
	}
	// 문의 답변 
	@Override
	public InquiryHistoryAnswer getInquiryHistoryAnswerOne(int inquiryHistoryId) {
		System.out.println("::: AdminServiceImpl - getInquiryHistoryAnswerOne :::");
		return adminMapper.selectInquiryHistoryAnswerOne(inquiryHistoryId);
	}
	//신고 대상(질문)상세 정보 가져오기
	@Override
	public QuestionBoard getReportQuestionBoardOne(int questionId) {
		System.out.println("::: AdminServiceImpl - getReportQuestionBoardOne :::");
		return adminMapper.selectReportQuestionBoardOne(questionId);
	}
	//신고 대상(답변)상세 정보 가져오기
	@Override
	public Answer getReportAnswerOne(int answerId) {
		System.out.println("::: AdminServiceImpl - getReportAnswerOne :::");
		return adminMapper.selectReportAnswerOne(answerId);
	}
	//Report 카테고리 가져오기
	@Override
	public List<Report> getReportList() {
		System.out.println(":::AdminServiceImpl - getReportList:::");
		return adminMapper.selectReportList();
	}
	
	//신고내역 리스트 삭제
	public void removeReportHistoryList(List<String> reportHistoryIdList) {
		System.out.println("::: AdminBoardServiceImpl - removeReportHistoryList	 :::");
		System.out.println(reportHistoryIdList.toString());
		adminMapper.deleteReportHistoryList(reportHistoryIdList);
		System.out.println("신고내역 지우기 성공");
	}
	
	//Inquiry 리스트 삭제
	@Override
	public void removeInquiryHistoryList(List<String> inquiryHistoryIdList) {
		System.out.println("::: AdminBoardServiceImpl - removeInquiryHistoryList :::");
		System.out.println(inquiryHistoryIdList.toString());
		adminMapper.deleteInquiryHistoryAnswerList(inquiryHistoryIdList);
		adminMapper.deleteInquiryHistoryList(inquiryHistoryIdList);
		System.out.println("문의내역 지우기 성공");
	}
	//Inquiry 카테고리 가져오기
	@Override
	public List<Inquiry> getInquiryList() {
		System.out.println(":::AdminServiceImpl - getInquiryList:::");
		return adminMapper.selectInquiryList();
	}
	//공지사항 리스트 삭제
	@Override
	public void removeNoticeBoardList(List<String> noticeBoardIdList) {
		System.out.println("::: AdminServiceImpl - removeNoticeBoardList :::");
		System.out.println(noticeBoardIdList.toString());
		adminMapper.deleteNoticeBoardList(noticeBoardIdList);
		System.out.println("공지사항 지우기 성공");
	}
	
	//답변 댓글 지우기
	@Override
	public void removeAnswerCommentList(List<String> answerCommentIdList) {
		System.out.println("::: AdminBoardServiceImpl - removeAnswerCommentList :::");
		System.out.println(answerCommentIdList.toString());
		//댓글 지우기
		adminMapper.deleteAnswerCommentId(answerCommentIdList);
		System.out.println("답변 댓글 지우기 성공");
	}
	//답변 댓글 리스트 가져오기
	@Override
	public Map<String, Object> getAnswerCommentList(Page page, int currentPage) {
		System.out.println("::: AdminBoardServiceImpl - getAnswerCommentList :::");
		
		//시작값 정하기
		int beginRow = (currentPage -1) * page.getRowPerPage();
		page.setBeginRow(beginRow);
		System.out.println(page.toString());
		//질문 리스트 전체 행의 갯수
		int totalCount = adminMapper.selectAnswerCommentTotalCount(page);
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
		List<AnswerComment> list = adminMapper.selectAnswerCommentList(page);
		System.out.println(list.toString());
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("lastPage", lastPage);
		map.put("currentPage",currentPage);
		map.put("list",list);
		map.put("totalCount",totalCount);
		map.put("searchWord",page.getSearchWord());
		return map;
	}
	//질문 댓글 삭제하기
	@Override
	public void removeQuestionCommentList(List<String> questionCommentIdList) {
		System.out.println("::: AdminBoardServiceImpl - removeQuestionComment :::");
		System.out.println(questionCommentIdList.toString());
		//댓글 지우기
		adminMapper.deleteQuestionCommentId(questionCommentIdList);
		System.out.println("질문 댓글 지우기 성공");
	}
	//질문 댓글 리스트 가져오기
	@Override
	public Map<String, Object> getQuestionCommentList(Page page, int currentPage) {
		System.out.println("::: AdminBoardServiceImpl - getQuestionCommentList :::");
		
		//시작값 정하기
		int beginRow = (currentPage -1) * page.getRowPerPage();
		page.setBeginRow(beginRow);
		System.out.println(page.toString());
		//질문 리스트 전체 행의 갯수
		int totalCount = adminMapper.selectQuestionCommentTotalCount(page);
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
		List<QuestionComment> list = adminMapper.selectQuestionCommentList(page);
		System.out.println(list.toString());
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("lastPage", lastPage);
		map.put("currentPage",currentPage);
		map.put("list",list);
		map.put("totalCount",totalCount);
		map.put("searchWord",page.getSearchWord());
		return map;
	}

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
	public void addInquiryHistoryAnswer(InquiryHistoryAnswer inqruiyHistoryAnswer) {
		System.out.println(":::AdminServiceImpl - addInquiryHistoryAnswer:::");
		int row = adminMapper.insertInquiryHistoryAnswer(inqruiyHistoryAnswer);
		if(row != 0 ) {
			adminMapper.updateInquiryHistory(inqruiyHistoryAnswer.getInquiryHistory().getInquiryHistoryId());
		}
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
	//FAQ 리스트 삭제
	@Override
	public void removeFaqBoardList(List<String> faqBoardIdList) {
		System.out.println("::: AdminBoardServiceImpl - removeFaqBoardList :::");
		System.out.println(faqBoardIdList.toString());
		adminMapper.deleteFaqBoardList(faqBoardIdList);
		System.out.println("공지사항 지우기 성공");
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
	public Map<String, Object> getFaqBoardList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate, String serviceCategoryId) {
		System.out.println(":::AdminServiceImpl - getFaqBoardList:::");
		System.out.println("currentPage :"+currentPage+"/rowPerPage :"+rowPerPage);

		Page page = new Page();
		page.setBeginRow((currentPage-1)*rowPerPage);
		page.setRowPerPage(rowPerPage);
		page.setSearchWord(searchWord);
		page.setToDate(toDate);
		page.setFromDate(fromDate);
		page.setSearchCategory(serviceCategoryId);
		System.out.println("setBeginRow" + page.getBeginRow());
		System.out.println("setRowPerPage" + page.getRowPerPage());
		System.out.println("setSearchWord" + page.getSearchWord());
		System.out.println("toDate  : " + page.getToDate());
		System.out.println("fromDate" + page.getFromDate());
		System.out.println("searchCategory : "+page.getSearchCategory());
		int totalRow = adminMapper.selectFaqBoardTotalCount(page);
		int lastPage = 0;
		
		if(totalRow % rowPerPage != 0) {
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
		map.put("toDate", toDate);
		map.put("fromDate", fromDate);		
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
		public Map<String, Object> getNoticeBoard(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate) {
			System.out.println(":::AdminServiceImpl - getNoticeBoard:::");
			System.out.println("currentPage :"+currentPage+"/rowPerPage :"+rowPerPage);
			
			int beginRow = (currentPage-1)*rowPerPage;
			Page page = new Page();
			page.setBeginRow(beginRow);
			page.setRowPerPage(rowPerPage);
			page.setSearchWord(searchWord);
			page.setToDate(toDate);
			page.setFromDate(fromDate);
			
			System.out.println(page.getSearchWord());
			System.out.println(page.getToDate());
			System.out.println(page.getFromDate());
			int totalRow = adminMapper.selectNoticeBoardCount(page);
			int lastPage = 0;
			
			if(totalRow % rowPerPage !=1) {
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
			map.put("toDate", toDate);
			map.put("fromDate", fromDate);
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
	public Map<String, Object> getReportHistoryList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate, String reportId, String reportCategory) {
		System.out.println("::: AdminServiceImpl - getReportHistoryList :::");
		
		Page page = new Page();
		page.setRowPerPage(rowPerPage);
		page.setBeginRow((currentPage-1)*rowPerPage);
		page.setSearchWord(searchWord);
		page.setToDate(toDate);
		page.setFromDate(fromDate);
		page.setSearchCategory(reportId);
		page.setReportCategory(reportCategory);
		
		System.out.println(page.getSearchWord());
		System.out.println(page.getToDate());
		System.out.println(page.getFromDate());
		System.out.println(page.getSearchCategory());
		System.out.println(page.getReportCategory());

		int totalRow = adminMapper.selectReportHistoryTotalRow(page);
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
		map.put("searchWord", searchWord);
		map.put("toDate", toDate);
		map.put("fromDate", fromDate);
		map.put("reportCategory", reportCategory);
		System.out.println(map.toString());
		return map;
	}
	
	//문의 내역 리스트 가져오기
	@Override
	public Map<String, Object> getInquiryHistoryList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate, String inquiryId, String inquiryCategory) {
		System.out.println("::: AdminServiceImpl - getInquiryHistoryList :::");
		
		Page page = new Page();
		page.setRowPerPage(rowPerPage);
		page.setBeginRow((currentPage-1)*rowPerPage);
		page.setSearchWord(searchWord);
		page.setSearchCategory(inquiryId);
		page.setToDate(toDate);
		page.setFromDate(fromDate);
		page.setReportCategory(inquiryCategory);
		int totalRow = adminMapper.InquiryHistoryTotalRow(page);
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
		map.put("searchWord", searchWord);
		map.put("toDate", toDate);
		map.put("fromDate", fromDate);	
		map.put("inquiryCategory", inquiryCategory);
		System.out.println(map.toString());
		return map;
	}
	// 연간 등록 질문수
	@Override
	public List<QuestionCount> getYearlyQuestionCount() {
		System.out.println("::: AdminHomeServiceImpl - getYearlyQuestionCount :::");
		return adminMapper.selectYearlyQuestionCount();
	}
	// 분야별 질문수 
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
	// 관리자 등록
	@Override
	public int addAdministrator(Manager manager) {
		System.out.println("::: AdminServluceImpl - addaAdministrator :::"); 
		
		int a = adminMapper.insertAdministrator(manager);
		
		System.out.println(manager.toString());
		return a;
	}
	// 관리자 등록용 인증코드 전송
	@Override
	public String sendCodeToMail(Manager manager) {	        
		System.out.println("::: AdminServluceImpl - sendCodeToMail :::");
		
		String randNum = ""+(int)(Math.random()*100000)+1;
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	    
	    simpleMailMessage.setTo(manager.getManagerId()); 
	    simpleMailMessage.setSubject("코드블루 관리자 인증코드입니다. ");
	    simpleMailMessage.setText(manager.getManagerName()+"님! 어드민 추가관련 인증코드는  ["+randNum+"]입니다. 인증코드 입력란에 입력해주셔야 관리자 추가가 완료 됩니다! :) 감사합니다. 😍");
	    System.out.println("인증번호: " + randNum);
	    
	    javaMailSender.send(simpleMailMessage);
	    return randNum;
	}
	
	@Override
	public Manager verifyManager(User user) {
		System.out.println("::: UserServluceImpl - verifyManager :::"); 
		return adminMapper.selectManagerId(user);
	}
	// 관리자 전체 리스트 가져오기
	@Override
	public Map<String, Object> getManagerList(int currentPage, int rowPerPage){
		System.out.println("::: AdminServiceImpl - getManagerList :::");
		
		Page page = new Page();
		
		
		
		rowPerPage = 10;
		int beginRow = (currentPage -1)* rowPerPage;
		page.setRowPerPage(rowPerPage);
		page.setBeginRow(beginRow);
	
		int totalCount = adminMapper.selectManagerTotalCount(page);
		System.out.println("totalCount : "+totalCount);
		
		int lastPage = totalCount/rowPerPage;
		
		if(totalCount % rowPerPage != 0) {
			lastPage++;
		}
		System.out.println(page);
		System.out.println("lastPage : "+lastPage);
		List<Manager> list = adminMapper.selectManagerList(page);
		System.out.println("list to string : "+list.toString());
		
		Map<String, Object> map = new HashMap<>();	
		map.put("rowPerPage", rowPerPage);
		map.put("beginRow", beginRow);
		map.put("lastPage", lastPage);
		map.put("currentPage",currentPage);
		map.put("list",list);
		map.put("totalCount",totalCount);		
		return map;
	}
	// 관리자 삭제하기
	@Override
	public int removeManager(String managerId) {
		System.out.println("::: AdminServiceImpl - removeManager :::");
		System.out.println("YyjService ManagerId   :  " + managerId);
		
		return adminMapper.deleteManager(managerId);
	}
	// 관리자 상세보기 정보 가져오기
	@Override
	public Manager getManagerOne(String managerId) {
		System.out.println("::: AdminServiceImpl - getManagerOne :::");
		return adminMapper.selectManagerOne(managerId);
	}

}
