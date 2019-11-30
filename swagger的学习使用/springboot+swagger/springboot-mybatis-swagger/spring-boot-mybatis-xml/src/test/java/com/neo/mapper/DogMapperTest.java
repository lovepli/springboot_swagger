package com.neo.mapper;

import com.neo.model.Dog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DogMapperTest {

    @Autowired
    private DogMapper dogMapper;

    /**
     * 查询所有
     */
    @Test
    public void selectAllTest() {
        List<Dog> dogList=dogMapper.selectAll();
        for (Dog dog : dogList) {
            System.out.println(dog.toString());
        }
        //assertEquals(true, dogList.size() > 0);
      //  assertEquals(6,dogList.size());
    }

    /**
     * 添加
     */
    @Test
    public void insertTest() {
        Dog dog = new Dog();
        dog.setId(7);
        dog.setAge(4);
        dog.setColor("紫罗兰");
        dog.setName("紫霞仙子");
        int result = dogMapper.insert(dog);
        assertEquals(1, result);
    }

    /**
     * 条件筛选 ：查询
     */
    @Test
    public void deleteByExampleTest() {
        Example example = new Example(Dog.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",1);
        int result = dogMapper.deleteByExample(example);
        assertEquals(1,result);
    }


    @Test
    public void selectByExampleTest() {  //啥意思？？
        Example example = new Example(Dog.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",2);
        criteria.orEqualTo("id", 3);
        dogMapper.selectByExample(example);

    }

    /**
     * 条件筛选
     */
    @Test
    public void selectByExampleTest2() {
        Example example = new Example(Dog.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andGreaterThan("id",3);  //条件 id>3
        List<Dog> dogList= dogMapper.selectByExample(example);
        for (Dog dog : dogList) {
            System.out.println(dog.toString());
        }
    }

    /**
     * 排序
     */
    @Test
    public void selectByExampleTest3() {
        Example example = new Example(Dog.class);
        //example.setOrderByClause("id asc"); //按照id升序排列
        example.setOrderByClause("id desc"); //按照id降序排列
        Example.Criteria criteria = example.createCriteria();
        criteria.andGreaterThan("id",3);  //条件 id>3
        List<Dog> dogList= dogMapper.selectByExample(example);
        for (Dog dog : dogList) {
            System.out.println(dog.toString());
        }
    }



    @Test
    public void selectOneTest() {
        Example example = new Example(Dog.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name","小黑");
        List<Dog> dogs= dogMapper.selectByExample(example);
        if (dogs != null && dogs.size() > 0) {
            for (Dog dog : dogs) {
                System.out.println(dog.toString());
            }
        } else {
            System.out.println("没有这条狗！");
        }
    }

    @Test
    public void updateByPrimaryKeyTest() {

        Dog dog = new Dog();
        dog.setId(1);
        dog.setAge(4);
        dog.setColor("玫瑰色");
        dog.setName("玫瑰仙子");
        dogMapper.updateByPrimaryKey(dog);

    }


}