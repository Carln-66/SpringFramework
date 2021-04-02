package com.carl.ba04;

import com.carl.ba02.Student;

/**
 * @Auther: Carl
 * @Date: 2021/04/01/10:30
 * @Description:
 */
public interface SomeService {
    void doSome(String name, Integer age);
    String doOther(String name, Integer age);
    Student student(String name, Integer age);

    String doFirst(String name, Integer age);

    void doSecond();

}
