package com.neo.model;

import lombok.Data;

/**
 * @author: lipan
 * @date: 2019-06-19
 * @description:
 */
@Data
public class Dog {

    private Integer id;

    private String name;

    private Integer age;

    private String color;

    public Dog() {

    }

    public Dog(String name,Integer age,String color) {
        this.name=name;
        this.age=age;
        this.color=color;
    }

}
