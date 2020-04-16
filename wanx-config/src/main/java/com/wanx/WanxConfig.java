package com.wanx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hxp
 * @create 2020-04-16-23:49
 */
@SpringBootApplication
@EnableEurekaClient
public class WanxConfig {
    public static void main(String[] args) {
        SpringApplication.run(WanxConfig.class,args);
    }
}
