package com.carl.controller; /**
 * @Auther: Carl
 * @Date: 2021/04/02/16:37
 * @Description:
 */

import com.carl.domain.Student;
import com.carl.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("id");
        String strName = request.getParameter("name");
        String strEmail = request.getParameter("email");
        String strAge = request.getParameter("age");

        //创建spring的容器对象
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        System.out.println("容器对象的信息--->" + ac);

        //获取service
        StudentService studentService = (StudentService) ac.getBean("studentService");
        Student student = new Student(Integer.parseInt(strId), strName, strEmail, Integer.parseInt(strAge));
        studentService.addStudent(student);

        //给一个页面
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
