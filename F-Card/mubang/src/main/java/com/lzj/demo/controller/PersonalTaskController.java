package com.lzj.demo.controller;

import com.lzj.demo.entity.PersonalCard;
import com.lzj.demo.entity.PersonalTask;
import com.lzj.demo.entity.User;
import com.lzj.demo.service.PersonalCardService;
import com.lzj.demo.service.PersonalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/personalTask")
public class PersonalTaskController {
    @Autowired
    private PersonalTaskService personalTaskService;

    @RequestMapping(value = "/listpersonaltask", method = RequestMethod.GET)
    private Map<String,Object> listPersonalTask(){
        Map<String,Object> modelMap = new HashMap<>();
        List<PersonalTask> list = personalTaskService.queryPersonalTask();
        modelMap.put("personalTaskList",list);
        return modelMap;
    }

    @RequestMapping(value = "/getpersonaltaskbyuid",method = RequestMethod.GET)
    private Map<String,Object> getPersonalTaskByUid(String UID){
        Map<String,Object> modelMap = new HashMap<>();
        List<PersonalTask> personalTaskList = personalTaskService.queryPersonalTaskByUID(UID);
        modelMap.put("personalTaskList",personalTaskList);
        return modelMap;
    }
    @RequestMapping(value = "/insertpersonaltask",method = RequestMethod.POST)
    private Map<String,Object> insertPersonalTask(@RequestBody PersonalTask personalTask){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",personalTaskService.insertPersonalTask(personalTask));
        return modelMap;
    }
    @RequestMapping(value = "/updatepersonaltask",method = RequestMethod.POST)
    private Map<String,Object> updatePersonalTask(@RequestBody PersonalTask personalTask){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",personalTaskService.updatePersonalTask(personalTask));
        return modelMap;
    }
    @RequestMapping(value = "/deletepersonaltask",method = RequestMethod.GET)
    private Map<String,Object> deletePersonalTask(@RequestParam(value = "UID") String UID, @RequestParam(value = "taskName") String taskName){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",personalTaskService.deletePersonalTask(UID,taskName));
        return modelMap;
    }


}
