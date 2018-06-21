package com.cq.service.impl;

import com.cq.DTO.OrderDTO;
import com.cq.repository.OrderDetailRepository;
import com.cq.repository.OrderMasterRepository;
import com.cq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/21 10:41
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        return null;
    }
}
