package com.carl.dao;

import com.carl.domain.Student;

import java.util.List;

/**
 * @Auther: Carl
 * @Date: 2021/04/01/16:18
 * @Description:
 */
public interface StudentDao {

    int insertStudent(Student student);
    List<Student> selectAllStudents();
}
