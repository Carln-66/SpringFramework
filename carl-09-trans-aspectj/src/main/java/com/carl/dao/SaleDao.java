package com.carl.dao;

import com.carl.domain.Sale;

/**
 * @Auther: Carl
 * @Date: 2021/04/02/13:40
 * @Description:
 */
public interface SaleDao {
    //添加销售记录
    int insertSale(Sale sale);
}
