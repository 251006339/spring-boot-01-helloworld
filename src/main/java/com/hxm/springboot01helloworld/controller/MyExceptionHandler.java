package com.hxm.springboot01helloworld.controller;

import com.hxm.springboot01helloworld.exception.UserNotExistException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author XAIOHU
 * @date 2019/9/10 --14:32
 * //自定义异常json数据 ..如果是自定义的异常, 响应的是自己定义的json数据
 **/
@ControllerAdvice
public class MyExceptionHandler {
    //浏览器返回的是json数据   --转发到请求/error就可以连接到Errorcontroller 的请求;
   /* @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map handlerException(Exception e){
        Map<String,Object> map=new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());

        return map;

    }*/

    @ExceptionHandler(UserNotExistException.class) //不能解析错误状态码,就访问默认的
    public String handlerException(Exception e, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>(); //传入我们自己的状态码
        map.put("code","user.notexist");
        map.put("message",e.getMessage()); //设置状态码不设置就是200的默认的状态码
        //  Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code"); 设置状态码返回到具体的页面尙
        request.setAttribute("javax.servlet.error.status_code","200");//设置错误的页面的状态码是400 UserNotExistException 返回的就是400页面
        request.setAttribute("ext",map);
          //转发到/error请求
        return "forword:/error";

    }


}
