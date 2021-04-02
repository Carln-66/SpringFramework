package com.carl.ba03;

/**
 * @Auther: Carl
 * @Date: 2021/03/30/15:43
 * @Description:
 */
public class Student {
    private String name;
    private int age;

    private School school;

    public Student() {
    }

    public Student(String myName, int myAge, School mySchool) {
        this.name = myName;
        this.age = myAge;
        this.school = mySchool;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
