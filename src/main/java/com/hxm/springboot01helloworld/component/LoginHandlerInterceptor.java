package com.hxm.springboot01helloworld.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

/**
 * @author XAIOHU
 * @date 2019/9/8 --16:33
 * 登陆检查:
 **/
public class LoginHandlerInterceptor  implements HandlerInterceptor{
    @Override //前置拦截
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
       //如果是没有session 就重新登陆; user/login ---main.html 这样走是有是session 的
        Object logUser = httpServletRequest.getSession().getAttribute("loginUser");
        if(logUser==null){
            httpServletRequest.setAttribute("msg","没有权限请登陆");
            //反应未登陆页面  返回到注册页面  获取到转发器. 转发到index.html---login.html
            httpServletRequest.getRequestDispatcher("index.html").forward(httpServletRequest,httpServletResponse);
            return false;
        }else{


            return true;
        }


        //如果有session,



    }

    @Override //后置拦截
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {




    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
