package com.xbchen.springboot.hibernate.dao;

import com.xbchen.springboot.hibernate.model.Test1Entity;

/**
 * Created by xbchen on 2016/9/5.
 */
public interface ITestDAO {
    Test1Entity get(Integer id);

    void save(Object o);
}
