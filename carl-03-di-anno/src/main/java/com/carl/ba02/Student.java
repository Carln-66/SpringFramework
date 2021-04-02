package com.carl.ba02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Auther: Carl
 * @Date: 2021/03/31/10:49
 * @Description:
 */
@Component("myStudent")
public class Student {
    /**
     * @Vaule: 简单类型的属性赋值
     * 属性：value是String类型的，表示简单类型的属性值
     * 位置：1. 在属性定义的上面，无需set方法，推荐使用。
     *      2. 在set方法的上面
     */
    @Value(value = "张三")
    private String name;
    @Value("19")
    private Integer age;

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
                '}';
    }
}
