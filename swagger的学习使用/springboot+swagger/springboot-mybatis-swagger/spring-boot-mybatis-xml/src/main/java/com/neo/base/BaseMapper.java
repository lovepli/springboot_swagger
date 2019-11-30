package com.neo.base;

/**
 * @author: lipan
 * @date: 2019-06-19
 * @description:
 */
import tk.mybatis.mapper.common.Mapper;  //Example工具类的使用
import tk.mybatis.mapper.common.MySqlMapper; //分页

/**
 * 该接口不能被扫描到，否则会出错
 * @author Administrator
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
