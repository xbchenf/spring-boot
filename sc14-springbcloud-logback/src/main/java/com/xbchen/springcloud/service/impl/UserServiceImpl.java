package com.xbchen.springcloud.service.impl;

import com.xbchen.springcloud.dao.UserDao;
import com.xbchen.springcloud.model.User;
import com.xbchen.springcloud.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

	/**
	 * cacheNames 指定缓存的名称
	 * key：指定缓存的key，这是指参数id值。 key可以使用spEl表达式
	 * @param id
	 * @return
	 */
	@Cacheable(cacheNames="user", key="#id")
	@Override
	public User getUserById(Integer id){
		logger.info("走mysql数据库.........");
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

	/**
	 * 对符合key条件的记录从缓存中user移除
	 * 如果不设置key, 设置allEntries = true: 则会清空user里的所有缓存
	 */
	@CacheEvict(cacheNames="user", key="#id")
	@Override
	@Transactional(propagation= Propagation.REQUIRED )
	public void deleteUser(Integer id){
		userDao.deleteUserById(id);
	}

	/**
	 * CachePut 每次执行都会执行方法，无论缓存里是否有值，同时使用新的返回值的替换缓存中的值
	 * @param user
	 */
	@CachePut(cacheNames="user", key="#user.id")
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
