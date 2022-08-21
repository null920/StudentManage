package com.student.service;

import com.student.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectStuByLimit(int page);

    Student selectStuById(int id);

    int addStu(Student student);

    int updateStu(Student student);

    int delStu(int id);

    int countStu();
}
