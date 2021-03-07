package com.lq.lqproj.service.impl;

import com.lq.lqproj.dao.StudentDao;
import com.lq.lqproj.entity.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


class StudentServiceImplTest {
    private Logger logger = LoggerFactory.getLogger(StudentServiceImplTest.class);

    private StudentServiceImpl studentService;
    @BeforeEach
    void setUp() {
        System.out.println("=====before each=====");
        this.studentService =new StudentServiceImpl();

        StudentDao studentDao = Mockito.mock(StudentDao.class);
        this.studentService.setStudentDao(studentDao);
    }

    @AfterEach
    void tearDown() {
        System.out.println("=====after each=====");
    }

    @Test
    void queryByIdTest() {
        Student student=new Student();
        student.setId(111L);
        student.setSex("sss");
        student.setNum("hah");
        student.setSname("liu");
        Mockito.when(this.studentService.getStudentDao().queryById(Mockito.any(Long.class))).thenReturn(student);
        Assertions.assertEquals(student,this.studentService.queryById(1L));
    }
}