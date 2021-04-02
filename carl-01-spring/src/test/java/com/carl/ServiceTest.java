package com.carl;

import com.carl.service.SomeServices;
import com.carl.service.impl.SomeServicesImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @Auther: Carl
 * @Date: 2021/03/30/14:14
 * @Description:
 */
public class ServiceTest {
    @Test
    public void test(){
        SomeServicesImpl someServices = new SomeServicesImpl();
        someServices.doSome();
    }

    //测试spring的使用
    //Spring创建对象的时间：在创建spring容器时就会创建配置文件中所有的对象
    @Test
    public void test2(){
        //指定spring配置文件的名称
        String config = "beans.xml";

        //创建表示spring容器的对象，ApplicationContext
        //ApplicationContext表示Spring容器，通过容器就可以使用对象了
        //ClassPathXmlApplicationContext：表示从类路径中加载spring的配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //从容其中获取某个对象，要调用某个对象的方法
        //getBean: 括号中放入配置文件时bean的id值
        //原类型为Object，需要强转为目标接口类型
        SomeServices someServices = (SomeServices) ac.getBean("someServices");

        //使用spring创建好的对象
        someServices.doSome();
    }

    //获取容器中java对象的信息
    @Test
    public void test3(){
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //使用Spring提供的方法获取容器中定义的对象的数量
        int nums = ac.getBeanDefinitionCount();
        System.out.println("容器中定义的对象数量 = " + nums);

        //容器中定义的对象的名称
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    //获取一个非自定义类的对象
    //spring创建对象默认调用的是无参数构造方法
    @Test
    public void test4(){
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //使用getBean()
        Date date = (Date) ac.getBean("date");
        System.out.println("date = " + date);
    }
}
