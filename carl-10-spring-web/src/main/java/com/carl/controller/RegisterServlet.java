package com.carl.controller; /**
 * @Auther: Carl
 * @Date: 2021/04/02/16:37
 * @Description:
 */

import com.carl.domain.Student;
import com.carl.service.StudentService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("id");
        String strName = request.getParameter("name");
        String strEmail = request.getParameter("email");
        String strAge = request.getParameter("age");

        //创建spring的容器对象
//        String config = "spring.xml";
//        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //创建spring的容器对象
//        WebApplicationContext ctx = null;
//        String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
//        Object attribute = getServletContext().getAttribute(key);
//        if (attribute != null) {
//            ctx = (WebApplicationContext) attribute;
//        }

        //利用框架中的工具类获取容器对象
        ServletContext sc = getServletContext();
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sc);
        System.out.println("容器对象的信息--->" + ctx);

        //获取service
        StudentService studentService = (StudentService) ctx.getBean("studentService");
        Student student = new Student(Integer.parseInt(strId), strName, strEmail, Integer.parseInt(strAge));
        studentService.addStudent(student);

        //给一个页面
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
