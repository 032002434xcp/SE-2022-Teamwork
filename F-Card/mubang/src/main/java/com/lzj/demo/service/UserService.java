package com.lzj.demo.service;

import com.lzj.demo.entity.User;

import java.util.List;

/**
 * @author xcp
 * @version 1.0
 */
public interface UserService {

    List<User> queryUser();
    User queryUserByUid(String UID);
    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);
}
