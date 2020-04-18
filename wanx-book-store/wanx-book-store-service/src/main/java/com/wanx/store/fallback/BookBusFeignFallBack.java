package com.wanx.store.fallback;

import com.wanx.common.pojo.BookBus;
import com.wanx.store.service.BookBusFeignService;
import org.springframework.stereotype.Component;

/**
 * @author hxp
 * @create 2020-04-16-23:36
 */
@Component
public class BookBusFeignFallBack implements BookBusFeignService {
    @Override
    public int addBusFeign(BookBus bookBus) {
        System.out.print("" +
                "========哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦===\n" +
                "========哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦===\n" +
                "========哦哦哦哦哦哦哦哦哦哦哦                        哦哦哦哦哦哦哦哦哦哦===\n" +
                "========哦哦哦哦哦哦哦哦哦哦哦                        哦哦哦哦哦哦哦哦哦哦===\n" +
                "========哦哦哦哦哦哦哦哦哦哦哦       addBus请求熔断    哦哦哦哦哦哦哦哦哦哦===\n" +
                "========哦哦哦哦哦哦哦哦哦哦哦                        哦哦哦哦哦哦哦哦哦哦===\n" +
                "========哦哦哦哦哦哦哦哦哦哦哦                        哦哦哦哦哦哦哦哦哦哦===\n" +
                "========哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦===\n" +
                "========哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦===\n");
        return 0;
    }
}
