package com.student.controller;

import com.student.pojo.Classes;
import com.student.pojo.Majors;
import com.student.pojo.Student;
import com.student.service.ClassesService;
import com.student.service.MajorService;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassesService classesService;
    @Autowired
    private MajorService majorService;

    //所有学生的表
    @GetMapping("/stus{page}")
    public String stuList(Model model, String msg, @PathVariable("page") int page) {
        List<Student> students = studentService.selectStuByLimit((page - 1) * 5);
        model.addAttribute("stus", students);
        int pages = studentService.countStu();
        if (pages % 5 == 0)
            pages /= 5;
        else
            pages = pages / 5 + 1;
        model.addAttribute("countPage", pages);
        model.addAttribute("currentPage", page);
        if (msg == null) {
            model.addAttribute("msg", "");
        } else if ("addSuccess".equals(msg)) {
            model.addAttribute("msg", "添加成功!");
        } else if ("addError".equals(msg)) {
            model.addAttribute("msg", "添加失败!");
        } else if ("existing".equals(msg)) {
            model.addAttribute("msg", "添加失败！该学号已存在！");
        } else if ("delSuccess".equals(msg)) {
            model.addAttribute("msg", "删除成功!");
        } else if ("delError".equals(msg)) {
            model.addAttribute("msg", "删除失败!");
        } else if ("uptSuccess".equals(msg)) {
            model.addAttribute("msg", "更新成功!");
        } else if ("uptError".equals(msg)) {
            model.addAttribute("msg", "更新失败!");
        }
        return "student-table";
    }

    //添加学生信息页面
    @GetMapping("/addStu")
    public String addStu(Model model) {
        //获取所有的班级，传给视图渲染
        List<Classes> classList = classesService.selectAllClass();
        model.addAttribute("classes", classList);
        List<Majors> majorList = majorService.selectAllMajor();
        model.addAttribute("majors", majorList);
        return "stu-add";
    }

    //添加学生功能实现
    @PostMapping("/add")
    public String add(Student student) {
        System.out.println("add==>" + student);
        int i = studentService.addStu(student);
        if (i > 0) {
            return "redirect:/stus1?msg=addSuccess";
        } else if (i == -1) {
            return "redirect:/stus1?msg=existing";
        } else
            return "redirect:/stus1?msg=addError";
    }

    //修改学生信息页面
    @GetMapping("/updateStu{id}")
    public String updateStu(@PathVariable("id") int id, Model model) {
        Student student = studentService.selectStuById(id);
        model.addAttribute("stu", student);
        List<Classes> classList = classesService.selectAllClass();
        model.addAttribute("classes", classList);
        List<Majors> majorList = majorService.selectAllMajor();
        model.addAttribute("majors", majorList);
        return "stu-modify";
    }

    //修改学生信息功能
    @PostMapping("/update")
    public String updateStu(Student student) {
        int i = studentService.updateStu(student);
        if (i > 0) {
            return "redirect:/stus1?msg=uptSuccess";
        } else
            return "redirect:/stus1?msg=uptError";
    }

    //删除学生信息功能
    @GetMapping("/del{id}")
    public String deleteStu(@PathVariable("id") int id) {
        int i = studentService.delStu(id);
        if (i > 0)
            return "redirect:/stus1?msg=delSuccess";
        else
            return "redirect:/stus1?msg=delError";
    }

}
