package com.carl;


import com.carl.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: Carl
 * @Date: 2021/03/30/15:47
 * @Description:
 */
public class MyTest03 {

    @Test
    public void test01(){
        String config = "ba03/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        Student student = (Student) ac.getBean("myStudent3");
        System.out.println(student);
    }
}
