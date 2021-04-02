package com.carl.ba03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;

/**
 * @Auther: Carl
 * @Date: 2021/04/01/10:33
 * @Description: 切面类  @Aspect: 是aspectJ框架中的注解，表示当前类是切面类。用来给业务增加功能的类，在这个类中有切面的功能代码。
 * 使用位置：在类的定义上面
 * <p>
 * *
 * 环绕通知方法的定义格式
 * 1. public
 * 2. 必须有一个返回值，推荐使用Object
 * 3. 方法名称自定义
 * 4. 方法有参数，固定的参数ProceedingJoinPoint
 */
@Aspect
public class MyAspect {
    /**
     * @Around: 环绕通知
     * 经常用于事务，在目标方法之前开启事务，执行目标方法，在目标方法之后提交事务
     * 属性：value 切入点表达式
     * 位置：在方法的定义上面
     * 特点：
     * 1. 功能最强的通知
     * 2. 它可以在目标方法的前后都能增强功能
     * 3. 控制目标方法是否被调用执行
     * 4. 修改原来的目标方法的执行结果，影响最后的调用结果
     *
     * 环绕通知等同于JDK的动态代理，InvocationHandler接口
     * 参数：ProceedingJoinPoint  等同于动态代理invoke方法中的Method，作用是执行目标方法
     * 返回值：就是目标方法的执行结果，可以被修改
     */
    @Around(value = "execution(* *..SomeServiceImpl.doFirst(..))")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String name = "";
        //获取第一个参数值
        Object[] args = proceedingJoinPoint.getArgs();
        if (args != null && args.length > 1) {
            Object arg = args[0];
            name = (String) arg;
        }

        //实现环绕通知的功能
        Object result = null;

        //目标方法前加入功能
        System.out.println("环绕通知：在目标方法之前输出时间" + new Date());

        //目标方法调用
        if ("张三".equals(name)) {
            //符合条件，调用目标方法
            result = proceedingJoinPoint.proceed();  //==method.invoke();   ==Object result = doFirst();
        }

        //目标方法后加入功能
        System.out.println("环绕通知：在目标方法后提交事务 commit");

        //修改目标方法的执行结果，影响方法最后的调用结果
        if (result != null) {
            result = "你好你好你好";
        }

        //返回目标方法的执行结果
        return result;
    }
}
