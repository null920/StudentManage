package com.student.service;

import com.student.pojo.Classes;

import java.util.List;

public interface ClassesService {
    List<Classes> selectAllClass();

    int addClass(String class_Name);

    int deleteClass(int id);
}
