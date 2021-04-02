package com.carl.ba03;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Auther: Carl
 * @Date: 2021/03/30/16:32
 * @Description:
 */
//@Component("mySchool")
public class School {
    @Value("北大")
    private String name;
    @Value("北京市")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
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
