package com.student.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String stu_Id;
    private String stu_Name;
    //0 女 1 男
    private int stu_Gender;
    private int stu_Age;
    private Classes class_No;
    private Majors stu_Major;
}
