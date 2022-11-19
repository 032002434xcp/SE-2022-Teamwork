package com.lzj.demo.service.impl;

import com.lzj.demo.dao.QuestionDao;
import com.lzj.demo.entity.Question;
import com.lzj.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xcp
 * @version 1.0
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;



    @Override
    public List<Question> queryQuestion() {
        return questionDao.queryQuestion();
    }

    @Override
    public Question queryQuestionByName(String UID) {
        return questionDao.queryQuestionByName(UID);
    }

    @Transactional
    @Override
    public boolean insertQuestion(Question question) {
        if (question.getQuestionName() != null && !"".equals(question.getQuestionName())) {
            try {
                int effectedNum = questionDao.insertQuestion(question);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入问题失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入问题失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("问题称不能为空!");
        }
    }

    @Transactional
    @Override
    public boolean updateQuestion(Question question) {
        if (question.getQuestionName() != null && !"".equals(question.getQuestionName())) {
            try {
                int effectedNum = questionDao.updateQuestion(question);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新问题失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新问题失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("问题名称不能为空!");
        }
    }

    @Transactional
    @Override
    public boolean deleteQuestion(Question question) {
        if (question.getQuestionName() != null && !"".equals(question.getQuestionName())) {
            try {
                int effectedNum = questionDao.deleteQuestion(question);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除问题失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除问题失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("问题名称不能为空!");
        }
    }



}