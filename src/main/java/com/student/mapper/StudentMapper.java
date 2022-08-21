package com.student.mapper;

import com.student.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//表示这是一个mybatis的mapper类
@Mapper
public interface StudentMapper {
    List<Student> selectStuByLimit(int page);

    Student selectStuById(int id);

    Student selectStuByStuId(String stu_Id);

    int addStu(Student student);

    int updateStu(Student student);

    int delStu(int id);

    int countStu();
}
