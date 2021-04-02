package com.carl.domain;

/**
 * @Auther: Carl
 * @Date: 2021/04/02/13:39
 * @Description:
 */
public class Goods {
    private Integer id;
    private String name;
    private Integer amount;
    private Float price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
