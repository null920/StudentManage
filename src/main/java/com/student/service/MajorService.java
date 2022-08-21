package com.student.service;

import com.student.pojo.Majors;

import java.util.List;

public interface MajorService {
    List<Majors> selectAllMajor();

    int addMajor(String major_Name);

    int delMajor(int id);

}
