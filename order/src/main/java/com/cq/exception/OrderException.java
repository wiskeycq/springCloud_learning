package com.cq.exception;

import com.cq.enums.ResultEnum;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/21 11:33
 * @Description:
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
