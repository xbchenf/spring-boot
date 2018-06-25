package com.xbchen.springboot.hibernate.service.impl;

import com.xbchen.springboot.hibernate.dao.ITestDAO;
import com.xbchen.springboot.hibernate.model.Test1Entity;
import com.xbchen.springboot.hibernate.model.Test2Entity;
import com.xbchen.springboot.hibernate.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xbchen on 2016/9/5.
 */
@Service("testService")
public class TestServiceImpl implements ITestService {

    @Autowired
    ITestDAO testDAO;

    @Override
    public Test1Entity testGet(Integer id) {
        return this.testDAO.get(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testSaveTransaction() throws Exception{
        Test1Entity test1 = new Test1Entity();
        test1.setUserName("xbchenlin1");
        this.testDAO.save(test1);

        //int i = 9 / 0; 用于测试事务
        Test2Entity test2Entity = new Test2Entity();
        test2Entity.setUserName("xbchenlin2");
        this.testDAO.save(test2Entity);
    }
}
