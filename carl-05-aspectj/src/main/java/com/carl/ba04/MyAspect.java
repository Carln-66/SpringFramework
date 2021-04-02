package com.carl.ba04;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * @Auther: Carl
 * @Date: 2021/04/01/10:33
 * @Description: 切面类  @Aspect: 是aspectJ框架中的注解，表示当前类是切面类。用来给业务增加功能的类，在这个类中有切面的功能代码。
 * 异常通知
 * 1. public
 * 2. 没有返回值
 * 3. 方法名称自定义
 * 4. 方法有一个Exception，还可以附加JoinPoint
 */
@Aspect
public class MyAspect {
    /**
     * @AfterThrowing: 异常通知
     *      属性： 1. value    切入点表达式
     *            2. throwing   自定义的变量，表示目标方法抛出的异常对象，其变量名必须和方法的参数名相同
     * 特点：
     * 1. 在目标方法抛出异常时执行的
     * 2. 可以做异常的监控程序，监控木匾方法执行时是否有异常，如果有异常，可以发送邮件，短信进行通知
     *
     *  执行时就是：
     *      try{
     *          someServiceImpl.doSecond(..)
     *      } catch(Exception e){
     *          myAfterThrowing(e);
     *      }
     */
    @AfterThrowing(value = "execution(* *..SomeServiceImpl.doSecond(..))", throwing = "exception")
    public void myAfterThrowing(Exception exception) {
        System.out.println("异常通知：方法发生异常时执行：" + exception.getMessage());
        //发送邮件，短信通知开发人员
    }

}
