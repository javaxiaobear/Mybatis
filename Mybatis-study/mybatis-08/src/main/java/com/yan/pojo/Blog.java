package com.yan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Blog {
    private int id;
    private String title;
    private String author;
    private Date creat_time;
    private int views;

}
