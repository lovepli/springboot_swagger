package com.itguang.web;

import com.itguang.common.ResponseResult;
import com.itguang.mapper.OrderMapper;
import com.itguang.model.Order;
import com.itguang.model.User;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * @author: lipan
 * @date: 2019-06-21
 * @description:
 */
@RestController
@RequestMapping(value = "/order", produces = "application/json")
@Api(description = "订单管理")
@Slf4j
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/getAll")
    @ApiOperation(value = "获取订单列表", notes = "获取用户所有订单信息")
    public ResponseResult<List<Order>> getAllOrders() {

        List<Order> orderlist=orderMapper.selectAll();
       // List<Order> orderlist=orderMapper.getAll();
        if (orderlist.size() > 0) {
            return ResponseResult.successWithData(orderlist);
        } else {
            log.info("没有获取到用户的订单 {}",orderlist);
            return ResponseResult.successWithData(null);  //否则返回空的
        }
    }

    @GetMapping("/getOne/{id}")
    @ApiOperation(value = "获取用户单个订单信息", notes = "根据url的id来获取用户单个订单的详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "ID", name = "id", dataType = "String", paramType = "path", required = true, defaultValue = "1")
    })
    @ApiResponses({   //[注意]注意这只是在 生成的Swagger文档上有效,不要和实际的客户端调用搞混了. 通常我们都是统一JSON返回,用不到这个注解
            @ApiResponse(code = 400, message = "传入的用户参数有误"),
    })
    public ResponseResult<Order> getOrder( //[注意] @ApiParam与 Controller中方法并列使用,也可以省略的
                                          String id) {
        try {
           Order order = orderMapper.getOne(id);
            if (order != null) {
                return ResponseResult.successWithData(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            log.info("没有获取到用户的订单");
            return ResponseResult.failWithCodeAndMsg(404,"用户没有找到！！！");
    }



}
