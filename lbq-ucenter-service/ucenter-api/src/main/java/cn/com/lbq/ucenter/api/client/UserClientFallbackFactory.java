package cn.com.lbq.ucenter.api.client;

import cn.com.lbq.ucenter.api.entity.User;
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
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {

    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public User getUser(String orderId) throws Throwable {
                log.error("查询用户异常", throwable);
                throw new RuntimeException("查询异常");
            }

            @Override
            public User checkNameAndPassword(String name, String password) throws Throwable {
                log.error("查询用户异常", throwable);
                throw new RuntimeException("查询异常");
            }
        };
    }

}