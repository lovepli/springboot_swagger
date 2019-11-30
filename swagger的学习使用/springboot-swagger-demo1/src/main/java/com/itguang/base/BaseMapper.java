package com.itguang.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author: lipan
 * @date: 2019-06-21
 * @description:
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
