package com.carl;

import com.carl.ba03.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: Carl
 * @Date: 2021/04/01/11:00
 * @Description:
 */
public class Test03 {

    @Test
    public void test(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获取目标对象
        SomeService proxy = (SomeService) ac.getBean("someService");
        //通过代理对象执行方法，实现目标方法执行时增强了功能
        String str = proxy.doFirst("张三", 33);
        System.out.println(str);
    }

}
