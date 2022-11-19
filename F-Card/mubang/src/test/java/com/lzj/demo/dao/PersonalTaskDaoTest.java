package com.lzj.demo.dao;

import com.lzj.demo.entity.PersonalTask;
import org.junit.jupiter.api.Test;
import com.lzj.demo.entity.PersonalCard;
import org.junit.Ignore;
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
class PersonalTaskDaoTest {

    @Autowired(required = false)
    private PersonalTaskDao personalTaskDao;


    @Test
    void insertPersonalTask() {
        PersonalTask personalTask = new PersonalTask();
        personalTask.setUID("0001");
        personalTask.setTaskname("打一把牌局");
        personalTask.setCurrent(0);
        personalTask.setEnd(1);
        personalTask.setType("每日");
        personalTask.setReward("给100金币");
        personalTask.setDate("2022-11-18");

        int effectedNum = personalTaskDao.insertPersonalTask(personalTask);
        assertEquals(1,effectedNum);

    }

    @Test
    void queryPersonalTask() {
        List<PersonalTask> personalTaskList = personalTaskDao.queryPersonalTask();
        assertEquals(1,personalTaskList.size());

    }

    @Test
    void queryPersonalTaskByUID() {
        PersonalTask personalTask = new PersonalTask();
        personalTask.setUID("0001");
        personalTask.setTaskname("打一把牌局");
        personalTask.setCurrent(0);
        personalTask.setEnd(1);
        personalTask.setType("每日");
        personalTask.setReward("给100金币");
        personalTask.setDate("2022-11-18");
        List<PersonalTask> effectedNum = personalTaskDao.queryPersonalTaskByUID(personalTask.getUID());
        assertEquals(personalTask,effectedNum.size());
    }
    @Test
    void updatePersonalTask() {
        PersonalTask personalTask = new PersonalTask();
        personalTask.setUID("0001");
        personalTask.setTaskname("打一把牌局");
        personalTask.setCurrent(0);
        personalTask.setEnd(2);
        personalTask.setType("每日");
        personalTask.setReward("给100金币");
        personalTask.setDate("2022-11-18");
        int  effectedNum = personalTaskDao.updatePersonalTask(personalTask);
        assertEquals(1,effectedNum);
    }

    @Test
    void deletePersonalTask() {
        PersonalTask personalTask = new PersonalTask();
        personalTask.setUID("0001");
        personalTask.setTaskname("打一把牌局");
        personalTask.setCurrent(0);
        personalTask.setEnd(1);
        personalTask.setType("每日");
        personalTask.setReward("给100金币");
        personalTask.setDate("2022-11-18");
        int  effectedNum = personalTaskDao.deletePersonalTask(personalTask.getUID(), personalTask.getTaskname());
        assertEquals(1,effectedNum);
    }
}