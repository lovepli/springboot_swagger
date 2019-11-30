package com.neo.model;

import com.neo.enums.UserSexEnum;

/**
 * @author: lipan
 * @date: 2019-06-16
 * @description: 订单关联 用户的pojo
 */
public class OrderUser extends Order {

    private String userName;  //用户名

    private String nickName; //用户昵称

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "OrderUser{" +
                "userName='" + userName + '\'' +
                super.toString()+
                '}';
    }
}
