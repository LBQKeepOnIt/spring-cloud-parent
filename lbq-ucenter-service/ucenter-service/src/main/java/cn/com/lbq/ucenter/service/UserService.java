package cn.com.lbq.ucenter.service;

import cn.com.lbq.ucenter.entity.User;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/4/29 14:02
 */
@Service
public class UserService {

    public User getUser(String userId) {

        User user = new User();
        user.setId(1);
        user.setName("wudi");
        user.setAge("18");
        user.setSex("male");
        return user;
    }
}
