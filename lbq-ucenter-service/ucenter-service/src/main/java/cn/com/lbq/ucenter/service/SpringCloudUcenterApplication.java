package cn.com.lbq.ucenter.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/4/29 13:54
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableResourceServer
public class SpringCloudUcenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudUcenterApplication.class, args);
    }

}
