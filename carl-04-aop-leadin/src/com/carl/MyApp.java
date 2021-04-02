package com.carl;

import com.carl.handler.MyInvocationHandler;
import com.carl.service.SomeService;
import com.carl.service.impl.SomeServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Auther: Carl
 * @Date: 2021/03/31/13:12
 * @Description:
 */
public class MyApp {
    public static void main(String[] args) {
        //调用doSome和doOther
//        SomeServiceImpl someService = new SomeServiceImpl();
//        someService.doSome();
//
//        System.out.println("-----------------------------------");
//
//        someService.doOther();
//        ServiceTools.doTrans();

        //使用jdk的Proxy创建对象
        //创建目标对象
        SomeService target = new SomeServiceImpl();

        //创建InvocationHandler对象
        InvocationHandler invocationHandler = new MyInvocationHandler(target);

        //使用Proxy代理
        SomeService proxy = (SomeService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                invocationHandler);

        //通过代理执行方法，会调用handler中的invoke()
        proxy.doSome();

    }
}
