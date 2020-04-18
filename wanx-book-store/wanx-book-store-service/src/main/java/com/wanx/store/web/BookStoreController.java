package com.wanx.store.web;

import com.wanx.common.pojo.BookStore;
import com.wanx.common.vo.PageResult;
import com.wanx.store.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hxp
 * @create 2020-03-08-18:51
 */
@RestController
@RequestMapping("store")
public class BookStoreController {

    @Autowired
    private BookStoreService bookStoreService;

    @GetMapping("page")
    public ResponseEntity<PageResult<BookStore>> queryStoreByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "key", required = false) String key) {
        PageResult<BookStore> result = this.bookStoreService.queryStoreByPageAndSort(page,rows,sortBy,desc, key);
        if (result == null || result.getItems().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("getBookList")
    public ResponseEntity<List<BookStore>> getBookList() {
        List<BookStore> list = this.bookStoreService.getBookList();
        if (list == null || list.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(list);
    }

    /**
     * 新增修改图书
     * @param bookStore
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> saveBook(BookStore bookStore){
        bookStoreService.saveBookStore(bookStore);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping("queryById/{id}")
    public ResponseEntity<BookStore> queryById(@PathVariable("id") String id){
        BookStore bookStore = bookStoreService.getBookStore(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookStore);
    }
    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping("del/{id}")
    public ResponseEntity<Void> del(@PathVariable("id") String id){
        bookStoreService.del(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * 添加购物车
     * @param id
     * @return
     */
    @GetMapping("addBus/{id}")
    public ResponseEntity<Void> addBus(@PathVariable("id") String id){
        bookStoreService.addBus(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping(value = "getBookStoreByIdFeign")
    public BookStore getBookStoreByIdFeign(Long bookId){
        return bookStoreService.getBookStoreById(bookId);
    }

}
