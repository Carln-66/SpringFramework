package com.carl.service;

import com.carl.domain.Student;

import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/04/01/16:31
 * @Description:
 */
public interface StudentService {
    int addStudent(Student student);

    List<Student> queryStudents();

}
