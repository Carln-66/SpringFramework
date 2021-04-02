package com.carl.service.impl;

import com.carl.dao.GoodsDao;
import com.carl.dao.SaleDao;
import com.carl.domain.Goods;
import com.carl.domain.Sale;
import com.carl.exception.NotEnoughException;
import com.carl.service.BuyGoodService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: Carl
 * @Date: 2021/04/02/13:52
 * @Description:
 */
public class BuyGoodServiceImpl implements BuyGoodService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;

    /**
     * rollbackFor：表示发生指定的异常一定回滚
     * 处理逻辑：
     * 1. spring框架会首先检查方法抛出的异常不是在rollbackFor的属性值中，如果异常在rollbackFor列表中，不管是什么类型的异常，一定回滚
     * 2. 如果你抛出的一场不在rollbackFor列表中，spring会判断是否是RunTimeException，如果是，一定回滚
     */
//    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false, rollbackFor = {
//            NullPointerException.class, NotEnoughException.class
//    })

    /**
     * 使用的是事务控制的默认值，默认传播行为是REQUIRED
     * 默认的隔离级别是：DEFAULT
     * 默认抛出运行时异常，回滚事务
     */
    @Transactional
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
