package com.lq.lqproj.controller;

import com.lq.lqproj.entity.Student;
import com.lq.lqproj.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Student)表控制层
 *
 * @author jack
 * @since 2021-01-06 22:34:57
 */
@RestController
@RequestMapping("student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Student selectOne(Long id) {
        return this.studentService.queryById(id);
    }

}