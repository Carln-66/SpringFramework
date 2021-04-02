package com.carl;

import com.carl.ba01.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: Carl
 * @Date: 2021/04/01/11:00
 * @Description:
 */
public class Test01 {

    @Test
    public void test(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //从容器中获取目标对象
        SomeService proxy = (SomeService) ac.getBean("someService");

        System.out.println("proxy名称：" + proxy.getClass().getName());

        //通过代理对象执行方法，实现目标方法执行时增强了功能
        proxy.doSome("李四", 26);
    }
}
