package com.wanx.common.exception;

import com.wanx.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author hxp
 * @create 2020-03-05-20:13
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class WanxException extends RuntimeException{

    private ExceptionEnum exceptionEnum;

}
