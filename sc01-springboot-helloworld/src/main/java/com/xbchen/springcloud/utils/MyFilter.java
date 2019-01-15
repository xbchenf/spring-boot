package com.xbchen.springcloud.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 会过滤到地址栏为以下参数的请求
 * 需要主类加入@ServletComponentScan
 *
 * 过滤器，主要的用途是过滤字符编码、做一些业务逻辑判断等
 *
 * 对web服务器管理的所有web资源：例如Jsp, Servlet, 静态图片文件或静态 html 文件等进行拦截，从而实现一些特殊的功能。
 * 例如实现URL级别的权限访问控制、过滤敏感词汇、压缩响应信息等一些高级功能。
   它主要用于对用户请求进行预处理，也可以对HttpServletResponse进行后处理。
 使用Filter的完整流程：Filter对用户请求进行预处理，接着将请求交给Servlet进行处理并生成响应，最后Filter再对服务器响应进行后处理
 */
@WebFilter(filterName = "firstFilter",urlPatterns = {"/test/*","/hello/*"})
public class MyFilter implements Filter {
    private static Logger LOG= LoggerFactory.getLogger(MyFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        String requestURI=req.getRequestURI();
        req.setCharacterEncoding("utf-8");
        LOG.info("过滤到的请求-->"+requestURI);
    }

    @Override
    public void destroy() {

    }
}