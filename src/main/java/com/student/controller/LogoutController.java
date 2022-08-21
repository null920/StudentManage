package com.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        //清空session
        request.getSession().invalidate();
        return "auth-login";
    }
}
