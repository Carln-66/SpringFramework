package com.carl.handler;

import com.carl.utils.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Auther: Carl
 * @Date: 2021/03/31/14:15
 * @Description:
 */
public class MyInvocationHandler implements InvocationHandler {
    //目标对象
    private Object target;  //最终会执行SomeServiceImpl类

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //通过代理对象执行方法时，会调用此invoke()
        System.out.println("执行MyInvocationHandler中的invoke()方法");
        Object res = null;

        //执行要增加的功能
        ServiceTools.doLog();

        //执行目标类的方法，通过Method类实现
        res = method.invoke(target, args);    //此方法会执行SomeServiceImpl的doSome()或doOther()

        //执行要增加的功能
        ServiceTools.doTrans();

        //目标方法的执行结果
        return res;
    }
}
