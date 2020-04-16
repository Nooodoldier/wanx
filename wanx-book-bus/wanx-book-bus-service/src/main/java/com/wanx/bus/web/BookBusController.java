package com.wanx.bus.web;

import com.wanx.bus.pojo.BookBus;
import com.wanx.bus.service.BookBusService;
import com.wanx.common.vo.PageResult;
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
@RequestMapping("bus")
public class BookBusController {

    @Autowired
    private BookBusService bookBusService;

    @GetMapping("page")
    public ResponseEntity<PageResult<BookBus>> queryBusByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc) {
        PageResult<BookBus> result = this.bookBusService.queryBusByPageAndSort(page,rows,sortBy,desc);
        if (result == null || result.getItems().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping("del/{id}")
    public ResponseEntity<Void> del(@PathVariable("id") String id){
        bookBusService.del(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("getBusList")
    public ResponseEntity<List<BookBus>> getBusList() {
        List<BookBus> list = this.bookBusService.getBusList();
        if (list == null || list.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(list);
    }

    /**
     * 添加订单
     * @param ids
     * @return
     */
    @GetMapping("addOrder/{ids}")
    public ResponseEntity<Void> addOrder(@PathVariable("ids") String ids){
        System.out.print(ids);
        bookBusService.addOrder(ids);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping(value="addBus")
    public int addBus(BookBus bookBus){
        return bookBusService.addBus(bookBus);
    }
}
