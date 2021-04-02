package com.carl.ba03;

/**
 * @Auther: Carl
 * @Date: 2021/03/30/16:32
 * @Description:
 */
public class School {
    private String name;
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
