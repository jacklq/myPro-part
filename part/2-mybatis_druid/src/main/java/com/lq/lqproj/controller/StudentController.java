package com.lq.lqproj.controller;

import com.lq.lqproj.entity.Student;
import com.lq.lqproj.service.IStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * (Student)表控制层
 *
 * @author jack
 * @since 2021-01-11 14:46:21
 */
@RestController

public class StudentController {
    private Logger logger = LoggerFactory.getLogger(StudentController.class);
    /**
     * 服务对象
     */
    @Autowired
    private IStudentService studentService;
    /** ************************ 增删改查*******************/
    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Integer insert(@RequestBody Student student) {
        logger.info("插入数据");
        return this.studentService.insert(student);
    }

    /**
     * 删除数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Integer deleteById(@RequestBody Student student) {
        logger.info("删除数据");
        Long id = student.getId();
        return this.studentService.deleteById(id);
    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Integer update(@RequestBody Student student) {
        logger.info("update");
        return this.studentService.update(student);
    }

    /**
     * 查询数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    @RequestMapping(value = "/queryById", method = RequestMethod.POST)
    public Student queryById(@RequestBody Student student) {
        logger.info("删除数据");
        Long id = student.getId();
        return this.studentService.queryById(id);
    }
    /** ************************ 批量操作*******************/
    /**
     * 插入多条数据
     *
     * @param studentList student列表
     * @return 影响行数
     */
    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    public Integer insertBatch(@RequestBody List<Student> studentList) {
        logger.info("插入多条数据");
        return this.studentService.insertBatch(studentList);
    }

    /**
     * 删除多条数据
     *
     * @param idList id列表
     * @return 影响行数
     */
    @RequestMapping(value = "/deleteBatchByIds", method = RequestMethod.POST)
    public Integer deleteBatchByIds(@RequestBody List<Student> studentList) {
        logger.info("删除多条数据");
        List<Long> idList = studentList
                .stream().map(x -> x.getId()).collect(Collectors.toList());

        return this.studentService.deleteBatchByIds(idList);
    }

    /**
     * 更新多条数据（Foreach方式）
     *
     * @param studentList student列表
     * @return 影响行数
     */
    @RequestMapping(value = "/updateBatchForeach", method = RequestMethod.POST)
    public Integer updateBatchForeach(@RequestBody List<Student> studentList) {
        logger.info("更新多条数据（Foreach方式）");
        return this.studentService.updateBatchForeach(studentList);
    }

    /**
     * 更新多条数据（CaseWhen方式）
     *
     * @param studentList student列表
     * @return 影响行数
     */
    @RequestMapping(value = "/updateBatchCaseWhen", method = RequestMethod.POST)
    public Integer updateBatchCaseWhen(@RequestBody List<Student> studentList) {
        logger.info("更新多条数据（CaseWhen方式）");
        return this.studentService.updateBatchCaseWhen(studentList);
    }

    /**
     * /**
     * 查询多条数据
     *
     * @param studentList student列表
     * @return 对象列表
     */
    @RequestMapping(value = "/queryBatchByIds", method = RequestMethod.POST)
    public List<Student> queryBatchByIds(@RequestBody List<Student> studentList) {
        logger.info("查询多条数据");
        List<Long> idList = studentList.stream().map(x -> x.getId()).collect(Collectors.toList());//此处在生成时报路径错误，生成后删除多余行
        return this.studentService.queryBatchByIds(idList);
    }

}