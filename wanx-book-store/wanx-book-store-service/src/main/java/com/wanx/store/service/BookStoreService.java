package com.wanx.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanx.common.enums.ExceptionEnum;
import com.wanx.common.exception.WanxException;
import com.wanx.common.pojo.BookBus;
import com.wanx.common.pojo.BookStore;
import com.wanx.common.vo.PageResult;
import com.wanx.store.mapper.BookStoreMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author hxp
 * @create 2020-03-08-18:51
 */
@Service
public class BookStoreService {

    @Autowired
    private BookStoreMapper bookStoreMapper;
    @Autowired
    private BookBusFeignService bookBusFeignService;

    public PageResult<BookStore> queryStoreByPageAndSort(
            Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        // 开始分页
        PageHelper.startPage(page, rows);
        // 过滤
        Example example = new Example(BookStore.class);
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria().orLike("name", "%" + key + "%");
        }
        if (StringUtils.isNotBlank(sortBy)) {
            // 排序
            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }
        // 查询
        List<BookStore> list = bookStoreMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new WanxException(ExceptionEnum.BOOK_STORE_NOT_FOND);
        }
        PageInfo<BookStore> pageInfo = new PageInfo<>(list);
        // 返回结果
        return new PageResult<>(pageInfo.getTotal(), list);
    }

    public void del(String id) {
        int count = bookStoreMapper.deleteByPrimaryKey(id);
        if(count != 1){
            throw new WanxException(ExceptionEnum.BOOK_STORE_DEL_ERROR);
        }
    }

    public BookStore getBookStoreById(Long bookId) {
        BookStore bookStore = bookStoreMapper.selectByPrimaryKey(bookId);
        if(bookStore == null){
            throw new WanxException(ExceptionEnum.BOOK_STORE_NOT_FOND);
        }
        return bookStore;
    }


    public BookStore getBookStore(String id) {
        BookStore bookStore = bookStoreMapper.selectByPrimaryKey(id);
        if(bookStore == null){
            throw new WanxException(ExceptionEnum.BOOK_STORE_NOT_FOND);
        }
        return bookStore;
    }
    @Transactional
    public void saveBookStore(BookStore bookStore) {
        if(bookStore.getId() == null){
            int count = bookStoreMapper.insert(bookStore);
            if(count != 1){
                throw new WanxException(ExceptionEnum.BOOK_STORE_SAVE_ERROR);
            }
        }else{
            int count = bookStoreMapper.updateByPrimaryKeySelective(bookStore);
            if(count != 1){
                throw new WanxException(ExceptionEnum.BOOK_STORE_UPDATE_ERROR);
            }
        }

    }

    public List<BookStore> getBookList() {
        List<BookStore> list = bookStoreMapper.selectAll();
        if(CollectionUtils.isEmpty(list)){
            throw new WanxException(ExceptionEnum.BOOK_STORE_NOT_FOND);
        }
        return list;
    }

    public void addBus(String id) {
        BookStore bookStore = bookStoreMapper.selectByPrimaryKey(id);
        BookBus bookBus = new BookBus();
        bookBus.setBookCount(1);
        bookBus.setBookId(bookStore.getId());
        int count = bookBusFeignService.addBusFeign(bookBus);
        if(count != 1){
            throw new WanxException(ExceptionEnum.BOOK_BUS_ADD_ERROR);
        }
    }
}
