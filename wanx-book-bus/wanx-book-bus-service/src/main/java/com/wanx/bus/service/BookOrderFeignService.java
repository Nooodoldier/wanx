package com.wanx.bus.service;

import com.wan.order.pojo.BookOrder;
import com.wanx.bus.fallback.BusOrderFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hxp
 * @create 2020-04-16-22:38
 */
@FeignClient(value = "order-service",fallback = BusOrderFeignFallback.class)
public interface BookOrderFeignService {

    @RequestMapping(value = "addOrder")
    void addOrder(BookOrder order);
}
