package cn.com.lbq.ucenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/4/29 13:54
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringCloudUcenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudUcenterApplication.class, args);
    }

}
