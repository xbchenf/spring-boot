package com.xbchen.springcloud.utils;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.ServletRegistration;

/**
 * @description 添加拦截器
 * 路径只有走DispacherServlet，才会被拦截，默认静态资源不会被拦截，拦截器需要注册，一般需要在config中注册该拦截器，才能在项目中使用
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/*");
        super.addInterceptors(registry);
    }

    /*public ServletRegistrationBean myServlet(){
        return new ServletRegistrationBean(new MyServlet(),"/myServlet/*");
    }*/
}
