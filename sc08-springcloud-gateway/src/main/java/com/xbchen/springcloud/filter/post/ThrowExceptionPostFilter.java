/*
package com.xbchen.springcloud.filter.post;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

*/
/**
 * 异常测试类, 仅用于测试postRoute阶段的异常
 *//*

@Component
public class ThrowExceptionPostFilter extends ZuulFilter  {

    private static Logger log = LoggerFactory.getLogger(ThrowExceptionPostFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        log.info("This is a post filter, it will throw a RuntimeException");
        //doSomething();
        RequestContext context=RequestContext.getCurrentContext();
        try{
            doSomething();
        }catch (Exception e){
            context.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            context.set("error.exception",3);
        }
        return null;
    }

    private void doSomething() {
        throw new RuntimeException("Exist some errors...");
    }

}
*/
