package com.xbchen.springcloud;

import com.netflix.zuul.FilterProcessor;
import com.xbchen.springcloud.filter.DidiErrorAttributes;
import com.xbchen.springcloud.filter.DidiFilterProcessor;
import com.xbchen.springcloud.filter.pre.ThrowExceptionFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * zuul做网关
 * @author xbchen
 *
 */
@SpringBootApplication
@EnableZuulProxy
public class GatewayApplication {

  public static void main(String[] args) {
    FilterProcessor.setProcessor(new DidiFilterProcessor());
    SpringApplication.run(GatewayApplication.class, args);
  }

  @Bean
  public DefaultErrorAttributes errorAttributes() {
    return new DidiErrorAttributes();
  }
 /* @Bean
  public ThrowExceptionFilter throwExceptionFilter() {
    return new ThrowExceptionFilter();
  }*/
}
