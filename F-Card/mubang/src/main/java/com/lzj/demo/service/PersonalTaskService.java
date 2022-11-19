package com.lzj.demo.service;

import com.lzj.demo.entity.PersonalTask;
import com.lzj.demo.entity.Question;

import java.util.List;


public interface PersonalTaskService {
    List<PersonalTask> queryPersonalTask();
    List<PersonalTask> queryPersonalTaskByUID(String UID);
    boolean insertPersonalTask(PersonalTask personalTask);
    boolean updatePersonalTask(PersonalTask personalTask);
    boolean deletePersonalTask(String UID,String taskName);
}
