package com.wanx.store.service;

import com.wanx.common.pojo.BookBus;
import com.wanx.store.fallback.BookBusFeignFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author hxp
 * @create 2020-04-14-23:34
 */
@FeignClient(value = "bus-service",fallback = BookBusFeignFallBack.class)
public interface BookBusFeignService {

    @PostMapping(value="/bus/addBusFeign")
    int addBusFeign(@RequestBody BookBus bookBus);
}
