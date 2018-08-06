package com.xbchen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 使用Eureka做服务发现.
 * @author xbchen
 *
 * java -jar springbcloud-eureka-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
 *
 * java -jar springbcloud-eureka-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
  public static void main(String[] args) {
    SpringApplication.run(EurekaApplication.class, args);
  }
}
