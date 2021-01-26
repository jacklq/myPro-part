package com.lq.lqproj.controller;


import com.alibaba.fastjson.JSONObject;
import com.lq.lqproj.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/*浏览器输入：http://localhost:8081/sptest/hello
 * */
@RestController
public class HelloController {

    private Logger logger= LoggerFactory.getLogger(HelloController.class);

    /*1-获取json字符串*/
    @RequestMapping(value = "/hello1", method = RequestMethod.POST)
    public String sayHello(@RequestBody JSONObject obj) {
        logger.info("第一次交互");
        String hello="hi "+obj.get("name");
        return  hello;
    }
    /*2-获取出传入的参数值*/
    @RequestMapping("hello2")
    public Student sayHello(@RequestParam(value = "name",required = false) String name, @RequestParam(value = "id") Integer id) {
        Student student = new Student();
        student.setId(id);
        student.setSname(name);
        return  student;
    }
    /*3-通过PathVariable注解来绑定请求路径的参数*/
    @RequestMapping("hello3/{id}/{name}")
    public Student sayHello(@PathVariable(value = "id") Integer id, @PathVariable(value = "name") String name) {
        Student student = new Student();
        student.setId(id);
        student.setSname(name);
        return  student;
    }
    /*4-通过RequestParam注解来获取*/
    @RequestMapping("hello4")
    public Student sayHello(@RequestParam(defaultValue = "23") String age,@RequestParam(defaultValue = "aaa")String name) {
        Student student = new Student();
        student.setAge(age);
        student.setSname(name);
        return  student;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public JSONObject sayHello(@RequestBody @Valid Student studentIn, BindingResult bindingResult) {
        logger.info("第一次交互");
        JSONObject jsonObject=new JSONObject();
        String message="success";

        if(bindingResult.hasErrors()){
            message=bindingResult.getAllErrors().get(0).getDefaultMessage();
        }
        jsonObject.put("data",studentIn);
        jsonObject.put("message",message);
        return jsonObject;
    }

}