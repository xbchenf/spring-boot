package com.xbchen.springboot.hibernate.dao.impl;

import com.xbchen.springboot.hibernate.dao.ITestDAO;
import com.xbchen.springboot.hibernate.model.Test1Entity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by xbchen on 2016/9/5.
 */
@Repository("testDAO")
public class TestDAOImpl extends HibernateDaoSupport implements ITestDAO {

    @Autowired
    public void setMySessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public Test1Entity get(Integer id) {
        Test1Entity test1 = this.getHibernateTemplate().get(Test1Entity.class,id);
        return test1;
    }

    @Override
    public void save(Object o) {
        this.getHibernateTemplate().save(o);
    }
}
