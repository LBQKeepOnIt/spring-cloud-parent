package cn.com.lbq.ucenter.service.service;

import cn.com.lbq.ucenter.api.entity.User;
import cn.com.lbq.ucenter.api.entity.UserPower;
import cn.com.lbq.ucenter.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private UserPowerService userPowerService;

    public User getUser(String userId) {

        User user = userMapper.selectById(userId);
        return user;
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveUserAndPo(User user, UserPower userPower){
        //保存用户
        userMapper.insert(user);
        //保存po
        try {
            userPowerService.saveUserPower(userPower);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
