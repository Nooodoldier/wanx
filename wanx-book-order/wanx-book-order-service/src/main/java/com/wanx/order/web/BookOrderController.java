package com.wanx.order.web;

import com.wan.order.pojo.BookOrder;
import com.wanx.common.vo.PageResult;
import com.wanx.order.service.BookOrderService;
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
@RequestMapping("order")
public class BookOrderController {

    @Autowired
    private BookOrderService bookOrderService;

    @GetMapping("page")
    public ResponseEntity<PageResult<BookOrder>> queryOrderByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "key", required = false) String key) {
        PageResult<BookOrder> result = this.bookOrderService.queryOrderByPageAndSort(page,rows,sortBy,desc, key);
        if (result == null || result.getItems().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }



    @GetMapping("getOrderList")
    public ResponseEntity<List<BookOrder>> getOrderList() {
        List<BookOrder> list = this.bookOrderService.getOrderList();
        if (list == null || list.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(list);
    }
    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping("del/{id}")
    public ResponseEntity<Void> del(@PathVariable("id") String id){
        bookOrderService.del(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("updateOrder")
    public ResponseEntity<Void> updateOrder(BookOrder bookOrder,String ids){
        bookOrderService.updateOrder(bookOrder,ids);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "addOrder")
    public void addOrder(BookOrder order){
        bookOrderService.addOrder(order);
    }
}
