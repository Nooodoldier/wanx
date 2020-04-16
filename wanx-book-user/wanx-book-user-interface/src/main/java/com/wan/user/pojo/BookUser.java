package com.wan.user.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author hxp
 * @create 2020-03-16-22:33
 */
@Table(name = "tb_book_user")
@Data
public class BookUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;// 名称
    private String password;// 密码
}
