package com.example.codeblue.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.mapper.UserMapper;
import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.AnswerComment;
import com.example.codeblue.vo.AnswerVote;
import com.example.codeblue.vo.Expert;
import com.example.codeblue.vo.FaqBoard;
import com.example.codeblue.vo.Hospital;
import com.example.codeblue.vo.Inquiry;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.InquiryHistoryAnswer;
import com.example.codeblue.vo.Manager;
import com.example.codeblue.vo.NoticeBoard;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionComment;
import com.example.codeblue.vo.QuestionVote;
import com.example.codeblue.vo.Report;
import com.example.codeblue.vo.ReportHistory;
import com.example.codeblue.vo.ServiceCategory;
import com.example.codeblue.vo.Tag;
import com.example.codeblue.vo.User;

@Transactional
@Service
public class UserServiceImpl implements UserService{
	@Autowired UserMapper userMapper; 
	@Autowired JavaMailSender javaMailSender;
	
	// 태그 리스트 출력
	@Override
	public List<Map> getTagList(Page page) {
		System.out.println("::: UserServiceImpl - getTagList :::");
		System.out.println(page);
		List<Map> map = userMapper.selectTagList(page);
		return map;
	}
	// 태그 전체 행 수 
	@Override
	public int getTagTotalRow() {
		System.out.println("::: UserServiceImpl - getTagTotalRow :::");
		return userMapper.selectTagTotalRow();
	}
	
	//해당 유저정보 
	@Override
	public User getUserOne(String userId) {
		System.out.println(":::UserServiceImp - getUserOne:::");
		
		return userMapper.selectUserOne(userId);
	}
	
	//유저 질문 수 
	@Override
	public int questionBoardCount(String userId) {
		System.out.println(":::UserServiceImp - questionBoardCount:::");
		System.out.println("userId"+userId);
		return userMapper.selectQuestionBoardCount(userId);
	}
	
	//해당 유저 질문수 차트
	@Override
	public List<QuestionBoard> getQuestionChart(String userId) {
		System.out.println("::::UserServiceImp - getQuestionChart");
		System.out.println("userId"+userId);
		return userMapper.selectQuestionChart(userId);
	}
	
	//해당유저 질문수 리스트(페이징)
	@Override
	public Map<String, Object> getQuestionBoardPaging(int currentPage, int rowPerPage, String userId) {
		System.out.println(":::UserServiceImp - getQuestionBoardPaging");
		System.out.println("currentPage :"+currentPage +"/rowPerPage :"+rowPerPage);
		
		
		Page page = new Page();
		
		int beginRow = (currentPage-1)*rowPerPage;
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setUserId(userId);
		
		System.out.println(page.toString());
		
		int totalRow = userMapper.selectQuestionBoardCount(userId);
		int lastPage = totalRow/rowPerPage;
		
		if( totalRow%rowPerPage==0) {
			lastPage = totalRow/rowPerPage;
		}else {
			lastPage = (totalRow/rowPerPage)+1;
		}
		
		List<QuestionBoard> list = userMapper.selectQuestionPaging(page);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("lastPage",lastPage);
		map.put("list", list);
		map.put("beginRow", beginRow);
		
		return map;
	}
	
	//해당유저 댓글 리스트(페이징)
	@Override
	public Map<String, Object> getCommentBoardPaging(int currentPage, int rowPerPage, String userId) {
		System.out.println(":::UserServiceImp - getCommentBoardPaging:::");
		System.out.println("currentPage : "+currentPage +"/rowPerPage :"+rowPerPage+"/userId:"+userId);
		
		rowPerPage =10;
		
		Page page = new Page();
		
		int beginRow = (currentPage-1)*rowPerPage;
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setUserId(userId);
		
		System.out.println(page.toString());
		
		int totalRow = userMapper.selectQuestionUserCommentCount(userId);
		int lastPage = totalRow/rowPerPage;
		
		if( totalRow%rowPerPage==0) {
			lastPage = totalRow/rowPerPage;
		}else {
			lastPage = (totalRow/rowPerPage)+1;
		}
		
		List<QuestionComment> list = userMapper.selectCommentPaging(page);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("lastPage",lastPage);
		map.put("list", list);
		map.put("beginRow", beginRow);
		return map;
	}	
		
	//해당유저 댓글 수
	@Override
	public int questionCommentCount(String userId) {
		System.out.println(":::UserServiceImp - selectCommentCount");
		System.out.println("userId"+userId);
		return userMapper.selectQuestionUserCommentCount(userId);
	}

	//해당유저 답글 리스트(페이징)
	@Override
	public Map<String, Object> getAnswerPaging(int currentPage, int rowPerPage, String userId) {
		System.out.println(":::UserServiceImp - getAnswerPaging:::");
		System.out.println("currentPage : "+currentPage +"/rowPerPage :"+rowPerPage+"/userId:"+userId);
		
		
		Page page = new Page();
		
		int beginRow = (currentPage-1)*rowPerPage;
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setUserId(userId);
		
		System.out.println(page.toString());
		
		int totalRow = userMapper.selectAnswerCount(userId);
		int lastPage = totalRow/rowPerPage;
		
		if( totalRow%rowPerPage == 0) {
			lastPage = totalRow/rowPerPage;
		}else {
			lastPage = (totalRow/rowPerPage)+1;
		}
		
		List<Answer> list = userMapper.selectQuestionAnswerPaging(page);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("lastPage",lastPage);
		map.put("list", list);
		map.put("beginRow", beginRow);
		return map;
	}
	
	//해당유저 답글 수
	@Override
	public int answerCount(String userId) {
		System.out.println(":::UserServiceImp - answerCount:::");
		System.out.println("userId"+userId);
		return userMapper.selectAnswerCount(userId);
	}
	
	//해당유저 답글 수 차트
	@Override
	public List<Answer> getAnswerChart(String userId) {
		System.out.println(":::UserServiceImp - getAnswerChart:::");
		System.out.println("userId"+userId);
		return userMapper.selectAnswerChart(userId);
	}
	//유저 질문글 추천 수
	@Override
	public int getUserVote(String userId) {
		System.out.println(":::UserServiceImp - getUserVote:::");
		System.out.println("userId"+userId);
		return userMapper.selectUserVote(userId);
	}
	
	//유저 질문글 추천 중복검사 및 추천
	@Override
	public int getQuestionVoteCheck(QuestionVote questionVote) {
		System.out.println(":::UserServiceImp - getQuestionVoteCheck:::");
		System.out.println("questionid"+questionVote);
		
		if(userMapper.selectQuestionVoteCheck(questionVote) == null) {
			System.out.print("추천!");
			return userMapper.insertQuestionVote(questionVote);
		}
		return 0;
	}	
	
	//유저 답변글 추천 중복검사 및 추천
	@Override
	public int getAnswerVoteCheck(AnswerVote answerVote) {
		System.out.println(":::UserServiceImp - getAnswerVoteCheck:::");
		System.out.println("anwerVote"+answerVote);
		
		if(userMapper.selectAnswerVoteCheck(answerVote) == null) {
			System.out.print("추천!");
			return userMapper.insertAnswerVote(answerVote);
		}
		return 0;
	}
		
	//유저가 사용한 태그 수
	@Override
	public int getUserTagCount(String userId) {
		System.out.println(":::UserServiceImp - getUserTagCount:::");
		System.out.println("userId"+userId);
		return userMapper.selectUserTagTotalRow(userId);
	}
	
	//유저가 사용한 태그 페이징
	@Override
	public Map<String, Object> getUserTagPaging(int currentPage, int rowPerPage, String userId) {
		System.out.println(":::UserServiceImp - getUserTagPaging:::");
		System.out.println("currentPage : "+currentPage +"/rowPerPage :"+rowPerPage+"/userId:"+userId);
		
		int totalRow = userMapper.selectUserTagTotalRow(userId);
		System.out.println("totalRow"+totalRow);
		
		int beginRow = (currentPage-1)*rowPerPage;
		Page page = new Page();
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setUserId(userId);
		
		int lastPage = totalRow/rowPerPage;
		if(totalRow % rowPerPage !=0) {
			lastPage = (totalRow/rowPerPage)+1;
		}else {
			lastPage = totalRow/rowPerPage;
		}
		
		
		List<Tag> list = userMapper.selectUserTagPaging(page);
		System.out.println(list.toString());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("rowPerPage", rowPerPage);
		map.put("currentPage", currentPage);
		map.put("userId", userId);
		map.put("lastPage", lastPage);
		map.put("beginRow", beginRow);
		return map;
	}
	
	//질문글 수정
	@Override
	public int modifyQuestion(QuestionBoard questionBoard) {
		System.out.println(":::UserServiceImp - getUserTagPaging:::");
		System.out.println(questionBoard.toString());
		
		return userMapper.updateQuestion(questionBoard);
	}
	
	//답변 상세정보
	@Override
	public Answer getAnswerOne(String answerId) {
		System.out.println("::: AdminBoardServiceImpl - getAnswerOne :::");
		return userMapper.selectAnswerOne(answerId);
	}
	//신고내역 저장하기
	@Override
	public void addReportHistory(ReportHistory reportHistory) {
		System.out.println("::: AdminServiceImpl - addReport :::");
		userMapper.insertReportHistory(reportHistory);
	}
	//신고창 카테고리
	@Override
	public List<Report> getReportList() {
		System.out.println("::: AdminServiceImpl - getReportList :::");
		return userMapper.selectReport();
	}
	
	//질문 답변 댓글 총 개수 가져오기
	@Override
	public int getAnswerCommentCount(int answerId) {
		System.out.println("::: UserServiceImpl - getAnswerCommentCount :::");
		return userMapper.selectAnswerCommentCount(answerId);
	}
	//질문 댓글 추가하기.
	@Override
	public int addQeustionComment(QuestionComment questionComment) {
		System.out.println("::: UserServiceImpl - addQeustionComment :::");
		userMapper.insertQuestionComment(questionComment);
		return userMapper.selectQuestionCommentTotal(questionComment.getQuestionBoard().getQuestionId());
	}
	//질문 답변 댓글 추가하기
	@Override
	public int addAnswerComment(AnswerComment answerComment) {
		System.out.println("::: UserServiceImpl - addAnswerComment :::");
		System.out.println("answerComment : "+ answerComment.toString());
		return userMapper.insertAnswerComment(answerComment);
	}
	//질문 답변 추가하기
	@Override
	public int addAnswer(Answer answer) {
		System.out.println("::: UserServiceImpl - addAnswer :::");
		return userMapper.insertAnswer(answer);
	}
	// 질문 답변글 리스트 가져오기
	@Override
	public List<Answer> getAnswerList(int questionId) {
		System.out.println("::: UserServiceImpl - getAnswerList :::");
		List<Answer> list =userMapper.selectAnswerList(questionId);
		System.out.println(list.toString());
		return userMapper.selectAnswerList(questionId);
	}
	// 질문 답변 댓글 리스트 가져오기
	@Override
	public List<AnswerComment> getAnswerCommentList(int answerId) {
		System.out.println("::: UserServiceImpl - getAnswerCommentList :::");
		return userMapper.selectAnswerCommentList(answerId);
	}
	@Override
	public User selectUserOne(String UserId) {
		System.out.println("::: ProfileServiceImpl - selectUserOne :::");
		User user = userMapper.selectUserOne(UserId);
		System.out.println(user);
		return user;
	}
	@Override
	public int addQuestion(QuestionBoard questionBoard) {
		System.out.println("::: AskServiceImpl - addQuestion :::");
		return userMapper.insertQuestion(questionBoard);
	}
	
	@Override
	public List<QuestionComment> getQuestionCommentList(int questionId) {
		System.out.println("::: QuestionBoardServiceImpl - getQuestionCommentList :::");
		return userMapper.selectQuestionCommentList(questionId);
	}
	
	@Override
	public QuestionBoard getQuestionBoardOne(int questionId) {
		System.out.println("::: QuestionBoardServiceImpl - getQuestionBoardOne :::");
		QuestionBoard questionBoard = userMapper.selectQuestionBoardOne(questionId);
		questionBoard.setCommentCount(userMapper.selectQuestionCommentCount(questionId));
		System.out.println(questionBoard.toString());
		return questionBoard;
	}
	
	@Override
	public Map<String,Object> getQuestBoardList(int currentPage, int rowPerPage, String searchWord,String searchCategory, int feildId) {
		System.out.println("::: QuestionBoardServiceImpl - getQuestBoardList :::");
		//페이징객체 생성
		Page page = new Page();
		//페이징 시작값
		int beginRow = (currentPage -1) * rowPerPage;
		//페이징 객체 값을 저장
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setSearchWord(searchWord);
		page.setSearchCategory(searchCategory);
		//질문 리스트 전체 행의 갯수
		int totalCount = userMapper.selectQuestionBoardTotalCount(page);
		//페이지 마지막값변수선언
		int lastPage = 0;
		//페이지갯수값 저장
		if(totalCount%rowPerPage == 0) {
			lastPage = totalCount/rowPerPage;
		} else {
			lastPage = (totalCount/rowPerPage)+1;
		}
		page.setFeildId(feildId);
		
		System.out.println(page.toString());
		
		// 질문 리스트 저장
		List<QuestionBoard> list = userMapper.selectQuestionBoardList(page);
//		// 각질문에 해당하는 갯수 뽑기
//		for(int i=0; i<list.size(); i++) {
//			list.get(i).setAnswerCount(userMapper.selectQuestionBoardAnswerCount(list.get(i)));
//			list.get(i).setVoteCount(userMapper.selectQuestionBoardVotes(list.get(i)));
//		}
		System.out.println(list.toString());
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("lastPage", lastPage);
		map.put("currentPage",currentPage);
		map.put("list",list);
		map.put("totalCount",totalCount);
		map.put("searchWord",searchWord);
		return map;
	}
	@Override
	public NoticeBoard getNoticeBoardOne(int noticeId) {
		System.out.println("::: NoticeBoardServiceImpl - getNoticeBoardOne :::");
		return userMapper.selectNoticeBoardOne(noticeId);
	}
	
	@Override
	public Map<String, Object> getNoticeBoardList(int currentPage, int rowPerPage) {
		
		List<NoticeBoard> list = new ArrayList<>();
		System.out.println("::: NoticeBoardServiceImpl - getNoticeBoardList :::");
		System.out.println("currentPage : " + currentPage);
		System.out.println("rowPerPage :  " + rowPerPage);
		
		
		Page page = new Page();
		page.setRowPerPage(rowPerPage);
		page.setBeginRow((currentPage-1)*rowPerPage);
		
		int totalRow = userMapper.noticeBoardTotalRow();
		int lastPage = totalRow/rowPerPage;
		
		if(totalRow % rowPerPage != 0) {
			lastPage ++;
		}
		
		list = userMapper.selectNoticeBoardList(page);
		System.out.println(list);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalRow", totalRow);
		map.put("list", list);
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("lastPage", lastPage);
			
		System.out.println(map.toString());
		System.out.println("-------------------");
		return map;
	}
	
	@Override
	public User verifyUser(User user) {
		System.out.println("::: UserServluceImpl - verifyUser :::");
		return userMapper.selectUserId(user);
	}
	
	//회원가입
	@Override
	public int addUser(User user) { 
		System.out.println("::: UserServluceImpl - addUser :::");
		int rs = userMapper.insertUser(user);
		return rs;
	}
	
	//회원가입 메일 보내기
	@Override
	public String sendCodeToMail(User user) {	        
		System.out.println("::: UserServluceImpl - sendCodeToMail :::");
		
		String randNum = ""+(int)(Math.random()*100000)+1;
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	    
	    simpleMailMessage.setTo(user.getUserId()); 
	    simpleMailMessage.setSubject("코드블루 인증코드입니다. 💙");
	    simpleMailMessage.setText(user.getUserName()+"님! 인증코드는  ["+randNum+"]입니다. 인증코드 입력란에 입력해주셔야 회원가입이 완료 됩니다! :) 감사합니다. 😍");
	    System.out.println("인증번호: " + randNum);
	    
	    javaMailSender.send(simpleMailMessage);
	    return randNum;
	}

	@Override
	public int addExpert(Expert expert) {
		System.out.println("::: UserServluceImpl - addExpert :::"); 
		return userMapper.insertExpert(expert);
	}

	@Override
	public String resetPassword(User user) {
		System.out.println("::: UserServluceImpl - resetPassword :::"); 
		System.out.println(user.toString());
		
		if(userMapper.selectUserId(user) == null) {
			return "noSuchUser";
		}
		
		String randNum = sendCodeToMail(user);
		return randNum;
	}

	@Override
	public String getUserIdForCheck(User user) {
		System.out.println("::: UserServluceImpl - verifyUserForReset :::");
		
		if(userMapper.selectUserIdForCheck(user) == null) {
			return null;
		}
		
		String randNum = sendCodeToMail(user);
		return randNum;
	}

	@Override
	public int modifyUserPw(User user) {
		System.out.println("::: UserServluceImpl - modifyUserPw :::");
		return userMapper.updateUserPw(user);
	}
	
	@Override 
	public Map<String, Object> getHospitalList(int currentPage, int rowPerPage, String searchWord) {
		System.out.println(":::UserServiceImpl - getHospitalList:::");
				
		int totalRow = userMapper.hospitalCount();
		int lastPage = 0;
		int beginRow = (currentPage-1)*rowPerPage;
		Page page = new Page();
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setSearchWord(searchWord);
		
		
		
		if(totalRow % rowPerPage ==0) {
			lastPage = totalRow/rowPerPage;
		}else {
			lastPage = (totalRow/rowPerPage)+1;
		}		
		List<Hospital> list = new ArrayList<Hospital>();
		list = userMapper.hospitalList(page);
		
		
		Map<String,Object> map = new  HashMap<String, Object>();
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		map.put("totalRow", totalRow);
		map.put("lastPage", lastPage);
		map.put("list", list);
		
		System.out.println(list.toString());
		return map;
	}
	
	@Override
	public List<Hospital> getHospitalOne(int hospitalId) {
		System.out.println(":::HospitalServiceImpl - getHospitalOne:::");
		System.out.println("hospitalId"+hospitalId);

		return userMapper.hospitalOne(hospitalId);
	}
	// 유저 조회
	@Override
	public Map<String, Object> getUserList(int currentPage, int rowPerPage, String searchWord) {
		System.out.println("::: UserServiceImpl - selectUserList :::");
		int beginRow = (currentPage-1)*rowPerPage;
		// page에 담아서 mapper의 parm으로 사용
		Page page = new Page();
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setSearchWord(searchWord);
		System.out.println(page.toString());
		// 전체행의 수
		int totalRow = userMapper.selectUserCount(page);
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
		List<User> list = userMapper.selectUserList(page);
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
		System.out.println("::: UserServiceImpl - selectServiceCategoryList :::");
		List<ServiceCategory> list = userMapper.selectServiceCategoryList();
		System.out.println(list.toString());
		return list;
	}
	// faq 리스트 조회
	@Override
	public Map<String, Object> getFaqList(int currentPage, int rowPerPage, String searchCategory) {
		System.out.println("::: UserServiceImpl - selectFaqList :::");
		int beginRow = (currentPage-1)*rowPerPage;
		Page page = new Page();
		page.setBeginRow(beginRow);
		page.setRowPerPage(rowPerPage);
		page.setSearchCategory(searchCategory);
		// 전체행의 수
		int totalRow = userMapper.selectFaqCount(page);
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
		List<FaqBoard> list = userMapper.selectFaqList(page);
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
		System.out.println("::: UserServiceImpl - selectFaqOne :::");
		List<FaqBoard> list = userMapper.selectFaqOne(faqId);
		return list;
	}
	
	
	//문의 답변 가져오기
	@Override
	public InquiryHistoryAnswer getInquiryHistoryAnswerOne(int inquiryHistoryId) {
		System.out.println("::: AdminServiceImpl - getInquiryHistoryOne :::");
		return userMapper.selectInquiryHistoryAnswerOne(inquiryHistoryId);
	}
	//문의 상세내용
	@Override
	public InquiryHistory getInquiryHistoryOne(int inquiryHistoryId) {
		System.out.println("::: AdminServiceImpl - getInquiryHistoryOne :::");
		return userMapper.selectInquiryHistoryOne(inquiryHistoryId);
	}
	//문의 저장
	@Override
	public void addInquiryHistory(InquiryHistory inquiryHistory) {
		System.out.println("::: AdminServiceImpl - addReport :::");
		userMapper.insertInquiryHistory(inquiryHistory);
		
	}
	// 방금 등록한 질문 번호
	@Override
	public int getLastQuestionId() {
		System.out.println("::: UserServiceImpl - getLastQuestionId :::");
		return userMapper.selectLastInsertQuestionId();
	}
	// inquiry 출력
		@Override
		public List<Inquiry> getInquiryList() {
			System.out.println("::: UserServiceImpl - selectInquiry :::");
			List<Inquiry> list = userMapper.selectInquiry();
			System.out.println(list);
			return list;
		}
		// inquiry 히스토리출력(자신이 올린 글만)
		@Override
		public Map<String, Object> getInquiryHistoryBoard(int currentPage, int rowPerPage, String loginUserId, String searchCategory) {
			System.out.println("::: UserServiceImpl - selectInquiryHistory :::");
			// 페이징
			int beginRow = (currentPage-1)*rowPerPage;
			Page page = new Page();
			page.setBeginRow(beginRow);
			page.setRowPerPage(rowPerPage);
			page.setUserId(loginUserId);
			page.setSearchCategory(searchCategory);
			// 전체행의 수
			int totalRow = userMapper.selectInquiryHistoryCount(page);
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
			List<InquiryHistory> list = userMapper.selectInquiryHistory(page);
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
	// 태그 등록
	@Override
	public int addTag(String tags, int questionId) {
		System.out.println("::: UserServiceImpl - addTag :::");
		System.out.println(questionId+"번 질문의 테그: "+tags);
		String[] tagSplit = tags.split("#");
		System.out.println(Arrays.toString(tagSplit));
		
		if(Arrays.toString(tagSplit) == null) {
			System.out.println("warning! null !@!!");
			return 0;
		}
		int total=0;
		Map map = new HashMap<String, String>();
		map.put("questionId", questionId);
		
		for(int i=1;i<tagSplit.length;i++) {
			String tagName = tagSplit[i];
			System.out.println(tagName);
			map.put("tagName", tagName);
			total += userMapper.insertTag(map);
		}
		
		System.out.println("return.");		
		return total;
	}
	
	@Override
	public void modifyUserProfile(User user) {
		System.out.println("::: UserServiceImpl - modifyUserProfile :::");
		userMapper.updateUserProfile(user);

	}
	
}
