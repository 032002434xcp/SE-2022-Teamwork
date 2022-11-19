package com.lzj.demo.service;

import com.lzj.demo.entity.CardInHand;

import java.util.List;

/**
 * @author xcp
 * @version 1.0
 */
public interface CardInHandService {

    List<CardInHand> queryCardInHand();
    CardInHand queryCardInHandByName(String UID,String cardName);
    boolean insertCardInHand(CardInHand cardInHand);
    boolean updateCardInHand(CardInHand cardInHand);
    boolean deleteCardInHand(CardInHand cardInHand);
    List<CardInHand>queryCardInHandByUID(String UID);

}
