package com.xbchen.springcloud.service;

import com.xbchen.springcloud.model.User;

import java.util.List;

public interface IUserService {

	User getUserById(Integer id);

	List<User> getUserList();

	void addUser(User user);

	void deleteUser(Integer id);

	void updateUser(User user);

	void updateUser2(User user);
}
