/*
 * package com.example.codeblue.test.Lee;
 * 
 * import java.util.HashMap;
 * 
 * import java.util.List; import java.util.Map;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service; import
 * org.springframework.transaction.annotation.Transactional;
 * 
 * import com.example.codeblue.vo.Answer; import
 * com.example.codeblue.vo.AnswerVote; import com.example.codeblue.vo.Page;
 * import com.example.codeblue.vo.QuestionBoard; import
 * com.example.codeblue.vo.QuestionComment; import
 * com.example.codeblue.vo.QuestionVote; import com.example.codeblue.vo.Tag;
 * import com.example.codeblue.vo.User;
 * 
 * 
 * @Transactional
 * 
 * @Service public class LeeServiceImp implements LeeService{
 * 
 * @Autowired LeeMapper leeMapper;
 * 
 * //해당 유저정보
 * 
 * @Override public User getUserOne(String userId) {
 * System.out.println(":::UserServiceImp - getUserOne:::");
 * 
 * return leeMapper.selectUserOne(userId); }
 * 
 * //유저 질문 수
 * 
 * @Override public int questionBoardCount(String userId) {
 * System.out.println(":::UserServiceImp - questionBoardCount:::");
 * System.out.println("userId"+userId); return
 * leeMapper.selectQuestionBoardCount(userId); }
 * 
 * //해당 유저 질문수 차트
 * 
 * @Override public List<QuestionBoard> getQuestionChart(String userId) {
 * System.out.println("::::UserServiceImp - getQuestionChart");
 * System.out.println("userId"+userId); return
 * leeMapper.selectQuestionChart(userId); }
 * 
 * //해당유저 질문수 리스트(페이징)
 * 
 * @Override public Map<String, Object> getQuestionBoardPaging(int currentPage,
 * int rowPerPage, String userId) {
 * System.out.println(":::UserServiceImp - getQuestionBoardPaging");
 * System.out.println("currentPage :"+currentPage +"/rowPerPage :"+rowPerPage);
 * 
 * 
 * Page page = new Page();
 * 
 * int beginRow = (currentPage-1)*rowPerPage; page.setBeginRow(beginRow);
 * page.setRowPerPage(rowPerPage); page.setUserId(userId);
 * 
 * System.out.println(page.toString());
 * 
 * int totalRow = leeMapper.selectQuestionBoardCount(userId); int lastPage =
 * totalRow/rowPerPage;
 * 
 * if( totalRow%rowPerPage==0) { lastPage = totalRow/rowPerPage; }else {
 * lastPage = (totalRow/rowPerPage)+1; }
 * 
 * List<QuestionBoard> list = leeMapper.selectQuestionPaging(page);
 * 
 * Map<String,Object> map = new HashMap<String, Object>();
 * map.put("currentPage", currentPage); map.put("rowPerPage", rowPerPage);
 * map.put("lastPage",lastPage); map.put("list", list); map.put("beginRow",
 * beginRow);
 * 
 * return map; }
 * 
 * //해당유저 댓글 리스트(페이징)
 * 
 * @Override public Map<String, Object> getCommentBoardPaging(int currentPage,
 * int rowPerPage, String userId) {
 * System.out.println(":::UserServiceImp - getCommentBoardPaging:::");
 * System.out.println("currentPage : "+currentPage
 * +"/rowPerPage :"+rowPerPage+"/userId:"+userId);
 * 
 * rowPerPage =10;
 * 
 * Page page = new Page();
 * 
 * int beginRow = (currentPage-1)*rowPerPage; page.setBeginRow(beginRow);
 * page.setRowPerPage(rowPerPage); page.setUserId(userId);
 * 
 * System.out.println(page.toString());
 * 
 * int totalRow = leeMapper.selectQuestionUserCommentCount(userId); int lastPage
 * = totalRow/rowPerPage;
 * 
 * if( totalRow%rowPerPage==0) { lastPage = totalRow/rowPerPage; }else {
 * lastPage = (totalRow/rowPerPage)+1; }
 * 
 * List<QuestionComment> list = leeMapper.selectCommentPaging(page);
 * 
 * Map<String,Object> map = new HashMap<String, Object>();
 * map.put("currentPage", currentPage); map.put("rowPerPage", rowPerPage);
 * map.put("lastPage",lastPage); map.put("list", list); map.put("beginRow",
 * beginRow); return map; }
 * 
 * //해당유저 댓글 수
 * 
 * @Override public int questionCommentCount(String userId) {
 * System.out.println(":::UserServiceImp - selectCommentCount");
 * System.out.println("userId"+userId); return
 * leeMapper.selectQuestionUserCommentCount(userId); }
 * 
 * //해당유저 답글 리스트(페이징)
 * 
 * @Override public Map<String, Object> getAnswerPaging(int currentPage, int
 * rowPerPage, String userId) {
 * System.out.println(":::UserServiceImp - getAnswerPaging:::");
 * System.out.println("currentPage : "+currentPage
 * +"/rowPerPage :"+rowPerPage+"/userId:"+userId);
 * 
 * 
 * Page page = new Page();
 * 
 * int beginRow = (currentPage-1)*rowPerPage; page.setBeginRow(beginRow);
 * page.setRowPerPage(rowPerPage); page.setUserId(userId);
 * 
 * System.out.println(page.toString());
 * 
 * int totalRow = leeMapper.selectAnswerCount(userId); int lastPage =
 * totalRow/rowPerPage;
 * 
 * if( totalRow%rowPerPage == 0) { lastPage = totalRow/rowPerPage; }else {
 * lastPage = (totalRow/rowPerPage)+1; }
 * 
 * List<Answer> list = leeMapper.selectQuestionAnswerPaging(page);
 * 
 * Map<String,Object> map = new HashMap<String, Object>();
 * map.put("currentPage", currentPage); map.put("rowPerPage", rowPerPage);
 * map.put("lastPage",lastPage); map.put("list", list); map.put("beginRow",
 * beginRow); return map; }
 * 
 * //해당유저 답글 수
 * 
 * @Override public int answerCount(String userId) {
 * System.out.println(":::UserServiceImp - answerCount:::");
 * System.out.println("userId"+userId); return
 * leeMapper.selectAnswerCount(userId); }
 * 
 * //해당유저 답글 수 차트
 * 
 * @Override public List<Answer> getAnswerChart(String userId) {
 * System.out.println(":::UserServiceImp - getAnswerChart:::");
 * System.out.println("userId"+userId); return
 * leeMapper.selectAnswerChart(userId); } //유저 질문글 추천 수
 * 
 * @Override public int getUserVote(String userId) {
 * System.out.println(":::UserServiceImp - getUserVote:::");
 * System.out.println("userId"+userId); return leeMapper.selectUserVote(userId);
 * }
 * 
 * //유저 질문글 추천 중복검사 및 추천
 * 
 * @Override public int getQuestionVoteCheck(QuestionVote questionVote) {
 * System.out.println(":::UserServiceImp - getQuestionVoteCheck:::");
 * System.out.println("questionid"+questionVote);
 * 
 * if(leeMapper.selectQuestionVoteCheck(questionVote) == null) {
 * System.out.print("추천!"); return leeMapper.insertQuestionVote(questionVote); }
 * return 0; }
 * 
 * //유저 답변글 추천 중복검사 및 추천
 * 
 * @Override public int getAnswerVoteCheck(AnswerVote answerVote) {
 * System.out.println(":::UserServiceImp - getAnswerVoteCheck:::");
 * System.out.println("anwerVote"+answerVote);
 * 
 * if(leeMapper.selectAnswerVoteCheck(answerVote) == null) {
 * System.out.print("추천!"); return leeMapper.insertAnswerVote(answerVote); }
 * return 0; }
 * 
 * //유저가 사용한 태그 수
 * 
 * @Override public int getUserTagCount(String userId) {
 * System.out.println(":::UserServiceImp - getUserTagCount:::");
 * System.out.println("userId"+userId); return
 * leeMapper.selectUserTagTotalRow(userId); }
 * 
 * //유저가 사용한 태그 페이징
 * 
 * @Override public Map<String, Object> getUserTagPaging(int currentPage, int
 * rowPerPage, String userId) {
 * System.out.println(":::UserServiceImp - getUserTagPaging:::");
 * System.out.println("currentPage : "+currentPage
 * +"/rowPerPage :"+rowPerPage+"/userId:"+userId);
 * 
 * int totalRow = leeMapper.selectUserTagTotalRow(userId);
 * System.out.println("totalRow"+totalRow);
 * 
 * int beginRow = (currentPage-1)*rowPerPage; Page page = new Page();
 * page.setBeginRow(beginRow); page.setRowPerPage(rowPerPage);
 * page.setUserId(userId);
 * 
 * int lastPage = totalRow/rowPerPage; if(totalRow % rowPerPage !=0) { lastPage
 * = (totalRow/rowPerPage)+1; }else { lastPage = totalRow/rowPerPage; }
 * 
 * 
 * List<Tag> list = leeMapper.selectUserTagPaging(page);
 * System.out.println(list.toString());
 * 
 * Map<String, Object> map = new HashMap<String, Object>(); map.put("list",
 * list); map.put("rowPerPage", rowPerPage); map.put("currentPage",
 * currentPage); map.put("userId", userId); map.put("lastPage", lastPage);
 * map.put("beginRow", beginRow); return map; }
 * 
 * //질문글 수정
 * 
 * @Override public int modifyQuestion(QuestionBoard questionBoard) {
 * System.out.println(":::UserServiceImp - getUserTagPaging:::");
 * System.out.println(questionBoard.toString());
 * 
 * return leeMapper.updateQuestion(questionBoard); }
 * 
 * }
 */