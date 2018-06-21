package com.cq.converter;

import com.cq.DTO.OrderDTO;
import com.cq.enums.ResultEnum;
import com.cq.exception.OrderException;
import com.cq.model.OrderDetail;
import com.cq.param.OrderParam;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/21 11:40
 * @Description:
 */
@Slf4j
public class OrderParam2OrderDTOConverter {
    public static OrderDTO convert(OrderParam orderParam) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderParam.getName());
        orderDTO.setBuyerPhone(orderParam.getPhone());
        orderDTO.setBuyerAddress(orderParam.getAddress());
        orderDTO.setBuyerOpenid(orderParam.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderParam.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("【json转换】错误, string={}", orderParam.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
