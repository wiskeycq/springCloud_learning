package com.cq.controller;

import com.cq.DTO.CartDTO;
import com.cq.VO.ProductInfoVO;
import com.cq.VO.ProductVO;
import com.cq.VO.ResultVO;
import com.cq.model.ProductCategory;
import com.cq.model.ProductInfo;
import com.cq.service.CategoryService;
import com.cq.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/20 16:24
 * @Description:
 */
@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 1. 查询所有在架的商品
     * 2. 获取类目type列表
     * 3. 查询类目
     * 4. 构造数据
     */
    @GetMapping("/list")
    public ResultVO<ProductInfo> List() {
        //1. 查询所有在架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. 获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream().map(productInfo -> productInfo.getCategoryType()).collect(Collectors.toList());

        //3. 从数据库查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //4. 构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVO.success(productVOList);
    }

    /**
     * 获取商品列表（给订单服务使用）
     * 注意：如果使用RequestBody这个注解，则必须使用post请求的方式
     */
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList) {
        return productService.findList(productIdList);
    }

    /**
     * 减库存（给订单服务使用）
     */
    @PostMapping("/decreaseStock")
    public void decreaseStock(List<CartDTO> cartDTOList) {
        productService.decreaseStock(cartDTOList);
    }

}
