package com.cq.utils;

import java.util.Random;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/21 10:49
 * @Description:
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     * 并不能保证生成的主键唯一
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
