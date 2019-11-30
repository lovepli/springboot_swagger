package com.neo.model;

/**
 * @author: lipan
 * @date: 2019-06-15
 * @description: 订单类
 */
public class Order {

    private Integer id;
    private Long userId;
    private  String number;
    private  String note;

    //订单表里面有用户
    private User user;  //一个订单只能对应一个用户 一对一关系

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order(Long userId, String number, String note) {
     this.userId=userId;
     this.number=number;
     this.note=note;
    }

    public Order() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

//    @Override
//    public String toString() {
//        return "Order (" + "userId:" + userId + ",number:" + number + ",note:" + note + " ,User:" + user.toString() + ")";
//    }
}
