package com.cq.client;

import com.cq.DTO.CartDTO;
import com.cq.model.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/21 15:26
 * @Description:
 */
@FeignClient(name="product")
public interface ProductClient {

    //访问product服务下的msg接口
    @GetMapping("/msg")
    String getProductMsg();

    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);

}
