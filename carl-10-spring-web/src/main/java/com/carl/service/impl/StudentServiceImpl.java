package com.carl.service.impl;

import com.carl.dao.StudentDao;
import com.carl.domain.Student;
import com.carl.service.StudentService;

import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/04/01/16:33
 * @Description:
 */
public class StudentServiceImpl implements StudentService {

    //引用类型
    private StudentDao studentDao;

    //利用set注入进行赋值
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        int num = studentDao.insertStudent(student);
        return num;
    }

    @Override
    public List<Student> queryStudents() {
        List<Student> students = studentDao.selectAllStudents();
        return students;
    }
}
