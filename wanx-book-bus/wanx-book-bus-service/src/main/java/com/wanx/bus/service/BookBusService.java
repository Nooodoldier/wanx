package com.wanx.bus.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wan.order.pojo.BookOrder;
import com.wanx.bus.mapper.BookBusMapper;
import com.wanx.bus.pojo.BookBus;
import com.wanx.bus.utils.OrderUtil;
import com.wanx.common.enums.ExceptionEnum;
import com.wanx.common.exception.WanxException;
import com.wanx.common.vo.PageResult;
import com.wanx.order.pojo.BookStore;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author hxp
 * @create 2020-03-08-18:51
 */
@Service
public class BookBusService {

    @Autowired
    private BookBusMapper bookBusMapper;
    @Autowired
    private BookStoreFeignService bookStoreFeignService;
    @Autowired
    private BookOrderFeignService bookOrderFeignService;
    public PageResult<BookBus> queryBusByPageAndSort(
            Integer page, Integer rows, String sortBy, Boolean desc) {
        // 开始分页
        PageHelper.startPage(page, rows);
        // 过滤
        Example example = new Example(BookBus.class);
        if (StringUtils.isNotBlank(sortBy)) {
            // 排序
            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }
        // 查询
        List<BookBus> list = bookBusMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new WanxException(ExceptionEnum.BOOK_BUS_NOT_FOND);
        }
        for(BookBus bookBus :list){
            BookStore store = bookStoreFeignService.getBookStoreById(bookBus.getBookId());
            bookBus.setBook(store);
        }
        PageInfo<BookBus> pageInfo = new PageInfo<>(list);
        // 返回结果
        return new PageResult<>(pageInfo.getTotal(), list);
    }

    public void del(String id) {
        int count = bookBusMapper.deleteByPrimaryKey(id);
        if(count != 1){
            throw new WanxException(ExceptionEnum.BOOK_BUS_DEL_ERROR);
        }
    }

    public List<BookBus> getBusList() {
        List<BookBus> list = bookBusMapper.selectAll();
        if(CollectionUtils.isEmpty(list)){
            throw new WanxException(ExceptionEnum.BOOK_BUS_NOT_FOND);
        }else{
            for(BookBus bus :list){
                BookStore store = bookStoreFeignService.getBookStoreById(bus.getBookId());
                bus.setBook(store);
            }
        }
        return list;
    }

    public void addOrder(String ids) {
        BookOrder order = null;
        for(String id : ids.split(",")) {
            BookBus bookBus = bookBusMapper.selectByPrimaryKey(id);
            order = new BookOrder();
            order.setBookBus(bookBus);
            BookStore store = bookStoreFeignService.getBookStoreById(bookBus.getBookId());
            order.setTotalPrice(bookBus.getBookCount()*store.getPrice());
            order.setBusId(bookBus.getId());
            order.setOrderNumber(OrderUtil.getOrderNoByAtomic("000"));
            System.out.print(order);
            bookOrderFeignService.addOrder(order);
        }


    }


    public int addBus(BookBus bookBus){
        return  bookBusMapper.insert(bookBus);
    }
}
