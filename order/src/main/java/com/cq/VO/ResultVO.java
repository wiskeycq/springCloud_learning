package com.cq.VO;

import lombok.Data;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/21 11:52
 * @Description:
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
