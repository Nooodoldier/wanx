package com.wanx.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanx.common.enums.ExceptionEnum;
import com.wanx.common.exception.WanxException;
import com.wanx.common.vo.PageResult;
import com.wanx.item.mapper.BookBusMapper;
import com.wanx.item.mapper.BookUserMapper;
import com.wanx.item.pojo.BookBus;
import com.wanx.item.pojo.BookOrder;
import com.wanx.item.pojo.BookStore;
import com.wanx.item.pojo.BookUser;
import com.wanx.item.utils.OrderUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
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
    private BookStoreService bookStoreService;
    @Autowired
    private BookOrderService bookOrderService;
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
            BookStore store = bookStoreService.getBookStoreById(bookBus.getBookId());
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
                BookStore store = bookStoreService.getBookStoreById(bus.getBookId());
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
            BookStore store = bookStoreService.getBookStoreById(bookBus.getBookId());
            order.setTotalPrice(bookBus.getBookCount()*store.getPrice());
            order.setBusId(bookBus.getId());
            order.setOrderNumber(OrderUtil.getOrderNoByAtomic("000"));
            System.out.print(order);
            bookOrderService.addOrder(order);
        }


    }
}
