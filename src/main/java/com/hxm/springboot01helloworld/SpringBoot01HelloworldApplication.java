package com.hxm.springboot01helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot01HelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot01HelloworldApplication.class, args);

    }
   //crud/ 如果是其他客户端访问,默认响应json数据    timestamp:  path:
  //自动配置
  //原理可以参照ErrorMvcconfig;
   //客户端访问定制错误页面;//其他客户端访问定制错误的json数据
 //ErrorMvcAutoConfiguration   错误mvc 自动配置:
 //DefaultErrorviewResolver  解析错误视图:
//系统出现错误之后--@Value${error.path.://error}
// 到error请求进行处理;:(web/xml) 注册到错误页面规则;
    //basicErrorController:
    //"${server.error.path:${error.path:/error}}"
    //如果没有 server.error.path则选择 error.path 没有选择error;
    //@Controller @Basic
    //server.error.path --error.path 页面处理;
    // error/text.html 访问到这个地址; 两种请求方式, 一种是返回页面:html 一种是返回json数据;
    //浏览器发送请求的请求头.识别<接受accept> 有个text.html 访问 /error/text/html;
    //可以使用4xx 和5xx作为
//     errorAttributes.put("status", 999);
//            errorAttributes.put("error", "None");
//        } else {
//            errorAttributes.put("status", status);
//
//            try {
//                errorAttributes.put("error", HttpStatus.valueOf(status).getReasonPhrase());
//            } catch (Exception var5) {
//                errorAttributes.put("error", "Http Status " + status);
//定义异常消息;          timestamp:时间戳;
//Error
    //DefaultErrorEviewResolver;
    //ErrorPageCustomoizer;系统出现错误,来到error请求进行处理:web.xml注册的错误页面规则;来到/error请求;
    //
    //BasicErrorController  -- value = {ErrorController.class}, 容器中没有这个类就生效这个类;
    //处理了两种请求方式; 产生text/html 类型的数据  accept:<优先接受text.html>;没有accpet-请求到json数据方法
  //响应页面:HttpStatus:
    //所有的errorViewSolver 得到modelAndView;
  //MedelAndView modelAndView=resolver.resove
  //响应页面:去哪个页面是由default
  //默认springboot可以去找到一个页面?error/404
 //templcateAV  @1模板引擎可以解析可以使用这个方法;
    //resourceProper
    //模板引擎不可用.就在静态资源文件夹下找到error;
    //如果定制错误响应:
    //如何定制错误的页面:
    //有模板引擎的情况下,找到状态码; String viewName;
    //发生此状态码的错误就会来到
  //DefaultErrorAttributes  帮我们找status 默认错误属性类,map.put("statuc","") 获得对象
    //页面能获取到信息;
    // tiemstamp;
    //status:状态码;
    //error:错误
    //exception 异常信息;
    //message: 异常信息;
    //

}
