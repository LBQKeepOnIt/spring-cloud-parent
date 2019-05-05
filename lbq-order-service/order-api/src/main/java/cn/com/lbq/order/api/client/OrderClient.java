package cn.com.lbq.order.api.client;

import cn.com.lbq.spring.cloud.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/4/30 16:34
 */
@FeignClient(name = ServiceNameConstants.ORDER_SERVICE,fallbackFactory = OrderClientFallbackFactory.class)
public interface OrderClient {

    @GetMapping(value = "/order/getOrder")
    Boolean getOrder(@RequestParam("orderId") String orderId) throws Throwable;

}
