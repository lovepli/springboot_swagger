package com.neo.mapper;

import com.neo.model.Order;
import com.neo.model.OrderUser;

import java.util.List;

/**
 * @author: lipan
 * @date: 2019-06-15
 * @description:
 */
public interface OrderMapper {

    /**
     * 获取订单列表
     * @return
     */
    List<Order> getOrderList();

    /**
     * 使用resultMap获取订单列表
     * @return
     */
    List<Order> getOrderListMap();


    /**
     * 演示where 标签的使用
     * @param order
     * @return
     */
    List<Order> getOrderByPojo(Order order);

    /**
     * 一对一关联 resultType使用
     * @return
     */
    List<OrderUser> getOrderUser();

    /**
     * 一对一关联： resultMap使用
     * @return
     */
    List<Order> getOrderUserMap();


}
