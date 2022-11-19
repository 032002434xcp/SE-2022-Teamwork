package com.lzj.demo.dao;

import com.lzj.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xcp
 * @version 1.0
 */
@Mapper
@Repository
public interface UserDao {
    List<User> queryUser();
    User queryUserByUid(String UID);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(User user);

}
