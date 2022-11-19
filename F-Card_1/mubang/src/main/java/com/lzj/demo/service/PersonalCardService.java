package com.lzj.demo.service;

import com.lzj.demo.entity.PersonalCard;
import com.lzj.demo.entity.User;

import java.util.List;

/**
 * @author xcp
 * @version 1.0
 */
public interface PersonalCardService {

    List<PersonalCard> queryPersonalCard();
    PersonalCard queryPersonalCardByName(String UID,String cardName);
    boolean insertPersonalCard(PersonalCard personalCard);
    boolean updatePersonalCard(PersonalCard personalCard);
    boolean deletePersonalCard(String UID,String cardName);
    PersonalCard rollCard(User user);
    List<PersonalCard> queryPersonalCardByUID(String UID);
    PersonalCard dispatchCard(PersonalCard personalCard,String dismethod);
    String finishResult(PersonalCard personalCard,User user);
}
