package com.cq.service.impl;

import com.cq.enums.ProductStatusEnum;
import com.cq.model.ProductInfo;
import com.cq.repository.ProductInfoRepository;
import com.cq.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/20 16:24
 * @Description: 商品
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
