package com.xbchen.springcloud.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 需要主类加入
 * @ServletComponentScan
 *
 * 监听器用于监听web应用中某些对象、信息的创建、销毁、增加，修改，删除等动作的发生，然后作出相应的响应处理。
 * 当范围对象的状态发生变化的时候，服务器自动调用监听器对象中的方法。
 * 常用于统计在线人数和在线用户，系统加载时进行信息初始化，统计网站的访问量等等。
    按监听的对象划分，可以分为
    ServletContext对象监听器
    HttpSession对象监听器
    ServletRequest对象监听器
    按监听的事件划分
    对象自身的创建和销毁的监听器
    对象中属性的创建和消除的监听器

    session中的某个对象的状态变化的监听
 */
@WebListener
public class MyListener implements ServletContextListener {
    private static Logger LOG= LoggerFactory.getLogger(MyListener.class);
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOG.info("firstListener  初始化...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOG.info("MyListener  销毁...");
    }
}