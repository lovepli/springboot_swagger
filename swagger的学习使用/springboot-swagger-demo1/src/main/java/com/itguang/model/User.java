package com.itguang.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;

/**
 * @author itguang
 * @create 2017-12-30 14:39
 *
 *
 * PS：用户model使用了lombok、jpa、validator，只需要关注@Api开头的注解就行了。
 **/


@ApiModel(description = "用户Model")
public class User {

     //此注解可以作用在字段或者方法上,只要 hidden 属性为 true ,该字段或者方法就不会被生成api文档.
    @ApiModelProperty(hidden = true)
    private String id;

   // @NotBlank(message = "   用户名不能为空")  //使用的是validator插件
    @ApiModelProperty(value = "用户名",name = "username")
    @Column(name = "username")
    private String username;

    @ApiModelProperty(hidden = true)
    private Integer age;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "邮箱")
    private String email;

//    private List<Order> orders;  // 订单列表 一个用户有多个订单 一对多关系
//
//
//    public List<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }
    public User(String username, String password,String email,Integer age) {
            this.username=username;
            this.password=password;
            this.email=email;
            this.age=age;
    }
    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


}
