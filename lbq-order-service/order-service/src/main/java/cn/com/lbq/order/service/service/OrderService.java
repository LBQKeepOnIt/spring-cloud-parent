package cn.com.lbq.order.service.service;

import cn.com.lbq.order.api.entity.Order;
import cn.com.lbq.order.service.mapper.OrderMapper;
import cn.com.lbq.ucenter.api.client.UserClient;
import cn.com.lbq.ucenter.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/4/30 15:34
 */
@Service
@Transactional(rollbackFor = Exception.class,propagation= Propagation.REQUIRES_NEW)
public class OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private UserClient userClient;

    public Order getOrder(String orderId) {
        Order order = orderMapper.getOrderById(orderId);
        try {
            User user = userClient.getUser(order.getUserId());
            String userId = user.getId();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return order;
    }
}
