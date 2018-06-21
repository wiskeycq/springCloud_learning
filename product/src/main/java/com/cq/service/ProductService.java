package com.cq.service;

import com.cq.DTO.CartDTO;
import com.cq.model.ProductInfo;

import java.util.List;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/20 16:24
 * @Description:
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
