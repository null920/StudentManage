package com.student.service.impl;

import com.student.mapper.MajorsMapper;
import com.student.pojo.Majors;
import com.student.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    MajorsMapper majorsMapper;

    @Override
    public List<Majors> selectAllMajor() {
        return majorsMapper.selectAllMajor();
    }

    @Override
    @Transactional
    public int addMajor(String major_Name) {
        if (majorsMapper.isExisting(major_Name) == null)
            return majorsMapper.addMajor(major_Name);
        else
            return -1;
    }

    @Override
    public int delMajor(int id) {
        if (majorsMapper.totalMajorSize(id) == 0)
            return majorsMapper.delMajor(id);
        else
            return 0;
    }
}
