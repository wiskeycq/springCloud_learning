package com.cq.controller;

import com.cq.DTO.OrderDTO;
import com.cq.VO.ResultVO;
import com.cq.converter.OrderParam2OrderDTOConverter;
import com.cq.enums.ResultEnum;
import com.cq.exception.OrderException;
import com.cq.param.OrderParam;
import com.cq.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/21 10:34
 * @Description:
 */
@RequestMapping("/order")
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 1. 参数检验
     * 2. 查询商品信息(调用商品服务)
     * 3. 计算总价
     * 4. 扣库存(调用商品服务)
     * 5. 订单入库
     */
    public ResultVO create(@Valid OrderParam orderParam, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确, OrderParam={}", orderParam);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderParam2OrderDTOConverter.convert(orderParam);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVO.success(map);
    }
}
