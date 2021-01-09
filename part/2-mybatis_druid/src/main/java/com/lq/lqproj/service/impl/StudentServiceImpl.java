package com.lq.lqproj.service.impl;

import com.lq.lqproj.dao.StudentDao;
import com.lq.lqproj.entity.Student;
import com.lq.lqproj.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * (Student)表服务实现类
 *
 * @author jack
 * @since 2021-01-09 11:36:01
 */
@Service("studentService")
@Transactional(rollbackFor = Exception.class)/*发生异常则回滚*/
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentDao studentDao;


/** ******增删改查**************************/

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 影响行数
     */

    public Integer insert(Student student) {
        return this.studentDao.insert(student);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */

    public Integer deleteById(Long id) {
        return this.studentDao.deleteById(id);
    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 影响行数
     */

    public Integer update(Student student) {
        return this.studentDao.update(student);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */

    public Student queryById(Long id) {
        return this.studentDao.queryById(id);
    }

/** ******批量操作**************************/
    /**
     * 插入多条数据
     *
     * @param studentList  student列表
     * @return 影响行数
     */
    public Integer insertBatch(List<Student> studentList) {
        return this.studentDao.insertBatch(studentList);

    }

    /**
     * 删除多条数据
     *
     * @param idList id列表
     * @return 影响行数
     */
    public Integer deleteBatchByIds(List idList) {
        return this.studentDao.deleteBatchByIds(idList);
    }

    /**
     * 更新多条数据（Foreach方式）
     *
     * @param studentList student列表
     * @return 影响行数
     */
    public Integer updateBatchForeach(List<Student> studentList) {
        return this.studentDao.updateBatchForeach(studentList);

    }

    /**
     * 更新多条数据（CaseWhen方式）
     *
     * @param studentList student列表
     * @return 影响行数
     */
    public Integer updateBatchCaseWhen(List<Student> studentList) {
        return this.studentDao.updateBatchCaseWhen(studentList);
    }

    /**
     * 查询多条数据
     *
     * @param idList id列表
     * @return 对象列表
     */
    public List<Student> queryBatchByIds(List idList) {
        return this.studentDao.queryBatchByIds(idList);

    }


/** ******其他操作**************************/


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */

    public List<Student> queryAllByLimit(int offset, int limit) {
        return this.studentDao.queryAllByLimit(offset, limit);
    }


}