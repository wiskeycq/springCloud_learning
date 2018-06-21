package com.cq.exception;

import com.cq.enums.ResultEnum;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/21 16:41
 * @Description:
 */
public class ProductException extends RuntimeException {
    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
