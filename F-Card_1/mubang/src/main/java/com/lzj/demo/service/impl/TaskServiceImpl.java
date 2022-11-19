package com.lzj.demo.service.impl;

import com.lzj.demo.dao.TaskDao;
import com.lzj.demo.entity.Task;
import com.lzj.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

/**
 * @author frf
 * @version 1.0
 */
@Service
public class TaskServiceImpl  implements TaskService {
    @Autowired
    private TaskDao taskDao;



    @Override
    public List<Task> queryTask() {
        return taskDao.queryTask();
    }

    @Override
    public Task queryTaskByTaskName(String taskName) {
        return taskDao.queryTaskByTaskName(taskName);
    }

    @Transactional
    @Override
    public boolean insertTask(Task task) {
        if (task.getTaskName() != null && !"".equals(task.getTaskName())) {
            try {
                int effectedNum = taskDao.insertTask(task);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入任务失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入任务失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("任务名称不能为空!");
        }
    }

    @Transactional
    @Override
    public boolean updateTask(Task task) {
        if (task.getTaskName() != null && !"".equals(task.getTaskName())) {
            try {
                int effectedNum = taskDao.updateTask(task);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新任务失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新任务失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("任务名称不能为空!");
        }
    }

    @Transactional
    @Override
    public boolean deleteTask(Task task) {
        if (task.getTaskName() != null && !"".equals(task.getTaskName())) {
            try {
                int effectedNum = taskDao.deleteTask(task);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除任务失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除任务失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("任务名称不能为空!");
        }
    }
}
