###sprongBoot 日记介绍
##1.helloworld
创建maven工程;jar
导入web和test 包;
##2.简化jar包
需要导入插件
~~~properties
  <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
  ~~~                       
##3.配置类
@SpringbootConfiguration--@Configuration
@Component
@EnaleAutoConfiguration :开启自动配置
@AutoConfigurationPackage：自动配置包
@Import(AutoConfigurationPackages.Registrar.class)：需要实现一个接口 导入组件,返回数组可以注册beans
通过导入AutoConfiguration 会导入自动配置类<96>;
有了自动配置类,不需要我们手动导入配置-配置类在spring-boot-autoconfigure-1.5.9.RELEASE.jar；
spring-boot启动的时候会到META-INF/spring.factories中获得所有的EnableAutoConfiguraution配置地址

##4 webjars
webjars/** 下的静态文件映射到classpath:/resources/webjars/**下找静态资源;