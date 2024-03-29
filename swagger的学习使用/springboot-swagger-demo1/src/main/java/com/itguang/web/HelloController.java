package com.itguang.web;

import com.itguang.common.ResponseResult;
import com.itguang.model.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * @author itguang
 * @create 2018-01-04 13:31
 * 访问地址：http://localhost/swagger-ui.html
 **/

@RestController
@RequestMapping(value = "/user", produces = APPLICATION_JSON_VALUE) //配置返回值 application/json 也可以写成： produces = "application/json"
@Api(description = "用户管理")
public class HelloController {

    ArrayList<User> users = new ArrayList<>();


    @GetMapping(value = {""})
    @ApiOperation(value = "获取用户列表", notes = "获取所有用户信息")
    public ResponseResult<List<User>> hello() {
        users.add(new User("逻辑", "luoji"));
        users.add(new User("叶文杰", "yewenjie"));
        return ResponseResult.successWithData(users);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User",defaultValue = "null")
    })
    @ApiResponses({   //[注意]注意这只是在 生成的Swagger文档上有效,不要和实际的客户端调用搞混了. 通常我们都是统一JSON返回,用不到这个注解
            @ApiResponse(code = 400, message = "请求参数有误"),
    })
    public ResponseResult<User> postUser(User user) {
        return ResponseResult.successWithData(user);
    }

    @GetMapping("getUser/{id}")
    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "ID", name = "id", dataType = "String", paramType = "path", required = true, defaultValue = "null")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<User> getUser(@ApiParam(value = "用户id", required = true) //[注意] @ApiParam与 Controller中方法并列使用,也可以省略的
                        @PathVariable(value = "id") String id) {
           User user=new User(id, "itguang", "123456");
        return ResponseResult.successWithData(user) ;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "根据用户id删除用户", notes = "删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<String> deleteUser(@PathVariable String id) {
        String str="删除成功！！！";
        return ResponseResult.successWithData(str) ;
    }
}
