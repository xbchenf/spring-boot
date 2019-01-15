package com.xbchen.springcloud.utils;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class ProfessionBootstrap {
    /**
     * 在初始化servlet时，在init方法之前调用
     */
    @PostConstruct
    public void init() {
        System.out.println("servlet初始化前...........");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("servlet消耗后...........");
    }
}

