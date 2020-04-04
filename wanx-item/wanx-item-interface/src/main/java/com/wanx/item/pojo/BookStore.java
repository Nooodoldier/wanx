package com.wanx.item.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author hxp
 * @create 2020-03-16-22:33
 */
@Table(name = "tb_book_store")
@Data
public class BookStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;// 名称
    @Column(name = "`describe`")
    private String describe;// 描述
    private String img;// 图片
    private Double price;// 价格
}