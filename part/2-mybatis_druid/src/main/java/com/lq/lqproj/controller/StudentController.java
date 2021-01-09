package com.lq.lqproj.controller;

import com.lq.lqproj.entity.Student;
import com.lq.lqproj.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * (Student)表控制层
 *
 * @author jack
 * @since 2021-01-09 11:36:02
 */
@RestController

public class StudentController {
    /**
     * 服务对象
     */
    @Autowired
    private IStudentService studentService;

    /**
     * 新增数据
     * @param student 实例对象
     * @return 影响行数
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Integer insert(@RequestBody Student student) {
        return this.studentService.insert(student);
    }

}