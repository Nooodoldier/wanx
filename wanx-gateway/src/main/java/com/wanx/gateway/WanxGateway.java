package com.wanx.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author hxp
 * @create 2020-03-01-13:58
 */
@EnableZuulProxy
@SpringBootApplication
public class WanxGateway {
    public static void main(String[] args) {
        SpringApplication.run(WanxGateway.class,args);
    }
}
