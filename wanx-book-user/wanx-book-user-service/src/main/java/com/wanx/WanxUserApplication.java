package com.wanx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author hxp
 * @create 2020-03-01-21:11
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.wanx.user.mapper")
public class WanxUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(WanxUserApplication.class,args);
    }
}
