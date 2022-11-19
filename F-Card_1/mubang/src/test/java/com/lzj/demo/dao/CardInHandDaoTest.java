package com.lzj.demo.dao;

import com.lzj.demo.entity.CardInHand;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class CardInHandDaoTest {

    @Autowired(required = false)
    private CardInHandDao cardInHandDao;

    @Test
    void insertCardInHand() {
        CardInHand cardInHand = new CardInHand();
        cardInHand.setAbility1(100);
        cardInHand.setAbility2(100);
        cardInHand.setAbility3(100);
        cardInHand.setAbility4(100);
        cardInHand.setAbility5(100);
        cardInHand.setCardLevel(100);
        cardInHand.setExperience(100);
        cardInHand.setRank("教授");
        cardInHand.setCardName("张栋");
        cardInHand.setIntroduction("好好好");
        cardInHand.setPreferance("软件工程");
        cardInHand.setUID("0001");
        int effectedNum = cardInHandDao.insertCardInHand(cardInHand);
        assertEquals(1,effectedNum);
    }

    @Test
    void queryCardInHand() {
        List<CardInHand> cardInHandList = cardInHandDao.queryCardInHand();
        assertEquals(1,cardInHandList.size());
    }



    @Test
    void queryCardInHandByName() {
        CardInHand cardInHand = new CardInHand();
        cardInHand.setAbility1(100);
        cardInHand.setAbility2(100);
        cardInHand.setAbility3(100);
        cardInHand.setAbility4(100);
        cardInHand.setAbility5(100);
        cardInHand.setCardLevel(100);
        cardInHand.setExperience(100);
        cardInHand.setRank("教授");
        cardInHand.setCardName("张栋");
        cardInHand.setIntroduction("好好好");
        cardInHand.setPreferance("软件工程");
        cardInHand.setUID("0001");
        CardInHand effectedNum = cardInHandDao.queryCardInHandByName(cardInHand.getUID(),cardInHand.getCardName());
        assertEquals(cardInHand,effectedNum);
    }

    /*
    逻辑不确定 原本是以name查询并修改 我暂时修改为了查询uid修改
     */
    @Test
    void updateCardInHand() {
        CardInHand cardInHand = new CardInHand();
        cardInHand.setAbility1(200);
        cardInHand.setAbility2(100);
        cardInHand.setAbility3(100);
        cardInHand.setAbility4(100);
        cardInHand.setAbility5(100);
        cardInHand.setCardLevel(100);
        cardInHand.setExperience(100);
        cardInHand.setRank("教授");
        cardInHand.setCardName("张栋");
        cardInHand.setIntroduction("好好好");
        cardInHand.setPreferance("软件工程");
        cardInHand.setUID("0001");
        int effectedNum = cardInHandDao.updateCardInHand(cardInHand);
        assertEquals(1,effectedNum);
    }

    @Test
    void deleteCardInHand() {
        CardInHand cardInHand = new CardInHand();
        cardInHand.setAbility1(100);
        cardInHand.setAbility2(100);
        cardInHand.setAbility3(100);
        cardInHand.setAbility4(100);
        cardInHand.setAbility5(100);
        cardInHand.setCardLevel(100);
        cardInHand.setExperience(100);
        cardInHand.setRank("教授");
        cardInHand.setCardName("张栋");
        cardInHand.setIntroduction("好好好");
        cardInHand.setPreferance("软件工程");
        cardInHand.setUID("0001");
        int effectedNum = cardInHandDao.deleteCardInHand(cardInHand);
        assertEquals(1,effectedNum);
    }
}