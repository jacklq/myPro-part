package com.lq.lqproj.dao;

import com.lq.lqproj.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Student)表数据库访问层
 *
 * @author jack
 * @since 2021-01-09 11:36:01
 */
@Mapper
public interface StudentDao {
/**  *********增删改查 *******************************/
    /**
     * 1
     * 新增数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    Integer insert(Student student);

    /**
     * 2
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    Integer deleteById(Long id);

    /**
     * 3
     * 修改数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    Integer update(Student student);

    /**
     * 4
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Student queryById(Long id);


/** ************* 批量操作 **************************/

    /**
     * ****1*********
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Student> 实例对象列表
     * @return 影响行数
     */
    Integer insertBatch(@Param("entities") List<Student> entities);

    /**
     * ****2*********
     * 批量删除数据
     *
     * @param idList id列表
     * @return 影响行数
     */
    Integer deleteBatchByIds(@Param("idList") List idList);

    /**
     * ****3*********
     * 批量更新数据（Foreach方式）
     *
     * @param entities List<Student> 实例对象列表
     * @return 影响行数
     */
    Integer updateBatchForeach(@Param("entities") List<Student> entities);

    /**
     * 批量更新数据（CaseWhen方式）
     *
     * @param entities List<Student> 实例对象列表
     * @return 影响行数
     */
    Integer updateBatchCaseWhen(@Param("entities") List<Student> entities);

    /**
     * ****4*********
     * 批量查询数据
     *
     * @param idList id列表
     * @return 影响行数
     */
    List<Student> queryBatchByIds(@Param("idList") List idList);


/** ************* 其他操作 **************************/
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Student> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


}