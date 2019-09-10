package com.hxm.springboot01helloworld.controller;

import com.hxm.springboot01helloworld.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author XAIOHU
 * @date 2019/9/7 --13:04
 **/
@Controller
public class HelloController {
    //搭配是sl4j日志
    //WebMvcConfigurerAdapter 继承这个接口WebMvcConfigurerAdapter 实现方法映射地址请求
    @ResponseBody
    @RequestMapping("/hello")
    public  String hello(@RequestParam("user")String user){
        if(user.equals("aaaa")){
            throw  new UserNotExistException();//如果请求是aaaa就会抛异常
        }

        return "hello world";
    }

    @RequestMapping("/success")
    public  String success(Map<String,Object> map){
        map.put("hello","<h1>你好<h1>");
        map.put("users", Arrays.asList("张三","例子","王五"));

        return "success";
    }



}
