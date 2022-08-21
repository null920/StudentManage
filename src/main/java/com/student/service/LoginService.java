package com.student.service;

import com.student.pojo.Manager;

public interface LoginService {
    Manager managerLogin(String mg_Name, String mg_Password);
}
