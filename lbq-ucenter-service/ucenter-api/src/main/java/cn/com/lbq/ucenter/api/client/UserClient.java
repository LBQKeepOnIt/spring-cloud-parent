package cn.com.lbq.ucenter.api.client;

import cn.com.lbq.spring.cloud.ServiceNameConstants;
import cn.com.lbq.ucenter.api.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/4/29 14:13
 */
@FeignClient(name = ServiceNameConstants.UCENTER_SERVICE,fallbackFactory = UserClientFallbackFactory.class)
public interface UserClient {

    @GetMapping(value = "/user/getUser")
    User getUser(@RequestParam("userId") String userId) throws Throwable;

}
