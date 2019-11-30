package com.itguang.mapper;

import com.itguang.base.BaseMapper;
import com.itguang.model.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: lipan
 * @date: 2019-06-21
 * @description:
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 查询所有
     * @return
     */
   // List<Order> getAll();

    /**
     * 查询一个
     * @param id
     * @return
     */
    Order getOne(String id);

    /**
     * 新增订单
     * @param order
     */
    void insertOne(Order order);

    /**
     * 更新订单
     * @param order
     */
    void updateOne(Order order);

    /**
     * 删除订单
     * @param id
     */
    void deleteOne(String id);
}
