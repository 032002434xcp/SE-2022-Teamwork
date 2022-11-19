package com.lzj.demo.service;

import com.lzj.demo.entity.Question;

import java.util.List;

/**
 * @author xcp
 * @version 1.0
 */
public interface QuestionService {

    List<Question> queryQuestion();
    Question queryQuestionByName(String questionName);
    boolean insertQuestion(Question question);
    boolean updateQuestion(Question question);
    boolean deleteQuestion(Question question);
}
