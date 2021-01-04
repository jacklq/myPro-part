package com.lq.lqproj.entity;

import lombok.Data;

import java.util.Date;
/*@Data不起作用则在setting的plugins处安装lombok插件*/
@Data
public class Student {
    private Integer id;

    private String num;

    private String sname;

    private String sex;

    private String age;

    private Date cretim;

}