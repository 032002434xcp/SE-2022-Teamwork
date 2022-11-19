package com.lzj.demo.controller;



import com.lzj.demo.entity.*;
import com.lzj.demo.service.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lzj.demo.utils.HttpRequest.sendGet;

/**
 * @author lzj
 * @version 2.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CardService cardService;
    @Autowired
    private PersonalCardService personalCardService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CardInHandService cardInHandService;

    @RequestMapping(value = "/listuser", method = RequestMethod.GET)
    private Map<String,Object> listUser(){
        Map<String,Object> modelMap = new HashMap<>();
        List<User> list = userService.queryUser();
        modelMap.put("userList",list);
        return modelMap;
    }
    @RequestMapping(value = "/getuserbyname",method = RequestMethod.GET)
    private Map<String,Object> getUserByName(String UID){
        Map<String,Object> modelMap = new HashMap<>();
        User user = userService.queryUserByUid(UID);
        modelMap.put("user",user);
        return modelMap;
    }
    @RequestMapping(value="/getopenid")
    public Object openid(HttpServletRequest request){
        String wxspAppid = "";
        String wxspSecret = "";
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> datamap = new HashMap<>();
        try {
            String code = request.getParameter("code");
            //请求参数
            String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + "authorization_code";
            //发送请求
            String sr = sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
            //解析相应内容（转换成json对象）
            JSONObject json = JSONObject.fromObject(sr);
            //获取会话密钥（session_key）
            String session_key = json.get("session_key").toString();
            //用户的唯一标识（openid）
            String openid = (String) json.get("openid");
            map.put("res",1);
            map.put("error","");
            datamap.put("openid",openid);
            datamap.put("session_key",session_key);
            map.put("data",datamap);
        }catch (Exception e){
            map.put("res", 0);
            map.put("error", "error");
            map.put("data", null);
        }
        return map;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    private Map<String,Object> createUser(@RequestBody User user){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",userService.insertUser(user));
        return modelMap;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    private Map<String,Object> loginUser(String UID){
        Map<String,Object> modelMap = new HashMap<>();
        User user = userService.queryUserByUid(UID);
        List<Card> cardList=cardService.queryCard();
        List<PersonalCard> personalCardList=personalCardService.queryPersonalCardByUID(UID);
        List<CardInHand> cardInHandList=cardInHandService.queryCardInHandByUID(UID);
        List<Question> questionList=questionService.queryQuestion();
        if(user != null) {
            modelMap.put("success", true);
            modelMap.put("cardList", cardList);
            modelMap.put("cardInHandList", cardInHandList);
            modelMap.put("user", user);
            modelMap.put("questionList", questionList);
            modelMap.put("personalCardList", personalCardList);
        }else{
            modelMap.put("success",false);
        }
        return modelMap;
    }
    @RequestMapping(value = "/updateuser",method = RequestMethod.POST)
    private Map<String,Object> updateUser(@RequestBody User user){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",userService.updateUser(user));
        return modelMap;
    }
    @RequestMapping(value = "/deleteuser",method = RequestMethod.POST)
    private Map<String,Object> deleteUser(@RequestBody User user){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",userService.deleteUser(user));
        return modelMap;
    }
}
