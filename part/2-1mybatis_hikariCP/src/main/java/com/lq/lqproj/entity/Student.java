package com.lq.lqproj.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2021-01-09 11:36:00
 */

@Data
public class

Student implements Serializable {
    private static final long serialVersionUID = -89315412588872081L;
    /**
     * ID
     */
    private Long id;
    /**
     * 学号
     */
    private String num;
    /**
     * 姓名
     */
    private String sname;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄
     */
    private String age;
    /**
     * 创建时间
     */
    private Date cretim;


}