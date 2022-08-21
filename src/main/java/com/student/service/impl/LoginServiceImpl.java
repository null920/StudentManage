package com.student.service.impl;

import com.student.mapper.ManagerMapper;
import com.student.pojo.Manager;
import com.student.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    ManagerMapper managerMapper;

    @Override
    public Manager managerLogin(String mg_Name, String mg_Password) {
        Manager manager = managerMapper.selectManagerByName(mg_Name);
        if (manager != null && !manager.getMg_Password().equals(mg_Password))
            manager.setMg_Password("");
        return manager;
    }
}
