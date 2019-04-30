package cn.com.lbq.order.service.controller;

import cn.com.lbq.order.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/4/30 15:29
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getOrder")
    public Object getUser(@RequestParam("orderId") String userId) {
        return orderService.getOrder(userId);
    }

}
