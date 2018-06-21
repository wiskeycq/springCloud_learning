package com.cq.repository;

import com.cq.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/21 10:21
 * @Description:
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String>{
}
