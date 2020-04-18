package com.wanx.bus.fallback;

import com.wanx.bus.service.BookOrderFeignService;
import com.wanx.common.pojo.BookOrder;
import org.springframework.stereotype.Component;

/**
 * @author hxp
 * @create 2020-04-16-23:07
 */
@Component
public class BusOrderFeignFallback implements BookOrderFeignService {

    @Override
    public void addOrderFeign(BookOrder order) {

        System.out.print("" +
                "=========哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈==========\n"+
                "=========哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈==========\n"+
                "=========哈哈哈哈哈哈哈哈                      哈哈哈哈哈哈==========\n"+
                "=========哈哈哈哈哈哈哈哈                      哈哈哈哈哈哈==========\n"+
                "=========哈哈哈哈哈哈哈哈   addOrder请求熔断    哈哈哈哈哈哈==========\n"+
                "=========哈哈哈哈哈哈哈哈                      哈哈哈哈哈哈==========\n"+
                "=========哈哈哈哈哈哈哈哈                      哈哈哈哈哈哈==========\n"+
                "=========哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈==========\n"+
                "=========哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈==========\n");
    }
}
