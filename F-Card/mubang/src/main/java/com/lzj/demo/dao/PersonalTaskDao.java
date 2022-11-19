package com.lzj.demo.dao;

import com.lzj.demo.entity.PersonalTask;
import com.lzj.demo.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xcp
 * @version 1.0
 */
@Mapper
@Repository
public interface PersonalTaskDao {
    List<PersonalTask> queryPersonalTask();
    List<PersonalTask> queryPersonalTaskByUID(String UID);
    int insertPersonalTask(PersonalTask personalTask);
    int updatePersonalTask(PersonalTask personalTask);
    int deletePersonalTask(String UID,String taskName);

}
