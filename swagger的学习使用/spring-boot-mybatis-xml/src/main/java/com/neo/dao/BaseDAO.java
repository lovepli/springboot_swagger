package com.neo.dao;

import tk.mybatis.mapper.common.Mapper;

/**
 * ClassName:BaseDAO <br/>
 * Function: 基础DAO服务接口. <br/>
 * Reason: 基础DAO服务接口. <br/>
 * Date: 2017年3月7日 上午10:33:19 <br/>
 *
 *
 * @version
 * @since
 * @see
 */
public interface BaseDAO<T extends BaseDO> extends Mapper<T> {

}
