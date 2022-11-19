package com.lzj.demo.dao;

import com.lzj.demo.entity.Card;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 林子键
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
class CardDaoTest {

    @Autowired(required = false)
    private CardDao cardDao;

    @Test
    @Ignore
    void insertCard() {
        Card card = new Card();
        card.setAbility1(100);
        card.setAbility2(100);
        card.setAbility3(100);
        card.setAbility4(100);
        card.setAbility5(100);
        card.setCardLevel(100);
        card.setCardName("张栋");
        card.setExperience(100);
        card.setIntroduction("好好好");
        card.setPreferance("软件工程");
        card.setRank("教授");
        int effectedNum = cardDao.insertCard(card);
        assertEquals(1,effectedNum);
    }

    @Test
    @Ignore
    void queryCard() {
        List<Card> cardList = cardDao.queryCard();
        assertEquals(1,cardList.size());
    }


    @Test
    @Ignore
    void queryCardByName() {
        Card card = new Card();
        card.setAbility1(100);
        card.setAbility2(100);
        card.setAbility3(100);
        card.setAbility4(100);
        card.setAbility5(100);
        card.setCardLevel(100);
        card.setCardName("张栋");
        card.setExperience(100);
        card.setIntroduction("好好好");
        card.setPreferance("软件工程");
        card.setRank("教授");
        Card effectedNum = cardDao.queryCardByName(card.getCardName());
        assertEquals(card,effectedNum);
    }
    @Test
    void updateCard() {
        Card card = new Card();
        card.setAbility1(200);
        card.setAbility2(100);
        card.setAbility3(100);
        card.setAbility4(100);
        card.setAbility5(100);
        card.setCardLevel(100);
        card.setCardName("张栋");
        card.setExperience(100);
        card.setIntroduction("好好好");
        card.setPreferance("软件工程");
        card.setRank("教授");
        int effectedNum = cardDao.updateCard(card);
        assertEquals(1,effectedNum);
    }

    @Test
    void deleteCard() {
        Card card = new Card();
        card.setAbility1(100);
        card.setAbility2(100);
        card.setAbility3(100);
        card.setAbility4(100);
        card.setAbility5(100);
        card.setCardLevel(100);
        card.setCardName("张栋");
        card.setExperience(100);
        card.setIntroduction("好好好");
        card.setPreferance("软件工程");
        card.setRank("教授");
        int effectedNum = cardDao.deleteCard(card);
        assertEquals(1,effectedNum);
    }
}