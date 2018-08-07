package com.xbchen.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by xbchen on 2018/06/25.
 * session共享
 *
 * 1.设置端口号为8085 运行启动 访问http://localhost:8085/user/session1?userId=123456 设置session
 * 返回：{"request Url":"http://localhost:8085/user/session1","userId":"123456"}
 *
 * http://localhost:8085/user/session2 查看sessionID
 * 返回：{"sessionId":"68d66696-ed89-46b0-b8db-a5469f4db3c9","userId":"123456"}
 *
 * 2.修改端口号为8085 运行启动 访问http://localhost:8086/user/session2 查看sessionID是否与8085端口设置的相同
 *返回：{"sessionId":"68d66696-ed89-46b0-b8db-a5469f4db3c9","userId":"123456"}
 *
 * ---2个分布式服务得到的sessionID和用户ID都没有变化
 */


@EnableTransactionManagement//启动事务
@SpringBootApplication
@MapperScan("com.xbchen.springcloud.dao")
@EnableSwagger2
@EnableDiscoveryClient
@EnableFeignClients
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
