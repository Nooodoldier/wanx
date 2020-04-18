package com.wanx.bus.fallback;

import com.wanx.bus.service.BookStoreFeignService;
import com.wanx.common.pojo.BookStore;
import org.springframework.stereotype.Component;

/**
 * @author hxp
 * @create 2020-04-16-23:07
 */
@Component
public class BusStoreFeignFallback implements BookStoreFeignService {
    @Override
    public BookStore getBookStoreByIdFeign(Long bookId) {
        System.out.print("" +
                "========啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦======\n"+
                "========啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦======\n"+
                "========啦啦啦啦啦啦啦                                 啦啦啦啦啦啦啦======\n"+
                "========啦啦啦啦啦啦啦                                 啦啦啦啦啦啦啦======\n"+
                "========啦啦啦啦啦啦啦                                 啦啦啦啦啦啦啦======\n"+
                "========啦啦啦啦啦啦啦    getBookStoreById请求熔断      啦啦啦啦啦啦啦======\n"+
                "========啦啦啦啦啦啦啦                                 啦啦啦啦啦啦啦======\n"+
                "========啦啦啦啦啦啦啦                                 啦啦啦啦啦啦啦======\n"+
                "========啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦======\n"+
                "========啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦======\n");
        return new BookStore("000000","繁忙---，请稍后--访问---");
    }
}
