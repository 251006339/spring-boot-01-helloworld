package com.hxm.springboot01helloworld.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author XAIOHU
 * @date 2019/9/8 --14:27
 * 可以在连接上携带区域信息  --解析器 国际化
 *
 *
 **/
 //注册到容器 中;   localeResolver locale 必须得不为空;

public class MyLocaleResoler implements LocaleResolver {
    @Override //解析区域信息  国际化对象 locale
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
         //获得请求头信息
        Locale locale=Locale.getDefault();
        String l = httpServletRequest.getParameter("l");
        if(!StringUtils.isEmpty(l)){
            String[] s = l.split("_");
            locale=new Locale(s[0],s[1]);//en_US  英语, 美国;


        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
