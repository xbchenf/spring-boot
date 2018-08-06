package com.xbchen.springcloud.service.impl;

import com.xbchen.springcloud.dao.UserDao;
import com.xbchen.springcloud.model.User;
import com.xbchen.springcloud.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Resource
	private UserDao userDao;

	@Override
	public User getUserById(Integer id){
		return userDao.getUserById(id);
	}

	@Override
	public List<User> getUserList(){
		return userDao.getUserList();
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRED )
	public void addUser(User user){
		userDao.insertUser(user);
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRED )
	public void deleteUser(Integer id){
		userDao.deleteUserById(id);
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRED )
	public void updateUser(User user){
		userDao.updateUser(user);
	}

	@Override
	@Transactional(propagation= Propagation.REQUIRED )
	public void updateUser2(User user){
		userDao.insertUser(user);
		int a=1/0;//测试事务
		userDao.updateUser(user);
	}



}
