package com.wanx.item.web;

import com.wanx.common.vo.PageResult;
import com.wanx.item.pojo.BookUser;
import com.wanx.item.service.BookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author hxp
 * @create 2020-03-08-18:51
 */
@RestController
@RequestMapping("user")
public class BookUserController {

    @Autowired
    private BookUserService bookUserService;

    @GetMapping("page")
    public ResponseEntity<PageResult<BookUser>> queryBrandByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "key", required = false) String key) {
        PageResult<BookUser> result = this.bookUserService.queryUserByPageAndSort(page,rows,sortBy,desc, key);
        if (result == null || result.getItems().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 新增修改用户
     * @param bookUser
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> saveBrand(BookUser bookUser){
        bookUserService.saveBookUser(bookUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping("queryById/{id}")
    public ResponseEntity<BookUser> queryById(@PathVariable("id") String id){
        BookUser bookUser = bookUserService.getBookUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(bookUser);
    }

    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping("del/{id}")
    public ResponseEntity<Void> del(@PathVariable("id") String id){
        bookUserService.del(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    /**
     * 注册
     * @param bookUser
     * @return
     */
    @PostMapping("register")
    public ResponseEntity<Void> register(BookUser bookUser){
        System.out.print(bookUser.toString());
        bookUserService.register(bookUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 登录
     * @param bookUser
     * @return
     */
    @PostMapping("login")
    public ResponseEntity<BookUser> login(BookUser bookUser){
        System.out.print(bookUser.toString());
        BookUser user = bookUserService.login(bookUser);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
