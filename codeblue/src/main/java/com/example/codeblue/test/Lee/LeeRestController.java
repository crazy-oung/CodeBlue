/*
 * package com.example.codeblue.test.Lee;
 * 
 * import java.util.List; import java.util.Map;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.example.codeblue.vo.Answer; import
 * com.example.codeblue.vo.AnswerVote; import
 * com.example.codeblue.vo.QuestionBoard; import
 * com.example.codeblue.vo.QuestionComment; import
 * com.example.codeblue.vo.QuestionVote; import com.example.codeblue.vo.Tag;
 * import com.example.codeblue.vo.User;
 * 
 * @RestController public class LeeRestController {
 * 
 * @Autowired LeeService leeService;
 * 
 * //프로필 정보 가져오기
 * 
 * @PostMapping("/rest/profile") public User
 * postProfile(@RequestParam(value="userId")String userId){
 * System.out.println(":::post - postProfile:::");
 * System.out.println("userId"+userId); return leeService.getUserOne(userId); }
 * 
 * //유저 질문 리스트
 * 
 * @PostMapping("/rest/profileQuestionBoard") public Map<String, Object>
 * postProfileQuestionBoard(@RequestParam(value="userId")String userId,
 * 
 * @RequestParam(value="currentPage", defaultValue="1")int currentPage,
 * 
 * @RequestParam(value="rowPerPage", defaultValue="6")int rowPerPage){
 * rowPerPage =6; System.out.println(":::post - postProfileQuestionBoard:::");
 * System.out.println("userId"+userId);
 * System.out.println("currentPage"+currentPage);
 * System.out.println("rowPerPage"+rowPerPage); return
 * leeService.getQuestionBoardPaging(currentPage, rowPerPage, userId); }
 * 
 * //유저 질문 리스트(페이징)
 * 
 * @PostMapping("/rest/questionBoardPaging") public Map<String, Object>
 * postQuestionBoardPaging(@RequestParam(value="userId")String userId,
 * 
 * @RequestParam(value="currentPage", defaultValue="1")int currentPage,
 * 
 * @RequestParam(value="rowPerPage", defaultValue="10")int rowPerPage){
 * rowPerPage = 10; System.out.println(":::post - postQuestionBoardPaging");
 * System.out.println("userId"+userId);
 * System.out.println("currentPage"+currentPage);
 * System.out.println("rowPerPage"+rowPerPage); return
 * leeService.getQuestionBoardPaging(currentPage, rowPerPage, userId); }
 * 
 * //유저 질문 수(해당유저)
 * 
 * @PostMapping("/rest/QuestionCount") public int
 * postQuestionCount(@RequestParam(value="userId")String userId){
 * System.out.println(":::post - postQuestionCount:::");
 * System.out.println("userId"+userId); return
 * leeService.questionBoardCount(userId); }
 * 
 * //유저 질문 수 차트
 * 
 * @PostMapping("/rest/questionChart") public List<QuestionBoard>
 * postQuestionChart(@RequestParam(value="userId")String userId) {
 * System.out.println(":::post - postQuestionChart :::");
 * System.out.println("userId"+userId); return
 * leeService.getQuestionChart(userId); }
 * 
 * //유저 댓글 리스트
 * 
 * @PostMapping("/rest/profileQuestionComment") public Map<String, Object>
 * postProfileQuestionComment(@RequestParam(value="userId")String userId,
 * 
 * @RequestParam(value="currentPage", defaultValue="1")int currentPage,
 * 
 * @RequestParam(value="rowPerPage", defaultValue="6")int rowPerPage){
 * rowPerPage = 6; System.out.println(":::post - postProfile:::");
 * System.out.println("userId"+userId);
 * System.out.println("currentPage"+currentPage);
 * System.out.println("rowPerPage"+rowPerPage); return
 * leeService.getCommentBoardPaging(currentPage, rowPerPage, userId); }
 * 
 * //유저 댓글 리스트(페이징)
 * 
 * @PostMapping("/rest/questionCommentPaging") public Map<String, Object>
 * postQuestionCommentPaging(@RequestParam(value="userId")String userId,
 * 
 * @RequestParam(value="currentPage", defaultValue="1")int currentPage,
 * 
 * @RequestParam(value="rowPerPage", defaultValue="10")int rowPerPage){
 * rowPerPage = 10; System.out.println(":::post - postQuestionBoardPaging");
 * System.out.println("userId"+userId);
 * System.out.println("currentPage"+currentPage);
 * System.out.println("rowPerPage"+rowPerPage); return
 * leeService.getCommentBoardPaging(currentPage, rowPerPage, userId); }
 * 
 * //유저 댓글 수(해당유저)
 * 
 * @PostMapping("/rest/CommentCount") public int
 * postCommentCount(@RequestParam(value="userId")String userId){
 * System.out.println(":::post - postCommentCount:::");
 * System.out.println("userId"+userId); return
 * leeService.questionCommentCount(userId); }
 * 
 * //유저 답글 수 차트
 * 
 * @PostMapping("/rest/answerChart") public List<Answer>
 * postAnswerChart(@RequestParam(value="userId")String userId){
 * System.out.println(":::post - postAnswerChart:::");
 * System.out.println("userId"+userId); return
 * leeService.getAnswerChart(userId); }
 * 
 * //유저 답글 리스트
 * 
 * @PostMapping("/rest/questionAnswer") public Map<String, Object>
 * postQuestionAnswer(@RequestParam(value="userId")String userId,
 * 
 * @RequestParam(value="currentPage", defaultValue="1")int currentPage,
 * 
 * @RequestParam(value="rowPerPage", defaultValue="6")int rowPerPage){
 * rowPerPage = 6; System.out.println(":::post - postQuestionAnswer:::");
 * System.out.println("userId"+userId);
 * System.out.println("currentPage"+currentPage);
 * System.out.println("rowPerPage"+rowPerPage); return
 * leeService.getAnswerPaging(currentPage, rowPerPage, userId); }
 * 
 * //유저 답글 리스트(페이징)
 * 
 * @PostMapping("/rest/questionAnswerPaging") public Map<String, Object>
 * postQuestionAnswerPaging(@RequestParam(value="userId")String userId,
 * 
 * @RequestParam(value="currentPage", defaultValue="1")int currentPage,
 * 
 * @RequestParam(value="rowPerPage", defaultValue="10")int rowPerPage){
 * rowPerPage = 10; System.out.println(":::post - postQuestionAnswerPaging");
 * System.out.println("userId"+userId);
 * System.out.println("currentPage"+currentPage);
 * System.out.println("rowPerPage"+rowPerPage); return
 * leeService.getAnswerPaging(currentPage, rowPerPage, userId); }
 * 
 * //유저 답글 수
 * 
 * @PostMapping("/rest/answerCount") public int
 * postAnswerCount(@RequestParam(value="userId")String userId) {
 * System.out.println(":::post - postAnswerCount");
 * System.out.println("userId"+userId); return leeService.answerCount(userId); }
 * 
 * //해당 유저가 받은 추천 수
 * 
 * @PostMapping("/rest/userVote") public int
 * postUserVote(@RequestParam(value="userId")String userId) {
 * System.out.println(":::post - postUserVote");
 * System.out.println("userId"+userId); return leeService.getUserVote(userId); }
 * 
 * //게시글 추천 중복 검사 후 추천
 * 
 * @PostMapping("/rest/questionVote") public int postQuestionVote(QuestionVote
 * questionVote) { System.out.println(":::post - postQuestionVote");
 * System.out.println("userId"+questionVote); return
 * leeService.getQuestionVoteCheck(questionVote); }
 * 
 * //답글 추천 중복 검사 후 추천
 * 
 * @PostMapping("/rest/answerVote") public int postAnswerVote(AnswerVote
 * answerVote) { System.out.println(":::post - postAnswerVote");
 * System.out.println("answerVote"+answerVote); return
 * leeService.getAnswerVoteCheck(answerVote); }
 * 
 * //해당 유저가 사용한 태그리스트
 * 
 * @PostMapping("/rest/userTagList") public Map<String, Object>
 * postUserTagList(@RequestParam(value="userId")String userId,
 * 
 * @RequestParam(value="currentPage", defaultValue="1")int currentPage,
 * 
 * @RequestParam(value="rowPerPage", defaultValue="6")int rowPerPage) {
 * 
 * rowPerPage = 6; System.out.println(":::post - postUserTagList");
 * System.out.println("userId"+userId);
 * System.out.println("currentPage"+currentPage);
 * System.out.println("rowPerPage"+rowPerPage); return
 * leeService.getUserTagPaging(currentPage, rowPerPage, userId); }
 * 
 * //해당 유저가 사용한 태그리스트(페이징)
 * 
 * @PostMapping("/rest/userTagPaging") public Map<String, Object>
 * postUserTagPaging(@RequestParam(value="userId")String userId,
 * 
 * @RequestParam(value="currentPage", defaultValue="1")int currentPage,
 * 
 * @RequestParam(value="rowPerPage", defaultValue="10")int rowPerPage){
 * rowPerPage = 10; System.out.println(":::post - postUserTagPaging");
 * System.out.println("userId"+userId);
 * System.out.println("currentPage"+currentPage);
 * System.out.println("rowPerPage"+rowPerPage);
 * 
 * return leeService.getUserTagPaging(currentPage, rowPerPage, userId); }
 * 
 * //해당 유저가 사용한 태그 수
 * 
 * @PostMapping("/rest/userTagCount") public int
 * postUserTagCount(@RequestParam(value="userId")String userId) {
 * System.out.println(":::post - postUserTagCount");
 * System.out.println("userId"+userId); return
 * leeService.getUserTagCount(userId); }
 * 
 * //질문 글 수정
 * 
 * @PostMapping("/rest/modifyQuestion") public int
 * postModifyQuestion(QuestionBoard questionBoard) {
 * System.out.println(":::post - postModifyQuestion");
 * System.out.println(questionBoard.toString()); return
 * leeService.modifyQuestion(questionBoard); } }
 */