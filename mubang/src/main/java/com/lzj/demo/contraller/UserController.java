package com.lzj.demo.config.contraller;



import com.lzj.demo.entity.*;
import com.lzj.demo.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lzj.demo.utils.HttpRequest.sendGet;

/**
 * @author xcp
 * @version 2.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

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
    @RequestMapping(value = "/insertuser",method = RequestMethod.POST)
    private Map<String,Object> createUser(@RequestBody User user){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",userService.insertUser(user));
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
