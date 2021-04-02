package com.carl.ba06;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Auther: Carl
 * @Date: 2021/04/01/10:33
 * @Description: 切面类  @Aspect: 是aspectJ框架中的注解，表示当前类是切面类。用来给业务增加功能的类，在这个类中有切面的功能代码。

 */
@Aspect
public class MyAspect {

    @After(value = "execution(* *..SomeServiceImpl.doThird(..))")
    public void myAfter(){
        System.out.println("执行最终通知，总是会被执行的代码");
        //通常用于资源清除
    }

    @Before(value = "mypt()")
    public void myBefore(){
        System.out.println("执行前置通知，在目标方法之前执行");
        //通常用于资源清除
    }

    /**
     * @PointCut: 定义和管理切入点，如果项目中有多个切入点表达式是重复的，可以复用的，可以使用@PointCut
     * 属性：value 切入点表达式
     * 位置：自定义的方法上面
     * 特点：使用@PointCut定义在一个方法的上面，此时这个方法的名称就是切入点表达式的别名
     * 其他的通知中value属性就可以使用这个方法名称，代替切入点表达式
     */
    @Pointcut(value = "execution(* *..SomeServiceImpl.doThird(..))")
    public void mypt(){
        //无需代码
    }
}
