package com.wanx.item.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author hxp
 * @create 2020-03-16-22:33
 */
@Table(name = "tb_book_bus")
@Data
public class BookBus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long bookId;
    private Integer bookCount;

    @Transient
    private BookStore book;
}
