package com.lzj.demo.dao;

import com.lzj.demo.entity.Rank;
import com.lzj.demo.entity.User;
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
class UserDaoTest {

    @Autowired(required = false)
    private UserDao userDao;

    @Test
    void insertUser() {
        User user = new User();
        user.setCollegeInfluence(0);
        user.setCoin(100);
        user.setName("张三");
        user.setPassword("123456");
        user.setCollege("数计");
        user.setPhoneNumber("1112222333");
        user.setUID("0001");
        user.setDateTime("2022-11-12 00:00:00");
        user.setTask("完成");
        user.setTowerNumber(5);
        int effectedNum = userDao.insertUser(user);
        assertEquals(1,effectedNum);
    }

    @Test
    void queryUser() {
        List<User> userList = userDao.queryUser();
        assertEquals(1,userList.size());

    }

    @Test
    void queryUserByUid() {
        User user = new User();
        user.setCollegeInfluence(0);
        user.setCoin(100);
        user.setName("张三");
        user.setPassword("123456");
        user.setCollege("数计");
        user.setPhoneNumber("1112222333");
        user.setUID("0001");
        user.setDateTime("2022-11-12 00:00:00");
        user.setTask("完成");
        user.setTowerNumber(5);
        User effectedNum = userDao.queryUserByUid(user.getUID());
        assertEquals(user,effectedNum);
    }



    @Test
    void updateUser() {
        User user = new User();
        user.setCollegeInfluence(0);
        user.setCoin(200);
        user.setName("张三");
        user.setPassword("123456");
        user.setCollege("数计");
        user.setPhoneNumber("1112222333");
        user.setUID("0001");
        user.setDateTime("2022-11-12");
        user.setTask("完成");
        user.setTowerNumber(5);
        int  effectedNum = userDao.updateUser(user);
        assertEquals(1,effectedNum);
    }

    @Test
    void deleteUser() {
        User user = new User();
        user.setCollegeInfluence(0);
        user.setCoin(100);
        user.setName("张三");
        user.setPassword("123456");
        user.setCollege("数计");
        user.setPhoneNumber("1112222333");
        user.setUID("0001");
        user.setDateTime("2022-11-12");
        user.setTask("完成");
        user.setTowerNumber(5);
        int  effectedNum = userDao.deleteUser(user);
        assertEquals(1,effectedNum);
    }
}