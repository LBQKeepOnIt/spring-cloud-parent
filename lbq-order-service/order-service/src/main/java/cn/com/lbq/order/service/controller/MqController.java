package cn.com.lbq.order.service.controller;

import cn.com.lbq.order.api.entity.Order;
import cn.com.lbq.order.service.service.MqSenderService;
import cn.com.lbq.order.service.service.MqStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/5/8 10:47
 */
@RestController
@RequestMapping("/mq")
public class MqController {

    /**
     * spring-boot的配置
     */
//    @Autowired
//    private MqSenderService mqSenderService;

//    @GetMapping("/send")
//    public Object sendMQ(@RequestParam("name") String name){
//       return mqSenderService.send(name);
//    }

    @Autowired
    private MqStreamService mqStreamService;

    @GetMapping("/send")
    public Object sendMQ(@RequestParam("name") String name) {
        Order orderDTO = new Order();
        orderDTO.setId("1234");
        orderDTO.setOrderName(name);
        MessageBuilder<Order> messageBuilder = MessageBuilder.withPayload(orderDTO);
        boolean flag = mqStreamService.output().send(messageBuilder.build());
        return flag;
    }


}
