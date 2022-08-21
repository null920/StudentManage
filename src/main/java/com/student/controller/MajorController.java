package com.student.controller;

import com.student.pojo.Majors;
import com.student.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MajorController {
    @Autowired
    MajorService majorService;

    //专业信息视图
    @GetMapping("/majors")
    public String majorList(Model model, String msg) {
        model.addAttribute("majors", majorService.selectAllMajor());
        if (msg == null) {
            model.addAttribute("msg", "");
        } else if ("addSuccess".equals(msg)) {
            model.addAttribute("msg", "添加成功！");
        } else if ("existing".equals(msg)) {
            model.addAttribute("msg", "添加失败！该专业已存在！");
        } else if ("addError".equals(msg)) {
            model.addAttribute("msg", "添加失败！");
        } else if ("delSuccess".equals(msg)) {
            model.addAttribute("msg", "删除成功！");
        } else if ("delError".equals(msg)) {
            model.addAttribute("msg", "删除失败！该数据可能存在关联数据");
        }
        return "major-table";
    }

    //添加专业功能实现
    @PostMapping("/addMaj")
    public String addMajor(Majors majors) {
        int i = majorService.addMajor(majors.getMajor_Name());
        if (i > 0) {
            return "redirect:/majors?msg=addSuccess";
        } else if (i == -1) {
            return "redirect:/majors?msg=existing";
        } else
            return "redirect:/majors?msg=addError";
    }

    @GetMapping("/delMaj{id}")
    public String delMajor(@PathVariable("id") int id) {
        int i = majorService.delMajor(id);
        if (i > 0) {
            return "redirect:/majors?msg=delSuccess";
        } else
            return "redirect:/majors?msg=delError";
    }

}
