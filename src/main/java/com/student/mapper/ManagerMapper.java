package com.student.mapper;

import com.student.pojo.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ManagerMapper {
    @Select("select * from manager_info where mg_Name = #{mg_Name}")
    Manager selectManagerByName(String mg_Name);
}
