package com.carl;


import com.carl.ba02.School;
import com.carl.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: Carl
 * @Date: 2021/03/30/15:47
 * @Description:
 */
public class MyTest01 {

    @Test
    public void test01(){
        String config = "ba02/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        Student student = (Student) ac.getBean("myStudent");
        System.out.println(student);
    }

    @Test
    public void test02(){
        Student student = new Student();
        student.setName("李四");
        student.setAge(20);

        School school = new School();
        school.setName("清华");
        school.setAddress("北京");
        student.setSchool(school);
        System.out.println(student);
    }
}
