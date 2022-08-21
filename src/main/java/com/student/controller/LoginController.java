package com.student.controller;

import com.student.pojo.Manager;
import com.student.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/manager/login")
    public String Login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        Manager manager = loginService.managerLogin(username, password);
        if (manager != null && manager.getMg_Password().length() != 0) {
            session.setAttribute("loginUser", username);
            return "redirect:/index";
        } else if (manager == null) {
            model.addAttribute("msg", "账户不存在！");
            return "auth-login";
        } else {
            model.addAttribute("msg", "密码错误！");
            return "auth-login";
        }
    }

    @GetMapping("/index")
    public String Index() {
        return "index";
    }
}
