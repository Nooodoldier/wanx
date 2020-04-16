package com.wanx.bus.service;

import com.wanx.bus.fallback.BusStoreFeignFallback;
import com.wanx.order.pojo.BookStore;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hxp
 * @create 2020-04-16-22:38
 */
@FeignClient(value = "store-service",fallback = BusStoreFeignFallback.class)
public interface BookStoreFeignService {

    @RequestMapping(value = "getBookStoreById")
    BookStore getBookStoreById(Long bookId);
}
