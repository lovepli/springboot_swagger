package com.neo.model;

import java.io.Serializable;
import java.util.List;

import com.neo.enums.UserSexEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
    @ApiModelProperty("用户名")
	private String userName;
    @ApiModelProperty("密码")
	private String passWord;
	private UserSexEnum userSex;
	private String nickName;

	private List<Order> orders;  // 订单列表 一个用户有多个订单 一对多关系


    public User() {
		super();
	}

	public User(String userName, String passWord, UserSexEnum userSex) {
		super();
		this.passWord = passWord;
		this.userName = userName;
		this.userSex = userSex;
	}

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public UserSexEnum getUserSex() {
		return userSex;
	}

	public void setUserSex(UserSexEnum userSex) {
		this.userSex = userSex;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "( userName " + this.userName + ", pasword " + this.passWord + "sex " + userSex.name()+" )";
	}



}