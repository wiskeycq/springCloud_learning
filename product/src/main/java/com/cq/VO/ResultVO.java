package com.cq.VO;

import lombok.Data;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/20 16:56
 * @Description:
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码 0成功 1失败
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
