package com.wanx.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanx.common.enums.ExceptionEnum;
import com.wanx.common.exception.WanxException;
import com.wanx.common.pojo.BookUser;
import com.wanx.common.vo.PageResult;
import com.wanx.user.mapper.BookUserMapper;
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
public class BookUserService {

    @Autowired
    private BookUserMapper bookUserMapper;

    public PageResult<BookUser> queryUserByPageAndSort(
            Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        // 开始分页
        PageHelper.startPage(page, rows);
        // 过滤
        Example example = new Example(BookUser.class);
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria().orLike("name", "%" + key + "%")
                    .orEqualTo("password", key);
        }
        if (StringUtils.isNotBlank(sortBy)) {
            // 排序
            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }
        // 查询
        List<BookUser> list = bookUserMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            throw new WanxException(ExceptionEnum.BOOK_USER_NOT_FOND);
        }
        PageInfo<BookUser> pageInfo = new PageInfo<>(list);
        // 返回结果
        return new PageResult<>(pageInfo.getTotal(), list);
    }

    @Transactional
    public void saveBookUser(BookUser bookUser) {
        if(bookUser.getId() == null){
            int count = bookUserMapper.insert(bookUser);
            if(count != 1){
                throw new WanxException(ExceptionEnum.BOOK_USER_SAVE_ERROR);
            }
        }else{
            int count = bookUserMapper.updateByPrimaryKeySelective(bookUser);
            if(count != 1){
                throw new WanxException(ExceptionEnum.BOOK_USER_UPDATE_ERROR);
            }
        }

    }

    public BookUser getBookUser(String id) {
        BookUser bookUser = bookUserMapper.selectByPrimaryKey(id);
        if(bookUser == null){
            throw new WanxException(ExceptionEnum.BOOK_USER_NOT_FOND);
        }
        return bookUser;
    }

    public void del(String id) {
        int count = bookUserMapper.deleteByPrimaryKey(id);
        if(count != 1){
            throw new WanxException(ExceptionEnum.BOOK_USER_DEL_ERROR);
        }
    }

    public void register(BookUser bookUser) {
        if(bookUser.getId() == null){
            int count = bookUserMapper.insert(bookUser);
            if(count != 1){
                throw new WanxException(ExceptionEnum.BOOK_USER_SAVE_ERROR);
            }
        }
    }

    public BookUser login(BookUser bookUser) {
        List<BookUser> users = bookUserMapper.select(bookUser);
        if(CollectionUtils.isEmpty(users)){
            throw new WanxException(ExceptionEnum.BOOK_USER_NOT_FOND);
        }
        return users.get(0);
    }
}
