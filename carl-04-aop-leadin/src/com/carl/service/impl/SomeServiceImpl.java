package com.carl.service.impl;

import com.carl.service.SomeService;

/**
 * @Auther: Carl
 * @Date: 2021/03/31/13:11
 * @Description:
 */

//service类的代码不修改也能够增加输出时间，事务
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("执行业务方法doSome");
    }

    @Override
    public void doOther() {
        System.out.println("执行业务方法doOther");
    }
}
