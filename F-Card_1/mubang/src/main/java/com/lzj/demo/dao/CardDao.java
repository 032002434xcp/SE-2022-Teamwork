package com.lzj.demo.dao;

import com.lzj.demo.entity.Card;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 林子键
 * @version 1.0
 */
@Mapper
@Repository
public interface CardDao {
    List<Card> queryCard();
    Card queryCardByName(String cardName);
    List<Card> queryCardByRank(String rank);
    int insertCard(Card card);
    int updateCard(Card card);
    int deleteCard(Card card);


}
