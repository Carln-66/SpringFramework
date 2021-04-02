package com.carl;


import com.carl.dao.StudentDao;
import com.carl.domain.Student;
import com.carl.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/04/01/19:05
 * @Description:
 */
public class MyTest {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("容器中对象的名称  " + name + "  |  " + ac.getBean(name));
        }
    }

    @Test
    public void testInsert(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //获取spring容器中的dao对象
        StudentDao studentDao = (StudentDao) ac.getBean("studentDao");
        Student student = new Student(1006, "测试插入", "test@abc.com", 19);
        int i = studentDao.insertStudent(student);
        System.out.println("num = " + i);
    }

    @Test
    public void testServiceInsert(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //获取spring容器中的dao对象
        StudentService studentService = (StudentService) ac.getBean("studentService");
        Student student = new Student(1007, "测试01", "test01@abc.com", 22);
        //spring和mybatis整合在一起使用，事务是自动提交的，无需执行SqlSession.commit();
        int num = studentService.addStudent(student);
        System.out.println("num = " + num);
    }

    @Test
    public void testServiceSelect(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        //获取spring容器中的dao对象
        StudentService studentService = (StudentService) ac.getBean("studentService");
        List<Student> students = studentService.queryStudents();
        for (Student student : students){
            System.out.println(student);
        }
    }
}
