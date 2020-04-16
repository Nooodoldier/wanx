package com.wanx.bus.fallback;

import com.wanx.bus.service.BookStoreFeignService;
import com.wanx.order.pojo.BookStore;
import org.springframework.stereotype.Component;

/**
 * @author hxp
 * @create 2020-04-16-23:07
 */
@Component
public class BusStoreFeignFallback implements BookStoreFeignService {
    @Override
    public BookStore getBookStoreById(Long bookId) {
        System.out.print("啦啦啦啦啦啦啦啦啦");
        return new BookStore("000000","繁忙---，请稍后--访问---");
    }
}
