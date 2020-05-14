package com.yan.pojo;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    //学生关联老师
    private int tid;
}
