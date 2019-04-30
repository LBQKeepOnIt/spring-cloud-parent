package cn.com.lbq.ucenter.service.controller;

import cn.com.lbq.ucenter.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: liboqing
 * @CreateDate: 2019/4/29 14:02
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public Object getUser(@RequestParam("userId") String userId){
        return userService.getUser(userId);
    }

}
