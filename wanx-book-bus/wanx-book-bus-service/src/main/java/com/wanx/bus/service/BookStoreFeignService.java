package com.wanx.bus.service;

import com.wanx.bus.fallback.BusStoreFeignFallback;
import com.wanx.common.pojo.BookStore;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hxp
 * @create 2020-04-16-22:38
 */
@FeignClient(value = "store-service",fallback = BusStoreFeignFallback.class)
public interface BookStoreFeignService {

    @GetMapping(value = "store/getBookStoreByIdFeign")
    BookStore getBookStoreByIdFeign(@RequestParam(value = "bookId") Long bookId);
}
