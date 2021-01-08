package com.lq.lqproj.service.impl;

import com.lq.lqproj.dao.StudentDao;
import com.lq.lqproj.entity.Student;
import com.lq.lqproj.service.IStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Student)表服务实现类
 *
 * @author jack
 * @since 2021-01-08 23:03:28
 */
@Service("studentService")
public class StudentServiceImpl implements IStudentService {
    @Resource
    private StudentDao studentDao;


/** ******增删改查**************************/

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    @Override
    public Integer insert(Student student) {
        return this.studentDao.insert(student);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Override
    public Integer deleteById(Long id) {
        return this.studentDao.deleteById(id);
    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    @Override
    public Integer update(Student student) {
        return this.studentDao.update(student);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Student queryById(Long id) {
        return this.studentDao.queryById(id);
    }

/** ******批量操作**************************/

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Student> queryAllByLimit(int offset, int limit) {
        return this.studentDao.queryAllByLimit(offset, limit);
    }


}