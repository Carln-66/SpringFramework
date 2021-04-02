package com.carl.ba05.Impl;

import com.carl.ba02.Student;
import com.carl.ba05.SomeService;

/**
 * @Auther: Carl
 * @Date: 2021/04/01/13:05
 * @Description:
 */
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        //给doSome方法增加一个功能，在doSome()执行之前，输出方法的执行时间
        System.out.println("======主要业务方法doSome=====");
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("======主要业务方法doOther=====");
        return "abc";
    }

    @Override
    public Student student(String name, Integer age) {
        System.out.println("=======主要业务方法student========");
        Student student = new Student();
        student.setName("lmx");
        student.setAge(18);
        return student;
    }

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println("======主要业务方法doFirst=====");
        return "doFirst";
    }

    @Override
    public void doSecond() {
        System.out.println("======主要业务方法doSecond=====" + 10/0);
    }

    @Override
    public void doThird() {
        System.out.println("======主要业务方法doThird=====" + 10/0);
    }
}
