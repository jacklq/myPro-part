package com.lq.lqproj.service;

import com.lq.lqproj.entity.Student;

import java.util.List;

/**
 * (Student)表服务接口
 *
 * @author jack
 * @since 2021-01-08 23:03:27
 */
public interface IStudentService {
/** ******增删改查**************************/
    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    Integer insert(Student student);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    Integer deleteById(Long id);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    Integer update(Student student);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Student queryById(Long id);


/** ******批量操作**************************/
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Student> queryAllByLimit(int offset, int limit);


}