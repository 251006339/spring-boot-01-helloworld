package com.hxm.springboot01helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot01HelloworldApplicationTests {
@Autowired
    ApplicationContext ioc;

    @Test
    public void contextLoads () throws IOException {
        InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream("application.properties");
        Properties properties=new Properties();
        properties.load(systemResourceAsStream);
        Iterator<Map.Entry<Object, Object>> iterator = properties.entrySet().iterator();
        while (iterator.hasNext()){

            Map.Entry<Object, Object> next = iterator.next();
            Object key = next.getKey();
            Object value = next.getValue();
            System.out.println(
                    key+""+value
            );
        }

    }

   /* @Test
    public void contextLoads1 () throws IOException {
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (int i = 0; i <beanDefinitionNames.length ; i++) {
            System.out.println(beanDefinitionNames[i]);
        }



    }*/
}
