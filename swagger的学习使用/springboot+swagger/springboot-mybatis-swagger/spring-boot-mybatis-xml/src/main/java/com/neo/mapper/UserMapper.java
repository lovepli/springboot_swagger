package com.neo.mapper;

import java.util.List;

import com.neo.model.QueryVo;
import com.neo.model.User;

public interface UserMapper {
	
	List<User> getAll();
	
	User getOne(Long id);

	void insert(User user);

	void update(User user);

	void delete(Long id);

    /**
     * 传递包装pojo
     * @param vo
     * @return
     */
	List<User> getUserByQueryVo(QueryVo vo);

    /**
     * 查询用户总记录数
     *
     * @return
     */
     Long getUserCount () ;

    /**
     * 演示foreach标签的使用 根据用户ID列表查询用户
     * @return
     */
     List<User> getUserByIds(QueryVo vo);

    /**
     * 演示一对多关联查询 resultMap
     * @return
     */
    List<User> getUserOrderMap();

}