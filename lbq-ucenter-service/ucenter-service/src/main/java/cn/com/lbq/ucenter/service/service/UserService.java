package cn.com.lbq.ucenter.service.service;

import cn.com.lbq.ucenter.api.entity.User;
import cn.com.lbq.ucenter.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/4/29 14:02
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User getUser(String userId) {

        User user = userMapper.selectById(userId);
        return user;
    }
}
