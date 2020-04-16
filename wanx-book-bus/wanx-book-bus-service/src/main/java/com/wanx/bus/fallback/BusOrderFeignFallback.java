package com.wanx.bus.fallback;

import com.wan.order.pojo.BookOrder;
import com.wanx.bus.service.BookOrderFeignService;

/**
 * @author hxp
 * @create 2020-04-16-23:07
 */
public class BusOrderFeignFallback implements BookOrderFeignService {

    @Override
    public void addOrder(BookOrder order) {
        System.out.print("哈哈哈哈哈哈哈");
    }
}
