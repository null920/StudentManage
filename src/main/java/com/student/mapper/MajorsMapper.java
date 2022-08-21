package com.student.mapper;

import com.student.pojo.Majors;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MajorsMapper {
    @Select("select * from major_info")
    List<Majors> selectAllMajor();

    @Select("select count(*) from student_info where stu_Major=#{id}")
    int totalMajorSize(int id);

    @Select("select * from major_info where major_Name=#{major_Name}")
    Majors isExisting(String major_Name);

    @Insert("insert into major_info(major_Name) values(#{major_Name}) ")
    int addMajor(String major_Name);

    @Delete("delete from major_info where id=#{id}")
    int delMajor(int id);
}
