package com.hxm.springboot01helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author XAIOHU
 * @date 2019/9/8 --12:31
 **/
@Controller
public class LoginController {
   //{index.html}
  /*  @GetMapping({"/"})
   public String  getMapping(){


        return "login";
    }*/

    @PostMapping({"/user/login"})
    public String  dashboard(@RequestParam("username")String username, @RequestParam("password") String password, Map<String,Object> maps, HttpSession session){
        System.out.println(username+password);
   if(!StringUtils.isEmpty(username)&&username.equals("admin")){
       session.setAttribute("loginUser","admin");

            //重定向:再执行main.html. url请求.会被拦截,验证session是否有,有放行:
       return "redirect:/main.html"; //登陆成功  重定向防止页面重复提交 1.重新定义url为/main.html 2再请求main.html--到vesolver-dashboard
   }

        maps.put("msg","账号或者密码错误");

        return "login";
    }



}
