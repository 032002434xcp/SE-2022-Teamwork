package com.lzj.demo.dao;

import com.lzj.demo.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xcp
 * @version 1.0
 */
@Mapper
@Repository
public interface QuestionDao {
    List<Question> queryQuestion();
    Question queryQuestionByName(String questionName);
    int insertQuestion(Question question);
    int updateQuestion(Question question);
    int deleteQuestion(Question question);

}
