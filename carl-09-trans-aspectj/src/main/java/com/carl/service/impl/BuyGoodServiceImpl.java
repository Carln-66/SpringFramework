package com.carl.service.impl;

import com.carl.dao.GoodsDao;
import com.carl.dao.SaleDao;
import com.carl.domain.Goods;
import com.carl.domain.Sale;
import com.carl.exception.NotEnoughException;
import com.carl.service.BuyGoodService;

/**
 * @Auther: Carl
 * @Date: 2021/04/02/13:52
 * @Description:
 */
public class BuyGoodServiceImpl implements BuyGoodService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;

    @Override
    public void buy(Integer goodId, Integer nums) {
        System.out.println("=============buy方法开始=============");
        //记录销售信息
        Sale sale = new Sale();
        sale.setGid(goodId);
        sale.setNums(nums);
        saleDao.insertSale(sale);
        //更新库存
        Goods goods = goodsDao.selectGoods(goodId);
        if (goods == null) {
            //商品不存在
            throw new NullPointerException("'" + goodId + "'商品不存在");
        } else if (goods.getAmount() < nums) {
            //商品库存不足
            throw new NotEnoughException("'" + goodId + "'商品库存不足");
        }
        //修改库存
        Goods buyGoods = new Goods();
        buyGoods.setId(goodId);
        buyGoods.setAmount(nums);
        goodsDao.updateGoods(buyGoods);
        System.out.println("=============buy方法结束=============");

    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }
}
