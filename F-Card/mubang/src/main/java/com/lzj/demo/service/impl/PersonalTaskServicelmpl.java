package com.lzj.demo.service.impl;

import com.lzj.demo.dao.CardDao;
import com.lzj.demo.dao.PersonalCardDao;
import com.lzj.demo.dao.PersonalTaskDao;
import com.lzj.demo.dao.UserDao;

import com.lzj.demo.entity.PersonalTask;
import com.lzj.demo.service.PersonalTaskService;
import com.lzj.demo.service.PersonalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lzj.demo.entity.User;
import com.lzj.demo.dao.CardDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class PersonalTaskServicelmpl implements PersonalTaskService {
    @Autowired
    private PersonalTaskDao personalTaskDao;
    @Autowired
    private PersonalCardDao personalCardDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private CardDao cardDao;
    @Override
    public List<PersonalTask> queryPersonalTask() {
        return personalTaskDao.queryPersonalTask();
    }

    @Override
    public List<PersonalTask> queryPersonalTaskByUID(String UID) {
        return personalTaskDao.queryPersonalTaskByUID(UID);
    }

    @Transactional
    @Override
    public boolean insertPersonalTask(PersonalTask personalTask) {
        if (personalTask.getUID() != null && !"".equals(personalTask.getUID())) {
            try {
                int effectedNum = personalTaskDao.insertPersonalTask(personalTask);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入个人任务失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入个人任务失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("个人任务UID不能为空!");
        }
    }

    @Transactional
    @Override
    public boolean updatePersonalTask(PersonalTask personalTask) {
        if (personalTask.getUID() != null && !"".equals(personalTask.getUID())) {
            try {
                int effectedNum = personalTaskDao.updatePersonalTask(personalTask);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新个人任务失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新个人任务失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("个人任务UID不能为空!");
        }
    }

    @Transactional
    @Override
    public boolean deletePersonalTask(String UID,String taskName) {
        if (UID != null && !"".equals(UID)) {
            try {
                int effectedNum = personalTaskDao.deletePersonalTask(UID,taskName);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除卡牌失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除卡牌失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("卡牌名称不能为空!");
        }
    }


}
