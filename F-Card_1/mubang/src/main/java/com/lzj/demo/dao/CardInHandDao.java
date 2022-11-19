package com.lzj.demo.dao;

import com.lzj.demo.entity.CardInHand;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xcp
 * @version 1.0
 */
@Mapper
@Repository
public interface CardInHandDao {
    List<CardInHand> queryCardInHand();
    CardInHand queryCardInHandByName(String UID,String cardName);
    int insertCardInHand(CardInHand cardInHand);
    int updateCardInHand(CardInHand cardInHand);
    int deleteCardInHand(CardInHand cardInHand);
    List<CardInHand> queryCardInHandByUID(String UID);
}
