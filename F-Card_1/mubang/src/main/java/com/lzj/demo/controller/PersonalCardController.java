package com.lzj.demo.controller;

import com.lzj.demo.entity.PersonalCard;
import com.lzj.demo.entity.User;
import com.lzj.demo.service.PersonalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lzj
 * @version 2.0
 */
@RestController
@RequestMapping("/personalCard")
public class PersonalCardController {
    @Autowired
    private PersonalCardService personalCardService;

    @RequestMapping(value = "/listpersonalcard", method = RequestMethod.GET)
    private Map<String,Object> listPersonalCard(){
        Map<String,Object> modelMap = new HashMap<>();
        List<PersonalCard> list = personalCardService.queryPersonalCard();
        modelMap.put("personalCardList",list);
        return modelMap;
    }
    @RequestMapping(value = "/getpersonalcardbyname",method = RequestMethod.GET)
    private Map<String,Object> getPersonalCardByName(@RequestParam(value = "UID") String UID, @RequestParam(value = "cardName") String cardName){
        Map<String,Object> modelMap = new HashMap<>();
        PersonalCard personalCard = personalCardService.queryPersonalCardByName(UID,cardName);
        modelMap.put("personalCard",personalCard);
        return modelMap;
    }
    @RequestMapping(value = "/getpersonalcardbyuid",method = RequestMethod.GET)
    private Map<String,Object> getPersonalCardByUid(String UID){
        Map<String,Object> modelMap = new HashMap<>();
        List<PersonalCard> personalCardList = personalCardService.queryPersonalCardByUID(UID);
        modelMap.put("personalCardList",personalCardList);
        return modelMap;
    }
    @RequestMapping(value = "/insertpersonalcard",method = RequestMethod.POST)
    private Map<String,Object> insertPersonalCard(@RequestBody PersonalCard personalCard){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",personalCardService.insertPersonalCard(personalCard));
        return modelMap;
    }
    @RequestMapping(value = "/updatepersonalcard",method = RequestMethod.POST)
    private Map<String,Object> updatePersonalCard(@RequestBody PersonalCard personalCard){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",personalCardService.updatePersonalCard(personalCard));
        return modelMap;
    }
    @RequestMapping(value = "/deletepersonalcard",method = RequestMethod.GET)
    private Map<String,Object> deletePersonalCard(@RequestParam(value = "UID") String UID, @RequestParam(value = "cardName") String cardName){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",personalCardService.deletePersonalCard(UID,cardName));
        return modelMap;
    }
    @RequestMapping(value = "/rollpersonalcard",method = RequestMethod.POST)
    private Map<String,Object> rollPersonalCard(@RequestBody User user){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("personalCard",personalCardService.rollCard(user));
        return modelMap;
    }
    @RequestMapping(value = "/dispatchpersonalcard",method = RequestMethod.POST)
    private Map<String,Object> dispatchPersonalCard(@RequestBody PersonalCard personalCard,String dismethod,User user){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("dispatchCard",personalCardService.dispatchCard(personalCard,dismethod));
        modelMap.put("finishResult",personalCardService.finishResult(personalCard,user));
        return modelMap;
    }
}
