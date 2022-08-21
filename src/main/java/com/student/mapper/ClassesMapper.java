package com.student.mapper;

import com.student.pojo.Classes;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassesMapper {
    @Select("select * from class_info")
    List<Classes> selectAllClass();

    @Select("select count(*) from student_info where class_No=#{id}")
    int totalClassSize(int id);

    @Select("select * from class_info where class_Name=#{class_Name}")
    Classes isExist(String class_Name);

    @Insert("insert into class_info(class_Name) values (#{class_Name})")
    int addClass(String class_Name);

    @Delete("delete from class_info where id=#{id}")
    int deleteClass(int id);
}
