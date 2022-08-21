package com.student.controller;

import com.student.pojo.Classes;
import com.student.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ClassController {
    @Autowired
    ClassesService classesService;


    //班级信息视图
    @GetMapping("/classes")
    public String classList(Model model, String msg) {
        model.addAttribute("classes", classesService.selectAllClass());
        if (msg == null) {
            model.addAttribute("msg", "");
        } else if ("delSuccess".equals(msg)) {
            model.addAttribute("msg", "删除成功！");
        } else if ("delError".equals(msg)) {
            model.addAttribute("msg", "删除失败！该数据可能存在关联数据");
        } else if ("addSuccess".equals(msg)) {
            model.addAttribute("msg", "添加成功！");
        } else if ("existing".equals(msg)) {
            model.addAttribute("msg", "添加失败！该班级已存在！");
        } else if ("addError".equals(msg)) {
            model.addAttribute("msg", "添加失败！");
        }
        return "class-table";
    }

    //添加班级功能
    @PostMapping("/addCls")
    public String addCls(Classes classes) {
        int i = classesService.addClass(classes.getClass_Name());
        if (i > 0) {
            return "redirect:/classes?msg=addSuccess";
        } else if (i == -1) {
            return "redirect:classes?msg=existing";
        } else
            return "redirect:/classes?msg=addError";
    }


    //删除班级功能
    @GetMapping("/delCls{id}")
    public String deleteClass(@PathVariable("id") int id) {
        int i = classesService.deleteClass(id);
        if (i > 0)
            return "redirect:/classes?msg=delSuccess";
        else
            return "redirect:/classes?msg=delError";
    }
}
