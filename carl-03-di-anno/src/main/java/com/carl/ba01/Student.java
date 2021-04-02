package com.carl.ba01;

/**
 * @Auther: Carl
 * @Date: 2021/03/31/10:05
 * @Description:
 */

import org.springframework.stereotype.Component;

/**
 * @Component: 用于创建对象，等同于<bean>的功能
 * 属性：value  对象的名称，也就是bean的id值
 *      value的值是唯一的，创建的对象在整个spring容器中只有一个。
 * 位置：在类的上面
 * @Component(value = "myStudent")  等同于
 * <bean id = "myStudent" class = "com.carl.ba01.Student" />
 *
 * spring中和@Component功能一致，创建对象的注释还有
 * 1. @Repository(用于持久层类的上面): 放在dao的实现类上面，表示创建dao对象，dao对象试能访问数据库的。
 * 2. @Service(用于业务层类的上面): 放在Service的实现类上面，创建service对象，service对象是做业务处理，可以有事务等功能的。
 * 3. @Controller(用在控制器的上面): 放在控制器（处理器）类的上面，创建控制器对象的，控制器对象能够接收用户提交的参数，显示请求的处理结果的。
 * 以上三个注解的使用语法和@Component一样都能创建对象，但是这个三个注解还有额外的功能。
 * 这三个注解是给项目的对象分层的
 */
//使用value属性指定对象名称
//@Component(value = "myStudent")

//省略value
@Component("myStudent")

//不指定对象名称，由spring提供默认名称，类名的首字母小写
//@Component
public class Student {

    private String name;
    private Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
