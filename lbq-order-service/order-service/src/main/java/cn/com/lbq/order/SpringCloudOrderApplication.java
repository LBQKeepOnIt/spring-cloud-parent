package cn.com.lbq.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/4/25 17:01
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringCloudOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudOrderApplication.class, args);
    }

}
