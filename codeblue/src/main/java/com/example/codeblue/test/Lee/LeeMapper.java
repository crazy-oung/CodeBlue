/*
 * package com.example.codeblue.test.Lee;
 * 
 * 
 * import java.util.List;
 * 
 * 
 * import org.apache.ibatis.annotations.Mapper;
 * 
 * import com.example.codeblue.vo.Answer; import
 * com.example.codeblue.vo.AnswerVote; import com.example.codeblue.vo.Page;
 * import com.example.codeblue.vo.QuestionBoard; import
 * com.example.codeblue.vo.QuestionComment; import
 * com.example.codeblue.vo.QuestionVote; import com.example.codeblue.vo.Tag;
 * import com.example.codeblue.vo.User;
 * 
 * @Mapper public interface LeeMapper { //재사용 public User selectUserOne(String
 * userId); //<-- 얘만 확인 //유저 질문 리스트(페이징) public List<QuestionBoard>
 * selectQuestionPaging(Page page); //유저 질문수(해당유저) public int
 * selectQuestionBoardCount(String userId); //유저 질문 차트 public
 * List<QuestionBoard> selectQuestionChart(String userId);
 * 
 * //유저 댓글 수(해당유저) public int selectQuestionUserCommentCount(String userId);
 * //유저 댓글 리스트(페이징) public List<QuestionComment> selectCommentPaging(Page page);
 * 
 * //유저 답글 리스트(페이징) public List<Answer> selectQuestionAnswerPaging(Page page);
 * //유저 답글 리스트 수 public int selectAnswerCount(String userId); //유저 답변 차트 public
 * List<Answer> selectAnswerChart(String userId);
 * 
 * //유저 질문 글 추천 수 public int selectUserVote(String userId); //유저 질문 글 추천기능
 * public int insertQuestionVote(QuestionVote questionVote); //유저 질문 추천 중복검사
 * public QuestionVote selectQuestionVoteCheck(QuestionVote questionVote);
 * 
 * //유저 답변 추천기능 public int insertAnswerVote(AnswerVote answerVote); //유저 답변 추천
 * 중복검사 public AnswerVote selectAnswerVoteCheck(AnswerVote answerVote);
 * 
 * //유저가 사용한 태그리스트(페이징) public List<Tag> selectUserTagPaging(Page page); //유저가
 * 사용한 태그 수 public int selectUserTagTotalRow(String userId); //질문글 수정 public int
 * updateQuestion(QuestionBoard questionBoard);
 * 
 * }
 */