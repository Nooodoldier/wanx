package com.wanx.common.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author hxp
 * @create 2020-03-16-22:33
 */
@Table(name = "tb_book_order")
@Data
public class BookOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long busId;
    private Double totalPrice;
    private String receiver;
    private String area;
    private String address;
    private String tel;
    private String orderNumber;

    @Transient
    private BookBus bookBus;

}
