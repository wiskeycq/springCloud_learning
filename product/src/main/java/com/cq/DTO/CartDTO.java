package com.cq.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: caoqsq
 * @Date: 2018/6/21 16:30
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    /*商品id*/
    private String productId;

    /*商品数量*/
    private Integer productQuantity;
}
