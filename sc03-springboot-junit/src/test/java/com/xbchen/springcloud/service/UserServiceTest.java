package com.xbchen.springcloud.service;

import com.xbchen.springcloud.Application;
import com.xbchen.springcloud.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class UserServiceTest {

	@Resource
	private IUserService userService;

	@Test
	public void testGetUserById(){
		try {
			User user = userService.getUserById(5);
			System.out.println("===========================name:"+user.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testGetUserList(){
		try {
			List<User> users = userService.getUserList();
			System.out.println("==============================="+users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testAddUser(){
		try {
			User user =new User();
			user.setName("xiaomi");
			user.setPassword("99999");
			user.setAge(19);
			userService.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testDeleteUser(){
		try {
			userService.deleteUser(6);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testUpdateUser(){
		try {
			User user =new User();
			user.setId(5);
			user.setName("xiaomi5");
			user.setPassword("5555");
			user.setAge(15);
			userService.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
