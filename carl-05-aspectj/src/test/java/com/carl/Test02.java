package com.carl;

import com.carl.ba02.SomeService;
import com.carl.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: Carl
 * @Date: 2021/04/01/11:00
 * @Description:
 */
public class Test02 {

    @Test
    public void test(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获取目标对象
        SomeService proxy = (SomeService) ac.getBean("someService");
        //通过代理对象执行方法，实现目标方法执行时增强了功能
        String s = proxy.doOther("李四", 26);
        System.out.println(s);
    }

    @Test
    public void test1(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获取目标对象
        SomeService proxy = (SomeService) ac.getBean("someService");
        Student qwer = proxy.student("qwer", 30);
        System.out.println(qwer);


    }
}
