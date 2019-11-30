package com.itguang.mapper;

import com.itguang.model.Order;
import com.itguang.model.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 使用Example类来测试
 */
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 查询所有
     */
    @Test
    public void selectAllTest() {
        List<Order> oderList=orderMapper.selectAll();
        for (Order order : oderList) {
            System.out.println(order.toString());
        }
        //assertEquals(true, oderList.size() > 0);
        //  assertEquals(6,oderList.size());
    }

    /**
     * 添加
     */
    @Test
    public void insertTest() {
        Order order = new Order();
       order.setId("1");
       order.setUserId("1");
       order.setNumber("23");
       order.setNote("新开镇");
       //order.setUser(new User("张三","123456"));

        int result = orderMapper.insert(order);
        assertEquals(1, result);
    }

    /**
     * 条件筛选 ：查询
     */
    @Test
    public void deleteByExampleTest() {
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",1);
        int result = orderMapper.deleteByExample(example);
        assertEquals(1,result);
    }


    @Test
    public void selectByExampleTest() {  //啥意思？？
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",2);
        criteria.orEqualTo("id", 3);
        orderMapper.selectByExample(example);

    }

    /**
     * 条件筛选
     */
    @Test
    public void selectByExampleTest2() {
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andGreaterThan("id",3);  //条件 id>3
        List<Order> orderList= orderMapper.selectByExample(example);
        for (Order order : orderList) {
            System.out.println(order.toString());
        }
    }

    /**
     * 排序
     */
    @Test
    public void selectByExampleTest3() {
        Example example = new Example(Order.class);
        //example.setOrderByClause("id asc"); //按照id升序排列
        example.setOrderByClause("id desc"); //按照id降序排列
        Example.Criteria criteria = example.createCriteria();
        criteria.andGreaterThan("id",3);  //条件 id>3
        List<Order> orderList= orderMapper.selectByExample(example);
        for (Order order : orderList) {
            System.out.println(order.toString());
        }
    }



    @Test
    public void selectOneTest() {
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name","小黑");
        List<Order> dogs= orderMapper.selectByExample(example);
        if (dogs != null && dogs.size() > 0) {
            for (Order dog : dogs) {
                System.out.println(dog.toString());
            }
        } else {
            System.out.println("没有这条狗！");
        }
    }

    @Test
    public void updateByPrimaryKeyTest() {

        Order order = new Order();
        order.setId("1");
        order.setUserId("1");
        order.setNumber("23");
        order.setNote("新开镇");
       // order.setUser(new User("张三","123456"));
        orderMapper.updateByPrimaryKey(order);

    }




}