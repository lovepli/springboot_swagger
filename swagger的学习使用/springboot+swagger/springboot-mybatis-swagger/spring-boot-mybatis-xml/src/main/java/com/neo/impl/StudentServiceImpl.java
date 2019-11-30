package com.neo.impl;

import com.neo.mapper.StudentMapper;
import com.neo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author: lipan
 * @date: 2019-06-17
 * @description:
 */
public class StudentServiceImpl {

    @Autowired
    private StudentMapper studentMapper;

//
//    public List<Student> queryQuitLeaseOwnChargeDetails(Student student) {
//        Example query = new Example(Student.class);
//        query.createCriteria().andEqualTo("name","张三");
//        //System.out.println(studentMapper.selectByExample(query));
//        return studentMapper.selectByExample(query);
//    }

}
