package com.carl.ba02;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * @Auther: Carl
 * @Date: 2021/04/01/10:33
 * @Description: 切面类  @Aspect: 是aspectJ框架中的注解，表示当前类是切面类。用来给业务增加功能的类，在这个类中有切面的功能代码。
 * 使用位置：在类的定义上面
 */
@Aspect
public class MyAspect {
    /**
     * 后置通知定义方法：方法是实现切面功能的。
     * 方法的定义要求：
     * 1. 公共方法 public
     * 2. 方法没有返回值
     * 3. 方法名称自定义
     * 4. 方法有参数，推荐使用Object，参数名自定义
     */

    /**
     * @AfterReturning: 后置通知
     * 属性
     * 1. value 切入点表达式
     * 2. returning 自定义的变量，表示目标方法的返回值。自定义变量名必须和通知方法的形参名一样。
     * 位置：方法定义的上面
     * 特点：
     * 1. 在目标方法之后执行。
     * 2. 能够获取到目标方法的返回值，可以根据这个返回值做不同的处理功能
     *      Object res = doOther();
     * 3. 可以修改这个返回值
     *
     * 后置通知的执行
     * Object res = doOther();
     * myAfterReturning(res);
     */
    @AfterReturning(value = "execution(* *..SomeService.doOther(..))", returning = "res")
    public void myAfterReturning(Object res){
        //Object res：是目标方法执行后的返回值，根据返回值做切面功能的处理
        System.out.println("后置通知：在目标返回方法之后执行，获取的返回值为：" + res);
    }

    @AfterReturning(value = "execution(* com.carl.ba02.SomeService.student(..))", returning = "res")
    public void myAfterReturning1(Object res){
        System.out.println("后置通知：在目标返回方法之后执行，获取的返回值为：" + res);
        //Object res：是目标方法执行后的返回值，根据返回值做切面功能的处理
        Student student = (Student) res;
        student.setName("hzy");
        student.setAge(20);
    }
}
