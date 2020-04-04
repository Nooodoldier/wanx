package com.wanx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author hxp
 * @create 2020-03-01-13:46
 */
@EnableEurekaServer
@SpringBootApplication
public class WanxRegistry {

    public static void main(String[] args) {
        SpringApplication.run(WanxRegistry.class,args);
    }
}
