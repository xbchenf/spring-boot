package com.xbchen.springcloud.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @description 获取spring上下文
 */
public class SpringContextHolder implements ApplicationContextAware, InitializingBean {

    //Spring 上下文
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    //在bean设置属性执行
    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
