package com.hxm.springboot01helloworld.component;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author XAIOHU
 * @date 2019/9/10 --15:21
 **/
//注册到容器中
    @Component  //errorAttribute继承DefaultError 默认错误属性; 注册到容器,调用
public  class MyErrorAttributes extends DefaultErrorAttributes {

    //继承了这调用父类方法,
   @Override
   public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
       //调用父类的getErrorAttributes();获得属性;
       Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes,includeStackTrace);
       errorAttributes.put("company","胡学满");
       Map<String,Object> maps = (Map<String,Object>)requestAttributes.getAttribute("ext", 0);

      errorAttributes.put("ext", maps);

       return errorAttributes;
   }



}
