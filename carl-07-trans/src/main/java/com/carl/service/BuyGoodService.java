package com.carl.service;

/**
 * @Auther: Carl
 * @Date: 2021/04/02/13:51
 * @Description:
 */
public interface BuyGoodService {
    //购买商品的方法，goodId：购买商品的编号，nums：购买商品的数量
    void buy(Integer goodId, Integer nums);

}
