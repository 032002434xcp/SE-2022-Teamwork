package com.lzj.demo.service;

import com.lzj.demo.entity.Task;

import java.util.List;

/**
 * @author frf
 * @version 1.0
 */
public interface TaskService {
    List<Task> queryTask();
    Task queryTaskByTaskName(String taskName);
    boolean insertTask(Task task);
    boolean updateTask(Task task);
    boolean deleteTask(Task task);
}
