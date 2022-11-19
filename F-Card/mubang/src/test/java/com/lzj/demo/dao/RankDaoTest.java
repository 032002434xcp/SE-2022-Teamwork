package com.lzj.demo.dao;

import com.lzj.demo.entity.PersonalCard;
import com.lzj.demo.entity.Question;
import com.lzj.demo.entity.Rank;
import net.sf.json.JSONObject;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
class RankDaoTest {

    @Autowired(required = false)
    private RankDao rankDao;

    @Test
    void insertRank() {
        Rank rank = new Rank();
        rank.setCollegeInfluence(0);
        rank.setGrade(2020);
        rank.setName("张三");
        rank.setRank(1);
        rank.setCollege("数计");
        rank.setDateTime("2022-11-12");
        int effectedNum = rankDao.insertRank(rank);
        assertEquals(1,effectedNum);
    }

    @Test
    void queryRank() {
        List<Rank> rankList = rankDao.queryRank();
        assertEquals(1,rankList.size());
    }

    @Test
    void queryRankByName() {
        Rank rank = new Rank();
        rank.setCollegeInfluence(0);
        rank.setGrade(2020);
        rank.setName("张三");
        rank.setRank(1);
        rank.setCollege("数计");
        rank.setDateTime("2022-11-12");
        Rank effectedNum = rankDao.queryRankByName(rank.getName());
        assertEquals(rank,effectedNum);
    }



    @Test
    void updateRank() {
        Rank rank = new Rank();
        rank.setCollegeInfluence(1);
        rank.setGrade(2020);
        rank.setName("张三");
        rank.setRank(1);
        rank.setCollege("数计");
        rank.setDateTime("2022-11-12");
        int  effectedNum = rankDao.updateRank(rank);
        assertEquals(1,effectedNum);
    }

    @Test
    void deleteRank() {
        Rank rank = new Rank();
        rank.setCollegeInfluence(0);
        rank.setGrade(2020);
        rank.setName("张三");
        rank.setRank(1);
        rank.setCollege("数计");
        rank.setDateTime("2022-11-12");
        int  effectedNum = rankDao.deleteRank(rank);
        assertEquals(1,effectedNum);
    }

    @Test
    void queryRankTop10ByGrade() {
        List<Rank> Top10ranklist = rankDao.queryRankTop10ByGrade();
        assertEquals(10,Top10ranklist);
    }

    @Test
    void updateAllUserRank() {
        int effectedNum = rankDao.updateAllUserRank();
        assertEquals(1,effectedNum);
    }

    @Test
    void getCollegeRankTop10() {
        List<Map<String,Integer>> collegeRank = rankDao.getCollegeRankTop10();
        System.out.println(collegeRank);
        assertEquals(10,collegeRank.size());

    }
}