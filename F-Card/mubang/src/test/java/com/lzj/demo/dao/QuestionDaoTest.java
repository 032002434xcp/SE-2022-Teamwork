package com.lzj.demo.dao;

import com.lzj.demo.entity.Card;
import com.lzj.demo.entity.PersonalCard;
import com.lzj.demo.entity.Question;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
class QuestionDaoTest {

    @Autowired(required = false)
    private QuestionDao questionDao;

    @Test
    void insertQuestion() {
        Question question = new Question();
        question.setQuestionAbility1(100);
        question.setQuestionAbility2(100);
        question.setQuestionAbility3(100);
        question.setQuestionAbility4(100);
        question.setQuestionAbility5(100);
        question.setQuestionName("问题1");
        question.setPreferance("软件工程");
        int effectedNum = questionDao.insertQuestion(question);
        assertEquals(1,effectedNum);
    }

    @Test
    void queryQuestion() {
        List<Question> questionList = questionDao.queryQuestion();
        assertEquals(1,questionList.size());
    }

    @Test
    void queryQuestionByName() {
        Question question = new Question();
        question.setQuestionAbility1(100);
        question.setQuestionAbility2(100);
        question.setQuestionAbility3(100);
        question.setQuestionAbility4(100);
        question.setQuestionAbility5(100);
        question.setQuestionName("问题1");
        question.setPreferance("软件工程");
        Question effectedNum = questionDao.queryQuestionByName(question.getQuestionName());
        assertEquals(question,effectedNum);
    }



    @Test
    void updateQuestion() {
        Question question = new Question();
        question.setQuestionAbility1(200);
        question.setQuestionAbility2(100);
        question.setQuestionAbility3(100);
        question.setQuestionAbility4(100);
        question.setQuestionAbility5(100);
        question.setQuestionName("问题1");
        question.setPreferance("软件工程");
        int effectedNum = questionDao.updateQuestion(question);
        assertEquals(1,effectedNum);
    }

    @Test
    void deleteQuestion() {
        Question question = new Question();
        question.setQuestionAbility1(100);
        question.setQuestionAbility2(100);
        question.setQuestionAbility3(100);
        question.setQuestionAbility4(100);
        question.setQuestionAbility5(100);
        question.setQuestionName("问题1");
        question.setPreferance("软件工程");
        int effectedNum = questionDao.deleteQuestion(question);
        assertEquals(1,effectedNum);
    }
}