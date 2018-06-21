package com.cq.repository;

import com.cq.OrderApplicationTests;
import com.cq.enums.OrderStatusEnum;
import com.cq.enums.PayStatusEnum;
import com.cq.model.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/21 10:23
 * @Description: 继承OrderApplicationTests这个类就不需要再写@RunWith(SpringRunner.class) @SpringBootTest这两个注解
 */
@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests{

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() {

        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("1886131241241");
        orderMaster.setBuyerAddress("慕课网总部");
        orderMaster.setBuyerOpenid("1101110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result != null);
    }

}