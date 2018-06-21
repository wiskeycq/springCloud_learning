package com.cq.enums;

import lombok.Getter;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/21 10:28
 * @Description:
 */
@Getter
public enum  PayStatusEnum {

    WAIT(0, "待支付"),
    SUCCESS(1, "支付成功"),
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
