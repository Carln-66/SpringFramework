package com.carl;

import com.carl.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: Carl
 * @Date: 2021/03/31/10:20
 * @Description:
 */
public class Test03 {

    @Test
    public void test(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //从容器中获取对象
        Student student = (Student) ac.getBean("myStudent");
        System.out.println("Student : " + student);
    }
}
