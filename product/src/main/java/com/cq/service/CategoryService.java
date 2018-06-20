package com.cq.service;

import com.cq.model.ProductCategory;

import java.util.List;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/20 16:23
 * @Description:
 */
public interface CategoryService {

    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
