package com.xbchen.springcloud.dao;

import com.xbchen.springcloud.model.User;

import java.util.List;

/**
 * Created by xbchen on 2018/06/25.
 */
public interface UserDao {

    User getUserById(Integer id);

    List<User> getUserList();

    void insertUser(User user);

    void deleteUserById(Integer id);

    void updateUser(User user);

}
