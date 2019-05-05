package cn.com.lbq.order.api.client;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/4/30 16:40
 */
@Component
@Slf4j
public class OrderClientFallbackFactory implements FallbackFactory<OrderClient> {

    @Override
    public OrderClient create(Throwable throwable) {
        return new OrderClient() {
            @Override
            public Boolean getOrder(String orderId){
                log.error("查询订单异常", throwable);
                throw new RuntimeException("查询异常");
            }
        };
    }

}