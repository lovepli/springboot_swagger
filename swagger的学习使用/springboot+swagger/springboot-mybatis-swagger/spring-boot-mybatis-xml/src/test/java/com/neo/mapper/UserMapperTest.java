package com.neo.mapper;

import java.util.Arrays;
import java.util.List;

import com.neo.model.Order;
import com.neo.model.QueryVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.neo.model.User;
import com.neo.enums.UserSexEnum;

/**
 * 简单测试接口的方法
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testInsert() throws Exception {
		userMapper.insert(new User("aa", "a123456", UserSexEnum.MAN));
		userMapper.insert(new User("bb", "b123456", UserSexEnum.WOMAN));
		userMapper.insert(new User("cc", "b123456", UserSexEnum.WOMAN));

		Assert.assertEquals(3, userMapper.getAll().size());
	}

	@Test
	public void testQuery() throws Exception {  //数据库utf8格式问题
		List<User> users = userMapper.getAll();
        if (users == null || users.size() == 0) {
            System.out.println("is null");
        } else {
            System.out.println(users.toString());
        }
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		User user = userMapper.getOne(3l);  // 注意这里是3l 不是3 ！
		System.out.println(user.toString());
		user.setNickName("neo");
		userMapper.update(user);
		Assert.assertTrue(("neo".equals(userMapper.getOne(3l).getNickName())));
	}

	@Test
	public void testGetUserByQueryVo() throws Exception{
        QueryVo vo = new QueryVo();
     	User user2 = userMapper.getOne(1l);
     	user2.setUserName("bb");
        //设置User
        vo.setUser(user2);

        List<User> userList = userMapper.getUserByQueryVo(vo);
        if (userList == null || userList.size() == 0) {
            System.out.println("is null");
        } else {
            for (User user : userList) {
                System.out.println(user);
            }
        }
          Assert.assertEquals(1, userList.size());
    }

    //有问题？？
    @Test
    public void getUserCount() throws Exception{

//        long n = UserMapper.getUserCount();
//
//        Assert.assertEquals(5l,n);


    }

    @Test
    public void getUserByIds() throws Exception{
        QueryVo vo = new QueryVo();
        //构建ID列表
        vo.setIds(Arrays.asList(1l,3l,5l,7l));

        List<User> list = userMapper.getUserByIds(vo);
        for (User user : list) {
            System.out.println(user);
           // System.out.println(user.toString());//TODO 这里我们重写了toString()方法，输出这个就报空指针异常？？？
        }
    }

    @Test
    public void getUserOrderMap() {
        List<User> list = userMapper.getUserOrderMap();
        for (User user : list) {
            System.out.println(user);
            for (Order order : user.getOrders()) {
                if (order.getId() != null) {
                    System.out.println("      此用户下的订单有："+order);
                }
            }
        }
    }


}