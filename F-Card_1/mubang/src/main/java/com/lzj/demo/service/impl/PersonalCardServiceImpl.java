package com.lzj.demo.service.impl;

import com.lzj.demo.dao.PersonalCardDao;
import com.lzj.demo.dao.UserDao;
import com.lzj.demo.entity.Card;
import com.lzj.demo.entity.PersonalCard;
import com.lzj.demo.service.PersonalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lzj.demo.entity.User;
import com.lzj.demo.dao.CardDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author xcp
 * @version 1.0
 */
@Service
public class PersonalCardServiceImpl implements PersonalCardService {
    @Autowired
    private PersonalCardDao personalCardDao;
    @Autowired
    private CardDao cardDao;
    @Autowired
    private UserDao userDao;

    @Override
    public List<PersonalCard> queryPersonalCard() {
        return personalCardDao.queryPersonalCard();
    }
    @Override
    public List<PersonalCard> queryPersonalCardByUID(String UID) {
        return personalCardDao.queryPersonalCardByUID(UID);
    }

    @Override
    public PersonalCard queryPersonalCardByName(String UID,String cardName) {
        return personalCardDao.queryPersonalCardByName(UID,cardName);
    }

    @Transactional
    @Override
    public boolean insertPersonalCard(PersonalCard personalCard) {
        if (personalCard.getUID() != null && !"".equals(personalCard.getUID())) {
            try {
                int effectedNum = personalCardDao.insertPersonalCard(personalCard);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入卡牌失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入卡牌失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("卡牌名称不能为空!");
        }
    }

    @Transactional
    @Override
    public boolean updatePersonalCard(PersonalCard personalCard) {
        if (personalCard.getUID() != null && !"".equals(personalCard.getUID())) {
            try {
                int effectedNum = personalCardDao.updatePersonalCard(personalCard);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新卡牌失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新卡牌失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("卡牌名称不能为空!");
        }
    }

    @Transactional
    @Override
    public boolean deletePersonalCard(String UID,String cardName) {
        if (UID != null && !"".equals(UID)) {
            try {
                int effectedNum = personalCardDao.deletePersonalCard(UID,cardName);
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

    @Transactional
    @Override
    public PersonalCard rollCard(User user) {
        int influence = user.getCollegeInfluence();
        if (influence != 0) {
            try {
                Card card = new Card();
                List<Card> cardList = null;
                double x = Math.random() * influence;
                //抽卡逻辑
                if (x < 100) {
                    cardList = cardDao.queryCardByRank("讲师");
                } else if (x < 1000) {
                    cardList = cardDao.queryCardByRank("副教授");
                } else if (x < 10000) {
                    cardList = cardDao.queryCardByRank("教授");
                } else{
                    cardList = cardDao.queryCardByRank("学士");
                }
                card = cardList.get((int) (Math.random() * cardList.size()));
                //查找数据库中该玩家有无该卡
                PersonalCard personalCard1 = queryPersonalCardByName(user.getUID(),card.getCardName());
                //若null，则没有，就插入该卡
                if(personalCard1 == null){
                    PersonalCard personalCard2 = new PersonalCard(card.getAbility1(),card.getAbility2(),
                            card.getAbility3(),card.getAbility4(),card.getAbility5(),card.getCardLevel(),
                            card.getExperience(),card.getRank(),card.getCardName(),card.getIntroduction(),
                            card.getPreferance(),"闲置",user.getUID(),"",1);
                    personalCardDao.insertPersonalCard(personalCard2);
                    personalCard1 = personalCard2;
                }else{
                    //若！null，则将卡牌数量+1并更新
                    personalCard1.setDuplicateCards(personalCard1.getDuplicateCards()+1);
                    personalCardDao.updatePersonalCard(personalCard1);
                }
                //返回卡牌
                return personalCard1;
            }catch (Exception e){
                throw new RuntimeException("抽卡失败");
            }
        }else{
            throw new RuntimeException("影响力不能为0!");
        }
    }
    @Transactional
    @Override
    public PersonalCard dispatchCard(PersonalCard personalCard,String dismethod) {
        Date newTime = new Date();
        if (personalCard.getSituation().equals("闲置")) {
            try {
                personalCard.setSituation(dismethod);
                personalCard.setDateTime(String.format("%tF %tT", newTime, newTime));
                personalCardDao.updatePersonalCard(personalCard);
            } catch (Exception e) {
                throw new RuntimeException("选择失败");
            }
        }
        return personalCard;
    }
    @Transactional
    @Override
    public String finishResult(PersonalCard personalCard,User user) {
        Date newTime = new Date();
        Date oldTime;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            oldTime = simpleDateFormat.parse(personalCard.getDateTime());
        } catch (ParseException e) {
            throw new RuntimeException("赋值错误");
        }
        Date newTime1 = new Date(newTime.getTime() - 24 * 60 * 60 * 1000);
        if (personalCard.getSituation().equals("科研")) {
            if (newTime1.compareTo(oldTime) < 0) {
                return String.format("%tF %tT",newTime.getTime() - oldTime.getTime(),newTime.getTime() - oldTime.getTime());
            } else {
                personalCard.setSituation("闲置");
                personalCard.setDateTime(String.format("%tF %tT", newTime, newTime));
                personalCard.setExperience(personalCard.getExperience() + 100);
                if (personalCard.getExperience() >= 1000) {
                    personalCard.setCardLevel(personalCard.getCardLevel() + 1);
                    personalCard.setExperience(personalCard.getExperience() - 1000);
                }
                user.setCoin(user.getCoin() + 10);
                user.setCollegeInfluence(user.getCollegeInfluence() + 100);
                personalCardDao.updatePersonalCard(personalCard);
                userDao.updateUser(user);
            }
        } else if (personalCard.getSituation().equals("教学")) {
            if (newTime1.compareTo(oldTime) < 0) {
                return String.format("%tF %tT",newTime.getTime() - oldTime.getTime(),newTime.getTime() - oldTime.getTime());
            } else {
                personalCard.setSituation("闲置");
                personalCard.setDateTime(String.format("%tF %tT", newTime, newTime));
                personalCard.setExperience(personalCard.getExperience() + 100);
                if (personalCard.getExperience() >= 1000) {
                    personalCard.setCardLevel(personalCard.getCardLevel() + 1);
                    personalCard.setExperience(personalCard.getExperience() - 1000);
                }
                user.setCoin(user.getCoin() + 5);
                user.setCollegeInfluence(user.getCollegeInfluence() + 50);
                personalCardDao.updatePersonalCard(personalCard);
                userDao.updateUser(user);
            }
        }
        return "派遣完成";
    }
}
