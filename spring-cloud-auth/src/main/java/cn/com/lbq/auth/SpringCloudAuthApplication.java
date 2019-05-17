package cn.com.lbq.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/5/9 11:49
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAuthApplication.class, args);
    }


}
