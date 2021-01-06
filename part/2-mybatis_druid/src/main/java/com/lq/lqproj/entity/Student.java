package com.lq.lqproj.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Student)实体类
 *
 * @author jack
 * @since 2021-01-06 22:34:57
 */
public class Student implements Serializable {
    private static final long serialVersionUID = -80882326410702880L;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getCretim() {
        return cretim;
    }

    public void setCretim(Date cretim) {
        this.cretim = cretim;
    }

}