package com.carl.ba07;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Auther: Carl
 * @Date: 2021/03/31/10:49
 * @Description:
 */
@Component("myStudent")
public class Student {
    @Value(value = "张三")
    private String name;
    @Value("19")
    private Integer age;

    /**
     * 引用类型
     * @Resource: 来自JDK中的注解，spring框架提供了对这个注解的功能支持，可以使用它给引用类型赋值，使用的也是自动注入原理，支持nyName,byType，默认为byName
     * 位置：1. 在属性定义的上面，无需set方法，推荐
     *      2. 在set方法上面
     */
    //只使用byName的方式，需要增加一个属性  name，name的值是bean的id(名称)
    @Resource(name = "mySchool")
    private School school;

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
