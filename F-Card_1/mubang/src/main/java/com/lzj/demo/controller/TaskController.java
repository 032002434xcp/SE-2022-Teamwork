package com.lzj.demo.controller;


import com.lzj.demo.entity.*;
import com.lzj.demo.service.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/listtask", method = RequestMethod.GET)
    private Map<String,Object> listTask(){
        Map<String,Object> modelMap = new HashMap<>();
        List<Task> list = taskService.queryTask();
        modelMap.put("taskList",list);
        return modelMap;
    }
    @RequestMapping(value = "/gettaskbytaskname",method = RequestMethod.GET)
    private Map<String,Object> getTaskByTaskName(String taskName){
        Map<String,Object> modelMap = new HashMap<>();
       Task task = taskService.queryTaskByTaskName(taskName);
        modelMap.put("task",task);
        return modelMap;
    }

    @RequestMapping(value = "/inserttask",method = RequestMethod.POST)
    private Map<String,Object> createUser(@RequestBody Task task){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",taskService.insertTask(task));
        return modelMap;
    }

    @RequestMapping(value = "/updatetask",method = RequestMethod.POST)
    private Map<String,Object> updateTask(@RequestBody Task task){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",taskService.updateTask(task));
        return modelMap;
    }
    @RequestMapping(value = "/deletetask",method = RequestMethod.POST)
    private Map<String,Object> deleteTask(@RequestBody Task task){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",taskService.deleteTask(task));
        return modelMap;
    }
}
