package com.student.service.impl;

import com.student.mapper.StudentMapper;
import com.student.pojo.Student;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> selectStuByLimit(int page) {
        return studentMapper.selectStuByLimit(page);
    }

    @Override
    public Student selectStuById(int id) {
        return studentMapper.selectStuById(id);
    }

    @Override
    @Transactional
    //由于在mysql中定义了双主键，导致stu_Id字段是可以重复的，所以加一层判断
    public int addStu(Student student) {
        if (studentMapper.selectStuByStuId(student.getStu_Id()) == null)
            return studentMapper.addStu(student);
        else
            return -1;
    }

    @Override
    @Transactional
    public int updateStu(Student student) {
        return studentMapper.updateStu(student);
    }

    @Override
    @Transactional
    public int delStu(int id) {
        return studentMapper.delStu(id);
    }

    @Override
    public int countStu() {
        return studentMapper.countStu();
    }
}
