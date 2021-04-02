package com.carl.service.impl;

import com.carl.service.SomeServices;

/**
 * @Auther: Carl
 * @Date: 2021/03/30/14:14
 * @Description:
 */
public class SomeServicesImpl implements SomeServices {
    @Override
    public void doSome() {
        System.out.println("执行了SomeServices的doSome方法");
    }
}
