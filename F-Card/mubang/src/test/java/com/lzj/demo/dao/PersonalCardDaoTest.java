package com.lzj.demo.dao;

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
class PersonalCardDaoTest {

    @Autowired(required = false)
    private PersonalCardDao personalCardDao;

    @Test
    void insertPersonalCard() {
        PersonalCard personalCard = new PersonalCard();
        personalCard.setAbility1(100);
        personalCard.setAbility2(100);
        personalCard.setAbility3(100);
        personalCard.setAbility4(100);
        personalCard.setAbility5(100);
        personalCard.setCardLevel(100);
        personalCard.setExperience(100);
        personalCard.setRank("教授");
        personalCard.setCardName("张栋");
        personalCard.setIntroduction("好好好");
        personalCard.setPreferance("软件工程");
        personalCard.setSituation("忙碌");
        personalCard.setUID("0001");
        personalCard.setDateTime("2022-11-12");
        personalCard.setDuplicateCards(5);
        int effectedNum = personalCardDao.insertPersonalCard(personalCard);
        assertEquals(1,effectedNum);
    }


    @Test
    void queryPersonalCard() {
        List<PersonalCard> personalCardList = personalCardDao.queryPersonalCard();
        assertEquals(1,personalCardList.size());
    }

    @Test
    void queryPersonalCardByName() {
        PersonalCard personalCard = new PersonalCard();
        personalCard.setAbility1(100);
        personalCard.setAbility2(100);
        personalCard.setAbility3(100);
        personalCard.setAbility4(100);
        personalCard.setAbility5(100);
        personalCard.setCardLevel(100);
        personalCard.setExperience(100);
        personalCard.setRank("教授");
        personalCard.setCardName("张栋");
        personalCard.setIntroduction("好好好");
        personalCard.setPreferance("软件工程");
        personalCard.setSituation("忙碌");
        personalCard.setUID("0001");
        personalCard.setDateTime("2022-11-12");
        personalCard.setDuplicateCards(5);
        PersonalCard effectedNum = personalCardDao.queryPersonalCardByName(personalCard.getUID(),personalCard.getCardName());
        assertEquals(personalCard,effectedNum);
    }



    @Test
    void updatePersonalCard() {
        PersonalCard personalCard = new PersonalCard();
        personalCard.setAbility1(200);
        personalCard.setAbility2(100);
        personalCard.setAbility3(100);
        personalCard.setAbility4(100);
        personalCard.setAbility5(100);
        personalCard.setCardLevel(100);
        personalCard.setExperience(100);
        personalCard.setRank("教授");
        personalCard.setCardName("张栋");
        personalCard.setIntroduction("好好好");
        personalCard.setPreferance("软件工程");
        personalCard.setSituation("忙碌");
        personalCard.setUID("0001");
        personalCard.setDateTime("2022-11-12");
        personalCard.setDuplicateCards(5);
        int  effectedNum = personalCardDao.updatePersonalCard(personalCard);
        assertEquals(1,effectedNum);
    }

    @Test
    void deletePersonalCard() {
        PersonalCard personalCard = new PersonalCard();
        personalCard.setAbility1(100);
        personalCard.setAbility2(100);
        personalCard.setAbility3(100);
        personalCard.setAbility4(100);
        personalCard.setAbility5(100);
        personalCard.setCardLevel(100);
        personalCard.setExperience(100);
        personalCard.setRank("教授");
        personalCard.setCardName("张栋");
        personalCard.setIntroduction("好好好");
        personalCard.setPreferance("软件工程");
        personalCard.setSituation("忙碌");
        personalCard.setUID("0001");
        personalCard.setDateTime("2022-11-12");
        personalCard.setDuplicateCards(5);
        int  effectedNum = personalCardDao.deletePersonalCard("0001","张栋");
        assertEquals(1,effectedNum);
    }
}