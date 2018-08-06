package com.xbchen.springcloud.mongodb.dao;

import com.xbchen.springcloud.Application;
import com.xbchen.springcloud.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author xbchen
 * @date 2018-8-4 16:56:57
 * @description mongodb测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class TestUserMongodbDao{

        @Autowired
        private UserMongodbDao userDao;

        @Test
        public void testUser() throws Exception {
            //1.mongodb保存
            User user=new User();
            user.setId(1);
            user.setName("xiaobing");
            user.setPassword("123456");
            user.setAge(21);
            userDao.save(user);

            //2.mongodb查询
            Query<User> q =userDao.createQuery();
            q.filter("id", 1);
            User result =q.get();
            System.out.println(result.toString());

            //3.mongodb查询
            User result1 =userDao.findOne("id",1);
            System.out.println(result1.toString());
        }
}
