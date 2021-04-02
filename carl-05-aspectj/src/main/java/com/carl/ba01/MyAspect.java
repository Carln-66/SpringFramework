package com.carl.ba01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @Auther: Carl
 * @Date: 2021/04/01/10:33
 * @Description: 切面类  @Aspect: 是aspectJ框架中的注解，表示当前类是切面类。用来给业务增加功能的类，在这个类中有切面的功能代码。
 * 使用位置：在类的定义上面
 */
@Aspect
public class MyAspect {
    /**
     * 定义方法：方法是实现切面功能的。
     * 方法的定义要求：
     * 1. 公共方法 public
     * 2. 方法没有返回值
     * 3. 方法名称自定义
     * 4. 方法可以有参数也可以没有
     *      如果有参数，参数不是自定义的，有几个参数类型可以使用
     */
    //@Before:前置通知注解；属性：value，是切入点表达式，表示切面的功能执行的位置
    //位置：方法的上面
    //特点：1. 在目标方法之前先执行  2. 不会改变目标方法的执行结果    3. 不会影响目标方法的执行
//    @Before(value = "execution(public void com.carl.ba01.Impl.SomeServiceImpl.doSome(String, Integer))")
//    public void myBefore(){
//        //切面要执行的功能代码
//        System.out.println("前置通知，切面功能：在目标方法之前输出执行时间");
//    }

//    @Before(value = "execution(void com.carl.ba01.Impl.SomeServiceImpl.doSome(String, Integer))")
//    public void myBefore(){
//        //切面要执行的功能代码
//        System.out.println("1------------前置通知，切面功能：在目标方法之前输出执行时间");
//    }

//    @Before(value = "execution(void *..SomeServiceImpl.doSome(String, Integer))")
//    public void myBefore(){
//        //切面要执行的功能代码
//        System.out.println("2------------前置通知，切面功能：在目标方法之前输出执行时间");
//    }

//        @Before(value = "execution(* *..SomeServiceImpl.do*(..))")
//        public void myBefore() {
//            //切面要执行的功能代码
//            System.out.println("3------------前置通知，切面功能：在目标方法之前输出执行时间");
//        }

    /**
     * 指定方法中的参数JoinPoint
     * JoinPoint：业务方法，要加入切面功能的业务方法
     *      作用：可以在通知方法中获取方法执行时的信息，例如方法名称，方法的实参
     *      如果切面功能中需要用到方法的信息就加入JoinPoint
     *      JoinPoint参数的值由框架赋予，必须是第一个位置的参数
     */
    @Before(value = "execution(* *..SomeServiceImpl.do*(..))")
    public void myBefore(JoinPoint joinPoint) {
        //获取方法的完整定义
        System.out.println("方法的签名：" + joinPoint.getSignature());
        System.out.println("方法的名称：" + joinPoint.getClass());

        //获取方法的实参
        Object[] args = joinPoint.getArgs();
        for (Object obj : args) {
            System.out.println("参数：" + obj);
        }
        //切面要执行的功能代码
        System.out.println("3------------前置通知，切面功能：在目标方法之前输出执行时间");
    }
}
