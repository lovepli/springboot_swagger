package com.neo.mapper;

import com.neo.model.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import javax.persistence.Table;
import java.lang.reflect.Array;
import java.util.*;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void save() {

        studentMapper.save(new Student("张九",11,"男","黄梅县城",150,24));
        Assert.assertEquals(11,studentMapper.select().size());  //数值比较

    }

    @Test
    public void select() {

        List<Student> studentlist = studentMapper.select();
        if (studentlist == null || studentlist.size() == 0) {
            System.out.println("student is empty");
        } else {
            for (Student student : studentlist) {
                System.out.println(student.toString());
            }
        }
    }

    @Test
    public void selectOne2() {

        Student student = studentMapper.selectOne2(9, "张三");
        Student student2 = studentMapper.selectOne(9);
        if (student.getId() == student2.getId() && Objects.equals(student, student2)) {  //比较对象
            System.out.println(student.toString());
        } else {
            System.out.println("没有找到符合条件的Student对象！！！");
        }

    }

    @Test
    public void selectOne3() {
        //Student student = studentMapper.selectOne3();
        // Student student = studentMapper.selectOne3("张三");
       // Student student = studentMapper.selectOne3("",150,4);
        Student student = studentMapper.selectOne3("老六",1);  //这里为什么非要加name属性不能一个条件查询？？？
        System.out.println(student.toString());
    }


    @Test
    public void selectOne4() {
      // Student student = studentMapper.selectOne4(23,"老张");
       // Student student = studentMapper.selectOne4(23,"老张",24);
        Student student = studentMapper.selectOne4(23,"深圳市区911");

        System.out.println(student.toString());

    }

    @Test
    public void update1() {
        Student student = studentMapper.selectOne(7);
        System.out.println(student.toString());
        student.setName("老张");
        studentMapper.update1(student);
        Assert.assertTrue("老张".equals(studentMapper.selectOne(7).getName())); //字符串比较
    }

    @Test
    public void update2() {
    }

    @Test
    public void update4() {

        Student student = studentMapper.selectOne(9);
        System.out.println(student.toString());
        student.setName("老三");
        student.setAddress("深圳市区911");
        studentMapper.update4(student);
        Assert.assertTrue("老三".equals(studentMapper.selectOne(9).getName())); //字符串比较
        Assert.assertTrue("深圳市区911".equals(studentMapper.selectOne(9).getAddress())); //字符串比较
    }

    @Test
    public void getStudentListParams() {
        List<Student> studentlist = studentMapper.select();
        List<Integer> studentIds = new ArrayList<>();
        for (Student student : studentlist) {
            studentIds.add(student.getId());
        }
        System.out.println(studentIds.size());
        List<Student> list= studentMapper.getStudentListParams(studentIds);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        for (Student student : list) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void getStudentMapParams() {

        Map<Integer, Student> map = new HashMap<>();
        List<Student> studentlist = studentMapper.select();
        //遍历集合
        for (Student s : studentlist) {
            map.put(s.getId(), s);  //key =学生id value=学生
        }
        List<Student> list = studentMapper.getStudentMapParams(map);
        for (Student student : list) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void getStudentArrayParams() {

       Integer[] arrayIds = {1,2,3,4,5,6,7,8,9,10,11};  //所有id的数组
        List<Student> list= studentMapper.getStudentArrayParams(arrayIds);
        for (Student student : list) {
            System.out.println(student.toString());
        }

    }

    @Test
    public void selectLikeName() {
        List<Student> studentslist2 = studentMapper.selectLikeName("张");
        if (studentslist2 == null || studentslist2.size() == 0) {
            System.out.println("student is empty");
        } else {
            for (Student student : studentslist2) {
                System.out.println(student.toString());
            }
        }
    }

    @Test
    public void selectLikeName2() {
        List<Student> studentslist2 = studentMapper.selectLikeName2("张");
        if (studentslist2 == null || studentslist2.size() == 0) {
            System.out.println("student is empty");
        } else {
            for (Student student : studentslist2) {
                System.out.println(student.toString());
            }
        }
    }


    @Test
    public void  findByTableAndId() throws Exception{  //有问题？？
        Student student = studentMapper.findByTableAndId("student", 1);
        System.out.println(student.toString());
    }




    @Test
    public void queryQuitLeaseOwnChargeDetails() throws Exception {

//        List<Student> list = studentMapper.selectAll();
//        assertEquals(true, list.size() > 0);
    }

    @Test
   public void  insertStudentListParams() {
        List<Student> studentList=Arrays.asList(new Student("李四",11,"男","黄梅县城5",150,24),
                new Student("李五",11,"男","黄梅县城6",150,24),
                new Student("李六",11,"男","黄梅县城7",150,24));
        studentMapper.insertStudentListParams(studentList);
        Assert.assertEquals(3,studentMapper.select().size());  //数值比较
    }

    @Test
    public void insertStudentArrayParams() {
        Student[] students={new Student("李四",11,"男","黄梅县城5",150,24),
                new Student("李五",11,"男","黄梅县城6",150,24),
                new Student("李六",11,"男","黄梅县城7",150,24)};

        studentMapper.insertStudentArrayParams(students);
        Assert.assertEquals(3,studentMapper.select().size());  //数值比较
    }

    @Test
    public void insertStudentMapParams() {
        Map<Integer, Student> map = new HashMap<>();
        map.put(21, new Student("李四",11,"男","黄梅县城5",150,24));  //key =学生id value=学生
        map.put(22, new Student("李四",11,"男","黄梅县城5",150,24));
        map.put(23, new Student("李四",11,"男","黄梅县城5",150,24));
        studentMapper.insertStudentMapParams(map);
        Assert.assertEquals(6,studentMapper.select().size());  //数值比较
    }

    @Test
    public void DeleteStudentListParams() {

        List<Student> studentlist = studentMapper.select();
        List<Integer> studentIds = new ArrayList<>();
        for (Student student : studentlist) {
            if (student.getId() % 6 == 0) {
                studentIds.add(student.getId());
            }
        }
        if (studentIds != null && studentIds.size() > 0) {
            studentMapper.DeleteStudentListParams(studentIds);
        }
        Assert.assertEquals(10,studentMapper.select().size());  //数值比较
    }

    @Test
    public void DeleteStudentArrayParams() {
        Integer[] studentIds = {3, 4};
        studentMapper.DeleteStudentArrayParams(studentIds);
        Assert.assertEquals(8,studentMapper.select().size());  //数值比较
    }

    @Test
    public void DeleteStudentMapParams() {
        Map<Integer, Student> map = new HashMap<>();
        List<Student> studentlist = studentMapper.select();
        //遍历集合
        for (Student s : studentlist) {
            if (s.getId() == 15 || s.getId() == 16 || s.getId() == 17) {
                map.put(s.getId(), s);  //key =学生id value=学生
            }
        }
        studentMapper.DeleteStudentMapParams(map);
        Assert.assertEquals(0,studentMapper.select().size());  //数值比较
    }
}