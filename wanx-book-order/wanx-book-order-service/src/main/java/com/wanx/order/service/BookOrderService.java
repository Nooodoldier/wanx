package com.wanx.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wan.order.pojo.BookOrder;
import com.wanx.common.enums.ExceptionEnum;
import com.wanx.common.exception.WanxException;
import com.wanx.common.vo.PageResult;
import com.wanx.order.mapper.BookOrderMapper;
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
public class BookOrderService {

    @Autowired
    private BookOrderMapper bookOrderMapper;

    public PageResult<BookOrder> queryOrderByPageAndSort(
            Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        // 开始分页
        PageHelper.startPage(page, rows);
        // 过滤
        Example example = new Example(BookOrder.class);
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria().orLike("receiver", "%" + key + "%");
        }
        if (StringUtils.isNotBlank(sortBy)) {
            // 排序
            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }
        // 查询
        List<BookOrder> list = bookOrderMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new WanxException(ExceptionEnum.BOOK_ORDER_NOT_FOND);
        }
        PageInfo<BookOrder> pageInfo = new PageInfo<>(list);
        // 返回结果
        return new PageResult<>(pageInfo.getTotal(), list);
    }


    public void del(String id) {
        int count = bookOrderMapper.deleteByPrimaryKey(id);
        if(count != 1){
            throw new WanxException(ExceptionEnum.BOOK_ORDER_DEL_ERROR);
        }
    }

    public void addOrder(BookOrder order) {
        int count = bookOrderMapper.insert(order);
        if(count != 1){
            throw new WanxException(ExceptionEnum.BOOK_ORDER_SAVE_ERROR);
        }
    }

    public List<BookOrder> getOrderList() {
        List<BookOrder> list = bookOrderMapper.selectAll();
        if(CollectionUtils.isEmpty(list)){
            throw new WanxException(ExceptionEnum.BOOK_ORDER_NOT_FOND);
        }
        return list;
    }


    public void updateOrder(BookOrder bookOrder, String ids) {

        for(String id :ids.split(",")){
            BookOrder order = bookOrderMapper.selectByPrimaryKey(id);
            if(order == null){
                throw new WanxException(ExceptionEnum.BOOK_ORDER_NOT_FOND);
            }
            order.setAddress(bookOrder.getAddress());
            order.setArea(bookOrder.getArea());
            order.setReceiver(bookOrder.getReceiver());
            order.setTel(bookOrder.getTel());
            int count = bookOrderMapper.updateByPrimaryKeySelective(order);
            if(count != 1){
                throw new WanxException(ExceptionEnum.BOOK_ORDER_UPDATE_ERROR);
            }

        }
    }
}
