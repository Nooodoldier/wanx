package com.wanx.store.service;

import com.wanx.bus.pojo.BookBus;
import com.wanx.order.pojo.BookStore;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hxp
 * @create 2020-04-14-23:34
 */
@FeignClient(value = "bus-service")
public interface BookBusFeignService {

    @RequestMapping(value="addBus")
    int addBus(BookBus bookBus);
}
