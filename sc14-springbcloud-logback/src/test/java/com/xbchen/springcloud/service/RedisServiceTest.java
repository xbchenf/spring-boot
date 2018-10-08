package com.xbchen.springcloud.service;

import com.xbchen.springcloud.Application;
import com.xbchen.springcloud.model.User;
import com.xbchen.springcloud.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbchen
 * @date 2018-8-4 12:02:28
 * @description redis测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class RedisServiceTest {


    @Autowired
    private IRedisService redisService;


    /**
     * 插入字符串
     */
    @Test
    public void setString() {
        redisService.set("key1", "springboot redis test");
    }

    /**
     * 获取字符串
     */
    @Test
    public void getString() {
        String result = (String)redisService.get("key1");
        System.out.println("redis string:"+result);
    }

    /**
     * 插入对象
     */
    @Test
    public void setObject() {
        User user = new User(11,"person", "123",20);
        redisService.set("redis_obj_test", user);
    }

    /**
     * 获取对象
     */
    @Test
    public void getObject() {
        try{
            User result = (User)redisService.get("redis_obj_test");
            System.out.println("user>>>>>>>>>>>>>>>>"+result.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 插入对象List
     */
    @Test
    public void setList() {
        User user1 = new User(1,"person1", "123",21);
        User user2 = new User(2,"person2", "456",22);
        User user3 = new User(3,"person3", "789",23);
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        redisService.lSet("redis_list_test",list);
    }

    /**
     * 获取list
     */
    @Test
    public void getList() {
        try{
            List<Object> result = redisService.lGet("redis_list_test",0,1);
            System.out.println("redis_list_test>>>>>>>>>>>>>>>"+result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void remove() {
        redisService.del("key1");
    }
}