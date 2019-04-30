package cn.com.lbq.order.service;

import cn.com.lbq.order.api.entity.Order;
import cn.com.lbq.order.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/4/30 15:34
 */
@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    public Order getOrder(String userId) {
        return orderMapper.selectByPrimaryKey(userId);
    }
}
