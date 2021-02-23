package com.ys.springcloud.cfgbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean { //boot -> spring applicationContext.xml
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
//    @Bean
//    public UserService getUserService(){
//        return new UserServiceImpl();
//    }
//<bean id="userService" class="com.ys.service.impl.UserServiceImpl">
