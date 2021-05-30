package com.peng.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

// 启用Feign客户端功能
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableScheduling
public class ProjectConsumerMainClass {

  public static void main(String[] args) {
    SpringApplication.run(ProjectConsumerMainClass.class, args);
  }

}

