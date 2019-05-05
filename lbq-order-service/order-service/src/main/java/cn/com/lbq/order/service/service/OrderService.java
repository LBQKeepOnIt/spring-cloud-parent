package cn.com.lbq.order.service.service;

import cn.com.lbq.order.api.entity.Order;
import cn.com.lbq.order.service.mapper.OrderMapper;
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

    public Order getOrder(String userId) {
        return orderMapper.selectByPrimaryKey(userId);
    }
}
