package com.student.service.impl;

import com.student.mapper.ClassesMapper;
import com.student.pojo.Classes;
import com.student.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    ClassesMapper classesMapper;

    @Override
    public List<Classes> selectAllClass() {
        return classesMapper.selectAllClass();
    }

    @Override
    @Transactional
    public int addClass(String class_Name) {
        if (classesMapper.isExist(class_Name) == null)
            return classesMapper.addClass(class_Name);
        else
            return -1;
    }

    @Override
    @Transactional
    public int deleteClass(int id) {
        if (classesMapper.totalClassSize(id) == 0)
            return classesMapper.deleteClass(id);
        else return 0;
    }
}
