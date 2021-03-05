package com.ys.springcloud;

import com.ys.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="MICROSERVICECLOUD-DEPT", configuration = MyselfRule.class)
@EnableFeignClients("com.ys.service")
public class Consumer80_Feign_App {
    public static void main(String[] args) {
        SpringApplication.run(Consumer80_Feign_App.class,args);
    }
}
