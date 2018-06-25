package com.xbchen.springboot.hibernate.service;

import com.xbchen.springboot.hibernate.model.Test1Entity;

/**
 * Created by xbchen on 2017/1/5.
 */
public interface ITestService {
    Test1Entity testGet(Integer integer);

    void testSaveTransaction() throws Exception;
}
