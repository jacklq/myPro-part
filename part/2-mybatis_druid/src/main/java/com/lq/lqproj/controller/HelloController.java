package com.lq.lqproj.controller;


import com.alibaba.fastjson.JSONObject;
import com.lq.lqproj.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


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

}