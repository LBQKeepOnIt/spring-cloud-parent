package cn.com.lbq.order.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/5/8 10:46
 */

@Component
@Slf4j
public class MqSenderService {

    /**
     * spring-boot的配置
     */
//    @Autowired
//    private AmqpTemplate rabbitmqTemplate;
//
//    public String send(String name) {
//        String content = "hello" + name + new Date();
//        this.rabbitmqTemplate.convertAndSend("myQueue", content);
//        return content;
//    }


}
