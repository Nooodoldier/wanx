package com.wanx.bus.service;

import com.wanx.bus.fallback.BusOrderFeignFallback;
import com.wanx.common.pojo.BookOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author hxp
 * @create 2020-04-16-22:38
 */
@FeignClient(value = "order-service",fallback = BusOrderFeignFallback.class)
public interface BookOrderFeignService {

    @PostMapping(value = "/order/addOrderFeign")
    void addOrderFeign(@RequestBody BookOrder order);
}
