package com.lq.lqproj.dao;

import com.lq.lqproj.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Student)表数据库访问层
 *
 * @author jack
 * @since 2021-01-08 23:03:27
 */
public interface StudentDao {
/**  增删改查 */
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


/**  批量操作 */
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Student> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param student 实例对象
     * @return 对象列表
     */
    List<Student> queryAll(Student student);


    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Student> 实例对象列表
     * @return 影响行数
     */
    Integer insertBatch(@Param("entities") List<Student> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Student> 实例对象列表
     * @return 影响行数
     */
    Integer insertOrUpdateBatch(@Param("entities") List<Student> entities);


}