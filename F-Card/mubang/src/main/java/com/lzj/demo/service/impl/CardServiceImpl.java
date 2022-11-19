package com.lzj.demo.service.impl;

import com.lzj.demo.dao.CardDao;
import com.lzj.demo.entity.Card;
import com.lzj.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

/**
 * @author 林子键
 * @version 1.0
 */
@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardDao cardDao;



    @Override
    public List<Card> queryCard() {
        return cardDao.queryCard();
    }

    @Override
    public Card queryCardByName(String cardName) {
        return cardDao.queryCardByName(cardName);
    }

    @Transactional
    @Override
    public boolean insertCard(Card card) {
        if (card.getCardName() != null && !"".equals(card.getCardName())) {
            try {
                int effectedNum = cardDao.insertCard(card);
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
    public boolean updateCard(Card card) {
        if (card.getCardName() != null && !"".equals(card.getCardName())) {
            try {
                int effectedNum = cardDao.updateCard(card);
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
    public boolean deleteCard(Card card) {
        if (card.getCardName() != null && !"".equals(card.getCardName())) {
            try {
                int effectedNum = cardDao.deleteCard(card);
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

    @Override
    public List<Card> queryCardByRank(String rank){
        return cardDao.queryCardByRank(rank);
    }

}