package com.itguang.common.constant;

//import static com.switchvov.swagger.demo.common.ResponseResult.ResponseParam;
//import static com.switchvov.swagger.demo.common.ResponseResult.ResponseParam.buildParam;

import com.itguang.common.ResponseResult;

import static com.itguang.common.ResponseResult.ResponseParam.buildParam;

/**
 * 响应码
 *
 * @author Switch
 * @date 2018-04-04
 */
public enum ResponseCode {
    /**
     * 成功
     */
    SUCCESS(buildParam(0, "成功"));

    public final ResponseResult.ResponseParam PARAM;

    ResponseCode(ResponseResult.ResponseParam param) {
        this.PARAM = param;
    }

    public int getCode() {
        return this.PARAM.getCode();
    }

    public String getMsg() {
        return this.PARAM.getMsg();
    }
}
