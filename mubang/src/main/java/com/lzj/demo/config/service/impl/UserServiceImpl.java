package com.lzj.demo.service.impl;

import com.lzj.demo.dao.UserDao;
import com.lzj.demo.entity.User;
import com.lzj.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xcp
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryUser() {
        return userDao.queryUser();
    }

    @Override
    public User queryUserByUid(String UID) {
        return userDao.queryUserByUid(UID);
    }


    @Transactional
    @Override
    public boolean insertUser(User user) {
        if (user.getUID() != null && !"".equals(user.getName())) {
            try {
                int effectedNum = userDao.insertUser(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入用户失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入用户失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("用户名称不能为空!");
        }
    }

    @Transactional
    @Override
    public boolean updateUser(User user) {
        if (user.getUID() != null && !"".equals(user.getName())) {
            try {
                int effectedNum = userDao.updateUser(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新用户失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新用户失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("用户名称不能为空!");
        }
    }

    @Transactional
    @Override
    public boolean deleteUser(User user) {
        if (user.getUID() != null && !"".equals(user.getName())) {
            try {
                int effectedNum = userDao.deleteUser(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除用户失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除用户失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("用户名称不能为空!");
        }
    }


}