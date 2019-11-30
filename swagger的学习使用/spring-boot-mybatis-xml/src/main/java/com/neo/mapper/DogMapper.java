package com.neo.mapper;

import com.neo.base.BaseMapper;
import com.neo.model.Dog;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author: lipan
 * @date: 2019-06-19
 * @description: 继承通用mapper
 */
//public interface DogMapper extends BaseMapper<Dog> {
public interface DogMapper extends Mapper<Dog> {

}
