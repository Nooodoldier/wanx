package com.wanx.common.advice;

import com.wanx.common.exception.WanxException;
import com.wanx.common.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author hxp
 * @create 2020-03-05-19:51
 */
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(WanxException.class)
    public ResponseEntity<ExceptionResult> handleException(WanxException e){
        return ResponseEntity.status(e.getExceptionEnum().getCode())
                .body(new ExceptionResult(e.getExceptionEnum()));
    }
}


