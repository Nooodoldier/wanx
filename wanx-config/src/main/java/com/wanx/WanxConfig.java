package com.wanx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author hxp
 * @create 2020-04-16-23:49
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigServer
public class WanxConfig {
    public static void main(String[] args) {
        SpringApplication.run(WanxConfig.class,args);
    }
}
