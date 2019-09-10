package com.hxm.springboot01helloworld.config;

import com.hxm.springboot01helloworld.component.LoginHandlerInterceptor;
import com.hxm.springboot01helloworld.component.MyLocaleResoler;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;



/**
 * @author XAIOHU
 * @date 2019/9/7 --15:38
 **/

//使用webmvcconfigAdapter 可以扩展mvc功能  <addInterceptors>拦截器功能,<addFormatters>字符串转时间功能,<addResourceHandlers>映射地址功能;
    //addViewControllers()  哪个地址-哪个请求; 浏览器发送.atgutis 请求来到success
  //  @EnableWebMvc  //全部接管的, springboot 导致webmvcconfig 配置就不会加载到容器;导致失效
            //conditionOnmissBean() 没有bean才导入;
@Configuration
//只需要注册到容器中就会自动执行操作
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }
      //直接可以跳转到success 页面的;
    @Override  //浏览器地址---请求到页面 视图控制器  //viewresolve 拼接 前缀和后缀;
    public void addViewControllers(ViewControllerRegistry registry) {
            //不会写方法,直接从succes1返回字符
        registry.addViewController("/success1").setViewName("success");
        //访问/ 直接是到了index,html
        registry.addViewController("/index.html").setViewName("login");//访问/---index.html
        registry.addViewController("/").setViewName("login");//拦截地址直接到login页面
          //main.html----dashborad  会被拦截
        registry.addViewController("/main.html").setViewName("dashboard");//main.html页面直接到dashborad
}

  @Bean
    public LocaleResolver  localeResolver(){

        return  new MyLocaleResoler();
  }
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
      WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter() {

          @Override //控制段url--返回 字符串.html;
          public void addViewControllers(ViewControllerRegistry registry) {
              super.addViewControllers(registry);
          }

          @Override  //注册拦截器
          //静态资源 :*css. *js springboot已经做好了静态资源的映射;
          public void addInterceptors(InterceptorRegistry registry) {
            /*  registry.addInterceptor(new LoginHandlerInterceptor())
                      //拦截所有url请求.排除哪些请求 .如果是/访问会现组装成一个index.html去方法页面  排除了user/login 拦截
                      .addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login");*/
          }
      };
      return webMvcConfigurerAdapter;
  }

  //注册servlet容器的配置文件  Server-服务
    @Bean  //注册到容器中, 设置手动配置文件  embeddedServletContaionerCustomizer
    public EmbeddedServletContainerCustomizer  embeddedservletcontainercustomizer(){
        EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer = new EmbeddedServletContainerCustomizer() {


            @Override
            public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
                configurableEmbeddedServletContainer.setPort(8089);


            }
        };
        return  embeddedServletContainerCustomizer;
    }


}
