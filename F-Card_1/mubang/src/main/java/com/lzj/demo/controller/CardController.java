package com.lzj.demo.controller;

import com.lzj.demo.entity.Card;
import com.lzj.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 林子键
 * @version 1.0
 */
@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/listcard", method = RequestMethod.GET)
    private Map<String,Object> listCard(){
        Map<String,Object> modelMap = new HashMap<>();
        List<Card> list = cardService.queryCard();
        modelMap.put("cardList",list);
        return modelMap;
    }



    @RequestMapping(value = "/getcardbyname",method = RequestMethod.GET)
    private Map<String,Object> getCardByName(String cardName){
        Map<String,Object> modelMap = new HashMap<>();
        Card card = cardService.queryCardByName(cardName);
        modelMap.put("card",card);
        return modelMap;
    }
    @RequestMapping(value = "/insertcard",method = RequestMethod.POST)
    private Map<String,Object> insertCard(@RequestBody Card card){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",cardService.insertCard(card));
        return modelMap;
    }
    @RequestMapping(value = "/updatecard",method = RequestMethod.POST)
    private Map<String,Object> updateCard(@RequestBody Card card){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",cardService.updateCard(card));
        return modelMap;
    }
    @RequestMapping(value = "/deletecard",method = RequestMethod.POST)
    private Map<String,Object> deleteCard(@RequestBody Card card){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",cardService.deleteCard(card));
        return modelMap;
    }
}
