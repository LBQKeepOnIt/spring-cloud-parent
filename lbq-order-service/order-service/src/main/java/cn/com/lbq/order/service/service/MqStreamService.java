package cn.com.lbq.order.service.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/5/8 13:20
 */
public interface MqStreamService {

    // 接收消息-入口
    @Input("myMessageInput")
    SubscribableChannel input();

    // 发送消息
    @Output("myMessageOutput")
    MessageChannel output();

}
