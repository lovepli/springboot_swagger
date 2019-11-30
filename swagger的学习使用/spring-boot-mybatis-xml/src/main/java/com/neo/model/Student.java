package com.neo.model;

import com.neo.dao.BaseDO;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Table;

/**
 * @author: lipan
 * @date: 2019-06-17
 * @description:
 */
@Data
@Table(name = "student")
//public class Student extends BaseDO {
    public class Student  {
    /**
     * 学生id
     */
    private Integer id;
    /**
     * 学生姓名
     */
    private String name;
    private Integer age;
    private String sex;
    private String address;
    private Integer height;
    private Integer weight;

    public Student() {

    }


    public Student(String name, Integer age, String sex, String address, Integer height, Integer weight) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Student{" +
                " name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }


}
