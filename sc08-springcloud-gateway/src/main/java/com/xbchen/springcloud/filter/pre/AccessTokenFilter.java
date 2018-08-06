package com.xbchen.springcloud.filter.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * token认证校验---暂不需要
 */
@Component
public class AccessTokenFilter extends ZuulFilter  {

    private static Logger log = LoggerFactory.getLogger(AccessTokenFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        log.info("start AccessTokenFilter");
        RequestContext ctx = RequestContext.getCurrentContext();
        try {
            HttpServletRequest request = ctx.getRequest();
            log.info("send {} request to{}", request.getMethod(), request.getRequestURL().toString());
            HttpSession httpSession = ctx.getRequest().getSession();
            InputStream in = ctx.getRequest().getInputStream();
            String body = StreamUtils.copyToString(in, Charset.forName("UTF-8"));
            log.info("send request body:" + body);

            /*Object accessToken = request.getParameter("accessToken");
            if (accessToken == null) {
                log.warn("accessToken is empty");
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(401);
                try {
                    ctx.getResponse().getWriter().write("accessToken is empty");
                } catch (Exception e) {
                }
                return null;
            }
            log.info("access is ok");*/
            return null;

        } catch (Exception e) {
            ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            ctx.set("error.exception", e);
        }
        return null;
    }

}
