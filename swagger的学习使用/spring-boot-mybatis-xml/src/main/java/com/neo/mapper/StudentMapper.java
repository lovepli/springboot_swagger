package com.neo.mapper;

import com.neo.dao.BaseDAO;
import com.neo.model.Student;
import tk.mybatis.mapper.common.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author: lipan
 * @date: 2019-06-17
 * @description:
 */
//public interface StudentMapper extends BaseDAO<Student> {
    public interface StudentMapper  {

    void save(Student student);

    List<Student> select();

    Student selectOne(Integer id);

    //多条件查询
   // Student selectOne3(); //什么都不传递，默认按照性别男来查询
   // Student selectOne3(@Param("name") String name); //可以传递多个参数 按照姓名查询就只传name
   //Student selectOne3(@Param("name") String name,@Param("height") Integer height,@Param("weight") Integer weight); //可以传递多个参数 按照身高和体重查询查询就传两个参数height和weight 还要加一个name参数，但是给null值即可
    Student selectOne3(@Param("name") String name,@Param("id") Integer id);

   // Student selectOne4(@Param("id") Integer id,); //动态条件个数查询 可以选择使用都查询条件  @Param("id") Integer id,是必须要的一个条件
   //Student selectOne4(@Param("id") Integer id,@Param("name") String name);   //两个条件查询
    //Student selectOne4(@Param("id") Integer id,@Param("name") String name,@Param("age") Integer age);  //三个一条件查询
    Student selectOne4(@Param("id") Integer id,@Param("address") String address); //两个条件查询


    Student selectOne2(@Param("id") Integer id, @Param("name") String name);


    List<Student> selectLikeName2(@Param("name") String name);

    List<Student> selectLikeName(@Param("name") String name);

    void update1(Student student);

    void update2(Student student);

    void update4(Student student);

    //通过map数据结构遍历得到集合
    List<Student> getStudentMapParams(Map<Integer,Student> params );  //这里Integer表示ID
    //通过list遍历得到集合
    List<Student> getStudentListParams(List<Integer> studentIds);  //List<String> studentIds 本来的数据类型 这里是id为String类型
    //通过数组遍历得到集合
    List<Student> getStudentArrayParams(Integer[] studentIds);//String[] studentIds

    void DeleteStudentListParams(@Param("studentIds") List<Integer> studentIds);  //一个参数可以不加@Param("studentIds")

    void DeleteStudentArrayParams(Integer[] studentIds);

    void DeleteStudentMapParams(Map<Integer,Student> params );

    void insertStudentListParams(@Param("studentlist")List<Student> studentList);

    void insertStudentArrayParams(@Param("students")Student[] students);

    void insertStudentMapParams(@Param("students") Map<Integer,Student> students );



    List<Student>  selectStudentMapByIds(Map<String,Object> params);

    //动态根据表名和ID主键查询表数据
    Student findByTableAndId(@Param("tableName") String tableName, @Param("id") Integer id);

}
