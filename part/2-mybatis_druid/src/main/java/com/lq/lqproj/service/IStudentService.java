package com.lq.lqproj.service;

import com.lq.lqproj.entity.Student;

import java.util.List;

/**
 * (Student)表服务接口
 *
 * @author jack
 * @since 2021-01-09 11:36:03
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


/** ******批量操作-增删改查**************************/
    /**
     * 插入多条数据
     *
     * @param idList id列表
     * @return 影响行数
     */
    Integer insertBatch(List<Student> studentList);

    /**
     * 删除多条数据
     *
     * @param idList id列表
     * @return 影响行数
     */
    Integer deleteBatchByIds(List idList);

    /**
     * 更新多条数据（Foreach方式）
     *
     * @param studentList student列表
     * @return 影响行数
     */
    Integer updateBatchForeach(List<Student> studentList);


    /**
     * 更新多条数据（CaseWhen方式）
     *
     * @param studentList student列表
     * @return 影响行数
     */
    Integer updateBatchCaseWhen(List<Student> studentList);


    /**
     * 查询多条数据
     *
     * @param idList id列表
     * @return 对象列表
     */
    List<Student> queryBatchByIds(List idList);


/** ******其他操作**************************/

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Student> queryAllByLimit(int offset, int limit);


}