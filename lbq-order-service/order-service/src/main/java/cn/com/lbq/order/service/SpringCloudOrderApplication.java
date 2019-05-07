package cn.com.lbq.order.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/4/25 17:01
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("cn.com.lbq.order.service.mapper")
@EnableFeignClients(basePackages = "cn.com.lbq.ucenter.api.client")
public class SpringCloudOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudOrderApplication.class, args);
    }

}
