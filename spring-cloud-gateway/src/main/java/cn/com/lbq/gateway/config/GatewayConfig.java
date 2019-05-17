package cn.com.lbq.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/5/17 13:50
 */
@Component
public class GatewayConfig {

    @Bean
    public ServerCodecConfigurer serverCodecConfigurer() {
        return ServerCodecConfigurer.create();
    }

}
