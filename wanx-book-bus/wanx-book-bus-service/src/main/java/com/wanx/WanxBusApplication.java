package com.wanx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author hxp
 * @create 2020-03-01-21:11
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.wanx.bus.mapper")
public class WanxBusApplication {
    public static void main(String[] args) {
        SpringApplication.run(WanxBusApplication.class,args);
    }
}
