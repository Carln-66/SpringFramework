package com.carl.ba05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * @Auther: Carl
 * @Date: 2021/04/01/10:33
 * @Description: 切面类  @Aspect: 是aspectJ框架中的注解，表示当前类是切面类。用来给业务增加功能的类，在这个类中有切面的功能代码。
 *  *
 *  * 最终通知方法定义格式
 *  * 1. public
 *  * 2. 没有返回值
 *  * 3. 方法名称自定义
 *  * 4. 方法没有参数，如果有是JoinPoint
 *
 */
@Aspect
public class MyAspect {
    /**
     * @After: 最终通知
     *  属性：value    切入点表达式
     *  位置：在方法的上面
     * 特点：1. 总是会执行
     *      2. 在目标方法之后执行
     * 相当于finally
     */
    @After(value = "execution(* *..SomeServiceImpl.doThird(..))")
    public void myAfter(){
        System.out.println("执行最终通知，总是会被执行的代码");
        //通常用于资源清除
    }
}
