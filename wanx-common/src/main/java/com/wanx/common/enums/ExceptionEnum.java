package com.wanx.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author hxp
 * @create 2020-03-05-20:07
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {

    BOOK_USER_NOT_FOND(404,"用户不存在"),
    BOOK_USER_SAVE_ERROR(500,"新增用户失败"),
    BOOK_USER_UPDATE_ERROR(500,"更新用户失败"),
    BOOK_USER_DEL_ERROR(500,"删除用户失败"),
    BOOK_BUS_NOT_FOND(404,"购物车不存在"),
    BOOK_BUS_ADD_ERROR(500,"购物车新增失败"),
    BOOK_BUS_DEL_ERROR(500,"删除购物车失败"),
    BOOK_ORDER_NOT_FOND(404,"订单不存在"),
    BOOK_ORDER_DEL_ERROR(500,"删除订单失败"),
    BOOK_ORDER_SAVE_ERROR(500,"新增订单失败"),
    BOOK_ORDER_UPDATE_ERROR(500,"修改订单失败"),
    BOOK_STORE_NOT_FOND(404,"书籍不存在"),
    BOOK_STORE_DEL_ERROR(500,"删除书籍失败"),
    BOOK_STORE_SAVE_ERROR(500,"新增用户失败"),
    BOOK_STORE_UPDATE_ERROR(500,"更新用户失败"),

    ;
    private int code;
    private String msg;
}
