package com.itguang.model;

/**
 * @author: lipan
 * @date: 2019-06-21
 * @description:
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @author: lipan
 * @date: 2019-06-15
 * @description: 订单类
 */

@ApiModel(description = "用户订单")
public class Order {


    @ApiModelProperty(value = "主键id",name = "id")
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private String userId;

    @NotBlank
    @Column(name = "number")
    private  String number;
    private  String note;

    //订单表里面有用户
   // private User user;  //一个订单只能对应一个用户 一对一关系

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }


    public Order(String userId, String number, String note) {
        this.userId=userId;
        this.number=number;
        this.note=note;
    }

    public Order() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

