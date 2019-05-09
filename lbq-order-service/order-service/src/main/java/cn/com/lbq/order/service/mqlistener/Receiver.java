package cn.com.lbq.order.service.mqlistener;

import cn.com.lbq.order.api.entity.Order;
import cn.com.lbq.order.service.service.MqStreamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/5/8 10:52
 */

@Component
@Slf4j
@EnableBinding(MqStreamService.class)
public class Receiver {

    /**
     * spring-boot的配置
     */
//    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
//    public void process(String message) {
//        log.info("Receiver:" + message);
//    }

    /**
     * 接收OrderDTO对象
     * @param message message
     */
    @StreamListener("myMessageOutput")
    @SendTo("myMessageInput")
    public String process(Order message) {
        log.info("message : {}", message);
        return "success";
    }

    @StreamListener("myMessageInput")
    public void success(String message) {
        log.info("message : {}", message);
    }
}
