package com.lzj.demo.dao;

import com.lzj.demo.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author frf
 * @version 1.0
 */
@Mapper
@Repository
public interface TaskDao {
    List<Task> queryTask();
    Task queryTaskByTaskName(String taskName);
    int insertTask(Task task);
    int updateTask(Task task);
    int deleteTask(Task task);
}
