package cn.com.lbq.ucenter.controller;

import cn.com.lbq.ucenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/4/29 14:02
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public Object getUser(String userId){
        return userService.getUser(userId);
    }

}
