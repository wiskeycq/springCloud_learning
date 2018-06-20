package com.cq.enums;

import lombok.Getter;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/20 16:30
 * @Description:
 */
@Getter
public enum  ProductStatusEnum {

    UP(0,"上架"),
    DOWN(1,"下架"),
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
