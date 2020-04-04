package com.wanx.common.vo;

import com.wanx.common.enums.ExceptionEnum;
import lombok.Data;

/**
 * @author hxp
 * @create 2020-03-06-1:27
 */
@Data
public class ExceptionResult {
    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnum em){
        this.status = em.getCode();
        this.message = em.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}
