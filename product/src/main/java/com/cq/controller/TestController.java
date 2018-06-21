package com.cq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/21 13:26
 * @Description:
 */
@RestController
public class TestController {

    @GetMapping("/msg")
    public String getProudctMsg() {
        return "I am product msg";
    }
}
