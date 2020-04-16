package com.wanx.store.fallback;

import com.wanx.bus.pojo.BookBus;
import com.wanx.store.service.BookBusFeignService;
import org.springframework.stereotype.Component;

/**
 * @author hxp
 * @create 2020-04-16-23:36
 */
@Component
public class BookBusFeignFallBack implements BookBusFeignService {
    @Override
    public int addBus(BookBus bookBus) {
        System.out.print("哦哦哦哦");
        return 0;
    }
}
