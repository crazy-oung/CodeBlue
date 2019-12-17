package com.example.codeblue.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeblue.service.UserService;
import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.AnswerComment;
import com.example.codeblue.vo.AnswerVote;
import com.example.codeblue.vo.Expert;
import com.example.codeblue.vo.FaqBoard;
import com.example.codeblue.vo.Hospital;
import com.example.codeblue.vo.Inquiry;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.InquiryHistoryAnswer;
import com.example.codeblue.vo.NoticeBoard;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.QuestionComment;
import com.example.codeblue.vo.QuestionVote;
import com.example.codeblue.vo.Report;
import com.example.codeblue.vo.ReportHistory;
import com.example.codeblue.vo.ServiceCategory;
import com.example.codeblue.vo.User;
@RestController
public class UserRestController {
	@Autowired UserService userService;
	
	// 태그 리스트 출력
	@GetMapping("/rest/getTagList")
	public	Map<String, Object> getTagList(Page page, int currentPage){
		System.out.println("::: get - getTagList :::");
		System.out.println(page);
		Map<String, Object> map = new HashMap<>();
		page.setBeginRow( (currentPage -1)*page.getBeginRow() );
		
		List<Map> list = userService.getTagList(page);
		System.out.println(list);

		map.put("list", list);
		int totalRow = userService.getTagTotalRow();
		int lastPage = totalRow/page.getRowPerPage();
		if(totalRow%page.getRowPerPage() != 0) {
			lastPage ++;
		}
		map.put("lastPage", lastPage);
		map.put("currentPage", currentPage);
		
		return map;
	}
	
	//프로필 정보 가져오기 
	@PostMapping("/rest/profile")
	public User postProfile(@RequestParam(value="userId")String userId){
		System.out.println(":::post - postProfile:::");
		System.out.println("userId"+userId);
		return userService.getUserOne(userId);
	}

	//유저 질문 리스트
	@PostMapping("/rest/profileQuestionBoard")
	public Map<String, Object> postProfileQuestionBoard(@RequestParam(value="userId")String userId,
														@RequestParam(value="currentPage", defaultValue="1")int currentPage,
														@RequestParam(value="rowPerPage", defaultValue="6")int rowPerPage){
		rowPerPage =6;
		System.out.println(":::post - postProfileQuestionBoard:::");
		System.out.println("userId"+userId);
		System.out.println("currentPage"+currentPage);
		System.out.println("rowPerPage"+rowPerPage);
		return userService.getQuestionBoardPaging(currentPage, rowPerPage, userId);
	}
	
	//유저 질문 리스트(페이징)
	@PostMapping("/rest/questionBoardPaging")
	public Map<String, Object> postQuestionBoardPaging(@RequestParam(value="userId")String userId,
														@RequestParam(value="currentPage", defaultValue="1")int currentPage,
														@RequestParam(value="rowPerPage", defaultValue="10")int rowPerPage){
		rowPerPage = 10;
		System.out.println(":::post - postQuestionBoardPaging");
		System.out.println("userId"+userId);
		System.out.println("currentPage"+currentPage);
		System.out.println("rowPerPage"+rowPerPage);
		return userService.getQuestionBoardPaging(currentPage, rowPerPage, userId);
	}
	
	//유저 질문 수(해당유저)
	@PostMapping("/rest/QuestionCount")
	public int postQuestionCount(@RequestParam(value="userId")String userId){
		System.out.println(":::post - postQuestionCount:::");
		System.out.println("userId"+userId);
		return userService.questionBoardCount(userId);
	}
	
	//유저 질문 수 차트
	@PostMapping("/rest/questionChart")
	public List<QuestionBoard> postQuestionChart(@RequestParam(value="userId")String userId) {
		System.out.println(":::post - postQuestionChart :::");
		System.out.println("userId"+userId);
		return userService.getQuestionChart(userId);
	}
	
	//유저 댓글 리스트
	@PostMapping("/rest/profileQuestionComment")
	public Map<String, Object> postProfileQuestionComment(@RequestParam(value="userId")String userId,
															@RequestParam(value="currentPage", defaultValue="1")int currentPage,
															@RequestParam(value="rowPerPage", defaultValue="6")int rowPerPage){
		rowPerPage = 6;
		System.out.println(":::post - postProfile:::");
		System.out.println("userId"+userId);
		System.out.println("currentPage"+currentPage);
		System.out.println("rowPerPage"+rowPerPage);
		return userService.getCommentBoardPaging(currentPage, rowPerPage, userId);
	}
	
	//유저 댓글 리스트(페이징)
	@PostMapping("/rest/questionCommentPaging")
	public Map<String, Object> postQuestionCommentPaging(@RequestParam(value="userId")String userId,
														@RequestParam(value="currentPage", defaultValue="1")int currentPage,
														@RequestParam(value="rowPerPage", defaultValue="10")int rowPerPage){
	rowPerPage = 10;
	System.out.println(":::post - postQuestionBoardPaging");
	System.out.println("userId"+userId);
	System.out.println("currentPage"+currentPage);
	System.out.println("rowPerPage"+rowPerPage);
	return userService.getCommentBoardPaging(currentPage, rowPerPage, userId);
	}
	
	//유저 댓글 수(해당유저)
	@PostMapping("/rest/CommentCount")
	public int postCommentCount(@RequestParam(value="userId")String userId){
		System.out.println(":::post - postCommentCount:::");
		System.out.println("userId"+userId);
		return userService.questionCommentCount(userId);
	}
	
	//유저 답글 수 차트
	@PostMapping("/rest/answerChart")
	public List<Answer> postAnswerChart(@RequestParam(value="userId")String userId){
		System.out.println(":::post - postAnswerChart:::");
		System.out.println("userId"+userId);
		return userService.getAnswerChart(userId);
	}
	
	//유저 답글 리스트
	@PostMapping("/rest/questionAnswer")
	public Map<String, Object> postQuestionAnswer(@RequestParam(value="userId")String userId,
												 @RequestParam(value="currentPage", defaultValue="1")int currentPage,
												 @RequestParam(value="rowPerPage", defaultValue="6")int rowPerPage){
		rowPerPage = 6;
		System.out.println(":::post - postQuestionAnswer:::");
		System.out.println("userId"+userId);
		System.out.println("currentPage"+currentPage);
		System.out.println("rowPerPage"+rowPerPage);
		return userService.getAnswerPaging(currentPage, rowPerPage, userId);
	}
	
	//유저 답글 리스트(페이징)
	@PostMapping("/rest/questionAnswerPaging")
	public Map<String, Object> postQuestionAnswerPaging(@RequestParam(value="userId")String userId,
														@RequestParam(value="currentPage", defaultValue="1")int currentPage,
														@RequestParam(value="rowPerPage", defaultValue="10")int rowPerPage){
		rowPerPage = 10;
		System.out.println(":::post - postQuestionAnswerPaging");
		System.out.println("userId"+userId);
		System.out.println("currentPage"+currentPage);
		System.out.println("rowPerPage"+rowPerPage);												
		return userService.getAnswerPaging(currentPage, rowPerPage, userId);
	}
	
	//유저 답글 수 
	@PostMapping("/rest/answerCount")
	public int postAnswerCount(@RequestParam(value="userId")String userId) {
		System.out.println(":::post - postAnswerCount");
		System.out.println("userId"+userId);
		return userService.answerCount(userId);
	}
	
	//해당 유저가 받은 추천 수
	@PostMapping("/rest/userVote")
	public int postUserVote(@RequestParam(value="userId")String userId) {
		System.out.println(":::post - postUserVote");
		System.out.println("userId"+userId);
		return userService.getUserVote(userId);
	}
	
	//게시글 추천 중복 검사 후 추천
	@PostMapping("/rest/questionVote")
	public int postQuestionVote(QuestionVote questionVote) {
		System.out.println(":::post - postQuestionVote");
		System.out.println("userId"+questionVote);
		return userService.getQuestionVoteCheck(questionVote);
	}
	
	//답글 추천 중복 검사 후 추천
	@PostMapping("/rest/answerVote")
	public int postAnswerVote(AnswerVote answerVote) {
		System.out.println(":::post - postAnswerVote");
		System.out.println("answerVote"+answerVote);
		return userService.getAnswerVoteCheck(answerVote);
	}
	
	//해당 유저가 사용한 태그리스트
	@PostMapping("/rest/userTagList")
	public Map<String, Object> postUserTagList(@RequestParam(value="userId")String userId,
												@RequestParam(value="currentPage", defaultValue="1")int currentPage,
												@RequestParam(value="rowPerPage", defaultValue="6")int rowPerPage) {
		
		rowPerPage = 6;
		System.out.println(":::post - postUserTagList");
		System.out.println("userId"+userId);
		System.out.println("currentPage"+currentPage);
		System.out.println("rowPerPage"+rowPerPage);
		return userService.getUserTagPaging(currentPage, rowPerPage, userId);
	}
	
	//해당 유저가 사용한 태그리스트(페이징)
	@PostMapping("/rest/userTagPaging")
	public Map<String, Object> postUserTagPaging(@RequestParam(value="userId")String userId,
												@RequestParam(value="currentPage", defaultValue="1")int currentPage,
												@RequestParam(value="rowPerPage", defaultValue="10")int rowPerPage){
		rowPerPage = 10;
		System.out.println(":::post - postUserTagPaging");
		System.out.println("userId"+userId);
		System.out.println("currentPage"+currentPage);
		System.out.println("rowPerPage"+rowPerPage);	
		
		return userService.getUserTagPaging(currentPage, rowPerPage, userId);
	}
	
	//해당 유저가 사용한 태그 수
	@PostMapping("/rest/userTagCount")
	public int postUserTagCount(@RequestParam(value="userId")String userId) {
		System.out.println(":::post - postUserTagCount");
		System.out.println("userId"+userId);
		return userService.getUserTagCount(userId);
	}
	
	//질문 글 수정
	@PostMapping("/rest/modifyQuestion")
	public int postModifyQuestion(QuestionBoard questionBoard) {
		System.out.println(":::post - postModifyQuestion");	
		System.out.println(questionBoard.toString());
		return userService.modifyQuestion(questionBoard);
	}
	
	
	//답변 상세정보
	@PostMapping("/rest/getAnswerOne")
	public Answer getAnswerOne(String answerId) {
		System.out.println("::: post - getAnswerOne :::");
		System.out.println("answerId " + answerId);
		return userService.getAnswerOne(answerId);
	}
	// 신고내역 저장하기
	@PostMapping("/rest/addReport")
	public String addReport(HttpSession session,ReportHistory reportHistory) {
		System.out.println("::: post - addReport :::");
		System.out.println(reportHistory.toString());
		System.out.println(session.getAttribute("loginUser"));
		if(session.getAttribute("loginUser") == null) {
			System.out.println("already loged in Back to user Home");
			return "false";
		}
		reportHistory.setUser((User) session.getAttribute("loginUser"));
		userService.addReportHistory(reportHistory);
		return "success";
	}
	//질문카테고리리스트
	@PostMapping("/rest/getReportList")
	public List<Report> getReportList(){
		System.out.println("::: post - getReportList :::");
		return userService.getReportList();
	}
	
	//질문 답변 댓글 개수 가져오기
	@PostMapping("/rest/getAnswerCommentCount")
	public int getAnswerCommentCount(int answerId) {
		System.out.println("::: post - getAnswerCommentCount :::");
		return userService.getAnswerCommentCount(answerId);
	}
	//질문 댓글 추가하기
	@PostMapping("/rest/questionCommentAdd")
	public int questionCommentAdd(QuestionComment questionComment) {
		System.out.println("::: post - questionCommentAdd :::");
		System.out.println(questionComment.toString());
		return userService.addQeustionComment(questionComment);
	}
	//질문 답변 댓글 추가하기
	@PostMapping("/rest/answerCommentAdd")
	public int addAnswerComment(AnswerComment answerComment) {
		System.out.println("::: post - answerCommentAdd :::");
		System.out.println(answerComment.toString());
		return userService.addAnswerComment(answerComment);
	}
	//질문 답변 추가하기
	@PostMapping("/rest/answerAdd")
	public int answerAdd(Answer answer) {
		System.out.println("::: post - answerAdd :::");
		System.out.println(answer.toString());
		return userService.addAnswer(answer);
	}
	//질문 답변 리스트 가져오기 
	@PostMapping("/rest/getAnswerList")
	public List<Answer> getAnswerList(int questionId){
		System.out.println("::: post - getAnswerList :::");
		System.out.println("questionId : "+ questionId);
		return userService.getAnswerList(questionId);
	}
	//질문 답변 댓글 리스트 가져오기
	@PostMapping("/rest/getAnswerCommentList")
	public List<AnswerComment> getAnswerCommentList(int answerId){
		System.out.println("::: post - getAnswerCommentList :::");
		System.out.println("answerId : "+ answerId);
		return userService.getAnswerCommentList(answerId);
	}
	@GetMapping("/rest/getLoginUser")
	public User getLoginUser(HttpSession session) {
		System.out.println("::: get - getLoginUser :::"); 
		return (User) session.getAttribute("loginUser");
	}
	
	@PostMapping("/rest/userOne")
	public User getUserOne(String userId) {
		System.out.println("::: post - getUserOne :::"); 
		return userService.selectUserOne(userId);
	}
	
	// 댓글 입력하기
	// 댓글 전체리스트 가져오기
	@PostMapping("/rest/getQuestionCommentList")
	public List<QuestionComment> getCommentList(int questionId){
		System.out.println("::: post - getQuestionCommentList :::");
		System.out.println("questionId : "+questionId);
		return userService.getQuestionCommentList(questionId);
		
	}
	
	// 질문 리스트 가져오기
	@PostMapping("/rest/getBoardList")
	public Map<String,Object> getBoardList(	@RequestParam(value="currentPage",defaultValue = "1")int currentPage,
											@RequestParam(value="rowPerPage",defaultValue = "10")int rowPerPage,
											@RequestParam(value="searchWord", required = false)String searchWord,
											@RequestParam(value="searchCategory", defaultValue = "today")String searchCategory,
											@RequestParam(value="feildId", defaultValue = "99")int feildId) {
		System.out.println("::: post - getBoardList :::");
		System.out.println("currentPage : "+ currentPage);
		System.out.println("rowPerPage : "+ rowPerPage);
		System.out.println("searchWord : "+ searchWord);
		System.out.println("feildId : "+ feildId);
		System.out.println("searchCategory :"+searchCategory);
		
		return userService.getQuestBoardList(currentPage, rowPerPage,searchWord,searchCategory, feildId);
	}
	@PostMapping("/rest/questionBoardOne")
	public QuestionBoard QuestionBoardOne(@RequestParam(value="questionId" , required=true)int questionId) {
		System.out.println("::: post - QuestionBoardOne :::");
		System.out.println("questionId : "+questionId);
		QuestionBoard questionBoard = userService.getQuestionBoardOne(questionId);
		
		System.out.println(questionBoard.toString());
		
		return questionBoard;
	}
	
	@GetMapping("/rest/getNoticeList")
	public Map<String,Object> getNoticeList() {
		System.out.println("::: get - getnoticeList :::"); 
		return userService.getNoticeBoardList(1, 15);
		
	}
	
	@PostMapping("/rest/getNoticeList")
	public Map<String,Object> getNoticeList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
									 @RequestParam(value="rowPerPage", defaultValue = "15")int rowPerPage) {
		System.out.println("::: post - getnoticeList :::"); 
		System.out.println("currentPage : " + currentPage);
		System.out.println("rowPerPage : " + rowPerPage);
		
		Map<String,Object> map = userService.getNoticeBoardList(currentPage, rowPerPage);
		System.out.println("리턴!");
		System.out.println(map.toString());
		return userService.getNoticeBoardList(currentPage, rowPerPage);
	}
	
	@PostMapping("/rest/noticeOne")
	public NoticeBoard getNoticeOne(int noticeId) {
		System.out.println("::: post - getNoticeOne :::");
		
		return userService.getNoticeBoardOne(noticeId);
	}
	

	@PostMapping("/rest/resetPassword")
	public int postAccountRecovery(User user) {
		System.out.println("::: post - resetPassword :::");
		System.out.println("User"+ user);
		
		return userService.modifyUserPw(user);
	}
	
	@PostMapping("/rest/verifyUserForReset")
	public String verifyUserForReset(HttpSession session,User user) { 
		System.out.println("::: post - verifyUserForReset :::");
		System.out.println(user.toString());
		
		String result = userService.getUserIdForCheck(user); 
		if(result == null) {
			System.out.println("noSuchUser!! ");
			return "noSuchUser";
		}
		
		session.setAttribute("verifyCode", result);
		return "success";
	}
	
	@PostMapping("/rest/sendEmailToConfirm")
	public String sendEmailToConfirm(HttpSession session, User user) {
		System.out.println("::: post - checkCode :::");
		
		System.out.println(user.toString());		
		String code = userService.sendCodeToMail(user);
		session.setAttribute("verifyCode", code);
		
		return "success";
	}
	
	// verify code & add User
	@PostMapping("/rest/verifyCode")
	public boolean verifyCode(User user, HttpSession session, String code) {
		System.out.println("::: post - verifyCode :::");
		System.out.println(user.toString() + "입력받은 코드:" +code);
		
		if(session.getAttribute("verifyCode").equals(code) != true) {
			System.out.println("!password not correct");
			return false;
		}
		
		System.out.println("code correct!");
		userService.addUser(user); 
		
		return true;
	}
	// verify code & add User
	@PostMapping("/rest/verifyCodeForRest")
	public boolean verifyCodeForRest(HttpSession session, String code) {
		System.out.println("::: post - verifyCodeForRest :::");
		
		if(session.getAttribute("verifyCode").equals(code) != true) {
			System.out.println("!password not correct");
			System.out.println("code : "+code+", verifyCode: "+session.getAttribute("verifyCode"));
			return false;
		}
		
		System.out.println("code correct!");	
		return true;
	}
	
	@PostMapping("/rest/addExpert")
	public boolean addExpert(Expert expert) {
		System.out.println("::: post - addExpert :::");    
		System.out.println("영향을 받은행: "+userService.addExpert(expert)); 
		return true;
	}
	
	//병원 리스트
	@PostMapping("/rest/hospital")
	public Map<String, Object>postHospital(@RequestParam(value="currentPage", defaultValue="1")int currentPage,
										@RequestParam(value="rowPerPage", defaultValue="10")int rowPerPage,
										   @RequestParam(value="searchWord", required = false)String searchWord) {
	System.out.println(":::post - postHospital:::");
	System.out.println("currentPage"+currentPage + " //rowPerPage"+rowPerPage + " //searchWord"+searchWord);
	
	return userService.getHospitalList(currentPage, rowPerPage, searchWord);
	}
	
	//병원 상세페이지
	@PostMapping("/rest/hospitalOne")
	public List<Hospital> hospitalOne(@RequestParam(value="hospitalId")int hospitalId){
		System.out.println(":::post - getHospitalOne");
		System.out.println("hospitalId"+hospitalId);
		
		return userService.getHospitalOne(hospitalId);
	}
	// 유저 조회
	@PostMapping("/rest/getUserList")
	public Map<String,Object> getUserList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
			@RequestParam(value="rowPerPage", defaultValue = "36")int rowPerPage,
			@RequestParam(value="searchWord", required = false)String searchWord) {
		System.out.println("::: post - /getUserList :::");
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : "+rowPerPage);
		System.out.println("searchWord : "+searchWord);
		return userService.getUserList(currentPage, rowPerPage,searchWord);
	}
	// serviceCategory 리스트 조회 및 강조
	@GetMapping("/rest/getServiceCategoryList")
	public List<ServiceCategory> getServiceCategoryList() {
		return userService.getServiceCategoryList();
	}
	// faq 리스트 조회
	@PostMapping("/rest/getFaqList")
	public Map<String,Object> getFaqList(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
			@RequestParam(value = "rowPerPage", defaultValue = "10")int rowPerPage,
			// mapper에서 page에 담기위해서 변수명을 변경한다
			@RequestParam(value="serviceCategoryId", required = false)String searchCategory){
		System.out.println("::: post - /getFaqList :::");
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : "+rowPerPage);
		System.out.println("searchCategory : "+searchCategory);
		return userService.getFaqList(currentPage, rowPerPage, searchCategory);
	}
	// faqone 출력 (이전글,다음글까지 출력)
	@PostMapping("/rest/getFaqOne")
	public List<FaqBoard> getFaqOne(int faqId){
		System.out.println("::: post - /getFaqOne :::");
		System.out.println("faqId : "+faqId);
		return userService.getFaqOne(faqId);
	}
	//문의 답변 가져오기
	@PostMapping("/rest/getInquiryHistoryAnswerOne")
	public InquiryHistoryAnswer getInquiryHistoryAnswerOne(int inquiryHistoryId) {
		System.out.println("::: post - getInquiryHistoryAnswerOne :::");
		System.out.println("inquiryHistoryId : "+inquiryHistoryId);
		return userService.getInquiryHistoryAnswerOne(inquiryHistoryId);
	}
	
	//문의 상세내용 가져오기
	@PostMapping("/rest/getInquiryHistoryOne")
	public InquiryHistory getInquiryHistoryOne(int inquiryHistoryId) {
		System.out.println("::: post - getInquiryHistoryOne :::");
		System.out.println("inquiryHistoryId : "+inquiryHistoryId);
		return userService.getInquiryHistoryOne(inquiryHistoryId);
	}
	//문의 사항 저장
	@PostMapping("/rest/addInquiryHistory")
	public String addInquiryHistory(HttpSession session,InquiryHistory inquiryHistory) {
		System.out.println("::: post - addInquiryHistory :::");
		System.out.println(inquiryHistory.toString());
		System.out.println(session.getAttribute("loginUser"));
		if(session.getAttribute("loginUser") == null) {
			System.out.println("already loged in Back to user Home");
			return "false";
		}
		inquiryHistory.setUser((User) session.getAttribute("loginUser"));
		userService.addInquiryHistory(inquiryHistory);
		return "success";
	}
	// 문의내역 카테고리
			@GetMapping("/rest/getInquiry")
			public List<Inquiry> getInquiry(){
				return userService.getInquiryList();
			}
	// 문의내역 출력(자신이 올린 글만)
	@PostMapping("/rest/getInquiryBoard")
	public Map<String,Object> getInquiryBoard(@RequestParam(value="currentPage", defaultValue = "1")int currentPage,
			@RequestParam(value="rowPerPage", defaultValue = "5")int rowPerPage,
			// mapper에서 page에 담기위해서 변수명을 변경한다
			@RequestParam(value="inquiryId", required = false)String searchCategory,
			HttpSession session){
		System.out.println("::: post - /getInquiryBoard :::");
		System.out.println("currentPage : "+currentPage);
		System.out.println("rowPerPage : "+rowPerPage);
		System.out.println("searchCategory : "+searchCategory);
		System.out.println(session.getAttribute("loginUser"));
		// 세션에서 유저의 정보를 받아 온 후 유저아이디값을 넘겨준다
		User loginUser = new User();
		loginUser = (User) session.getAttribute("loginUser");
			String loginUserId = loginUser.getUserId();
			return userService.getInquiryHistoryBoard(currentPage, rowPerPage, loginUserId, searchCategory);
	}

	//회원정보 수정
	@PostMapping("/rest/modifyProfile")
	public void modifyUserProfile(User user,
								@RequestParam(value="userName")String userName,
								@RequestParam(value="userPw")String userPw,
								@RequestParam(value="userId")String userId) {

		System.out.println("::: post - modifyUserProfile :::");		
		System.out.println("user Name : " + userName);
		System.out.println("change Pw : " + userPw);	

		user = new User();
			user.setUserName(userName);
			user.setUserPw(userPw);
			user.setUserId(userId);
		System.out.println("user : " + user.toString());
	
	userService.modifyUserProfile(user);
	
	//return "redirect:/userOne?userId="+user.getUserId();
}
	
}
