package com.neo.web;

import java.util.List;

import com.neo.common.ResponseResult;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.neo.model.User;
import com.neo.mapper.UserMapper;

@RestController
@RequestMapping(value = "/users" ,produces = "application/json")
@Api(tags = "1.1", description = "用户管理", value = "用户管理")
@Slf4j
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("/getUsers")
    @ApiOperation(value = "获取用户列表", notes = "获取所有用户信息")
	public ResponseResult<List<User>> getUsers() {
		List<User> users=userMapper.getAll();
        if (users.size() > 0) {
            return ResponseResult.successWithData(users);
        } else {
            log.info("用户没有找到！！");
            return ResponseResult.failWithCodeAndMsg(404,"用户没有找到！！！");
        }
	}
	
    @GetMapping("/getUser/{id}")
    @ApiOperation(value = "根据用户id查找到用户信息", notes = "查找用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<User> getUser(  Long id) {//@PathVariable("id") Long id
    	User user=userMapper.getOne(id);
        if (user != null) {
            return ResponseResult.successWithData(user);
        } else {
            log.info("用户没有找到！！");
            return ResponseResult.failWithCodeAndMsg(404,"用户没有找到！！！");
        }
    }
    
    @PostMapping("/add")
    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User",defaultValue = "null")
    })
    @ApiResponses({   //[注意]注意这只是在 生成的Swagger文档上有效,不要和实际的客户端调用搞混了. 通常我们都是统一JSON返回,用不到这个注解
            @ApiResponse(code = 400, message = "传入的用户参数有误"),
    })
    public ResponseResult<String> save(User user) {
        userMapper.insert(user);
        if (userMapper.getOne(user.getId()) != null) {
            log.info("添加成功 -->{}", user);
            return ResponseResult.successWithData("添加用户成功！");
        } else {
            return ResponseResult.failWithCodeAndMsg(404,"添加用户失败！！！");
        }


    }
    
    @RequestMapping(value="update",method = RequestMethod.PUT)
    @ApiOperation(value = "修改用户", notes = "根据User对象修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User",defaultValue = "null")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "传入的用户参数有误"),
    })
    public ResponseResult<String> update(User user) {
    	userMapper.update(user);
        if (user != null) {
            log.info("修改成功 -->{}", user);
            return ResponseResult.successWithData("修改成功！！！");
        } else {
            return ResponseResult.failWithCodeAndMsg(404,"修改用户失败！！！");
        }

    }


    @DeleteMapping(value="/delete/{id}")
    @ApiOperation(value = "根据用户id删除用户", notes = "删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public  ResponseResult<String> delete(@PathVariable("id") Long id) {
    	userMapper.delete(id);
        if (userMapper.getOne(id) ==null) {
            log.info("删除用户成功 ");
            return ResponseResult.successWithData("删除用户成功！");
        } else {
           // return new RuntimeException("代码跑了一个异常！！");  //这是在try catch的时候要用的
            return ResponseResult.failWithCodeAndMsg(404,"删除用户失败！！！");
        }
    }
    
    
}