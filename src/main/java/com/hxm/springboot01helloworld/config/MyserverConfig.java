package com.hxm.springboot01helloworld.config;

import com.hxm.springboot01helloworld.server.MyServlet;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRegistration;

/**
 * @author XAIOHU
 * @date 2019/9/10 --17:34
 **/
@Configuration
public class MyserverConfig {
    //注册三大组件
    @Bean //ServletRegistrationBean
public ServletRegistrationBean myServlet(){
    ServletRegistrationBean registrationBean =new ServletRegistrationBean(new MyServlet(),"8087");



    return registrationBean;
}





}
