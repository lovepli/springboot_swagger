package com.neo.mapper;

import com.neo.model.Order;
import com.neo.model.OrderUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;  //orderMap 代理实现

    @Test
    public void getOrderList() {
        List<Order> list = orderMapper.getOrderList();
        for (Order order : list) {
            System.out.println(order);
        }
    }

    @Test
    public void getOrderListMap() throws Exception{
        List<Order> list = orderMapper.getOrderListMap();
        for (Order order : list) {
            System.out.println(order);
        }
    }


    @Test
    public void getOrderByPojo() throws Exception {

        Order order = new Order();
        order.setUserId(123l);
        order.setNumber("12345");

        List<Order> list=orderMapper.getOrderByPojo(order);
        for (Order o : list) {
            System.out.println(o);
        }
    }

    @Test
    public void getOrderUser() throws Exception {

        List<OrderUser> list = orderMapper.getOrderUser();
        for (OrderUser orderUser : list) {
            System.out.println(orderUser);
        }
    }

    @Test
    public void getOrderUserMap() {
        List<Order> list = orderMapper.getOrderUserMap();
        for (Order order : list) {
            System.out.println(order);
            System.out.println("     此订单的用户为："+order.getUser());
        }
    }
}