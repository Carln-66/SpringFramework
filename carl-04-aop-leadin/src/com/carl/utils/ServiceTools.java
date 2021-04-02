package com.carl.utils;

import java.util.Date;

/**
 * @Auther: Carl
 * @Date: 2021/03/31/13:27
 * @Description:
 */
public class ServiceTools {
    public static void doLog() {
        System.out.println("非业务方法，方法的执行时间：" + new Date());
    }

    public static void doTrans(){
        //提交事务
        System.out.println("方法执行后提交事务");
    }
}
