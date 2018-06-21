package com.cq.enums;

import lombok.Getter;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/21 11:34
 * @Description:
 */
@Getter
public enum  ResultEnum {
    PARAM_ERROR(1, "参数错误"),
    CART_EMPTY(2, "购物车为空")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
