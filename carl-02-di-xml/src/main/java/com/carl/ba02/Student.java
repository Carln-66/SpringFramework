package com.carl.ba02;

/**
 * @Auther: Carl
 * @Date: 2021/03/30/15:43
 * @Description:
 */
public class Student {
    private String name;
    private int age;

    private School school;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(School school) {
        System.out.println("set School = " + school);
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
