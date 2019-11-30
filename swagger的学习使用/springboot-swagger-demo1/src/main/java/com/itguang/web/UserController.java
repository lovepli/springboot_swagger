package com.itguang.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author itguang
 * @create 2018-01-05 8:23
 * Swagger2基本接口的使用：
 * @Api: 描述类/接口的主要用途
 *
 * @ApiOperation: 描述方法用途
 *
 * @ApiImplicitParam: 描述方法的参数
 *
 * @ApiImplicitParams: 描述方法的参数(Multi - Params)
 *
 * @ApiParam:请求属性
 *
 * @ApiIgnore: 忽略某类/方法/参数的文档 @ApiIgnore//使用该注解忽略这个接口API
 *
 * @ApiResponse：响应配置
 *
 * @ApiResponses：响应集配置
 *
 * @ResponseHeader: 响应头设置
 *
 * @ApiModelProperty:添加和操作模型属性的数据
 *
 **/
@RestController
public class UserController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

}
